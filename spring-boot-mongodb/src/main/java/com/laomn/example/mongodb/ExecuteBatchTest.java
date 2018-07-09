package com.laomn.example.mongodb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExecuteBatchTest {
	private Connection conn;
	private PreparedStatement pstmt;
	private PreparedStatement pstmt2;
	private ResultSet rs;
	private String user = "root";
	private String password = "123456";
	private String dbUrl = "jdbc:mysql://localhost:3306/user?rewriteBatchedStatements=true";
	private int limitNum = 1000000;

	public void changeData() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, user, password);

			// 既不用batch,也不用事务
			// testBatch("既不用batch,也不用事务", false, false);
			// 只用batch, 不用事务
			testBatch("只用batch, 不用事务", false, true);
			// 只用事务，不用batch
			testBatch("只用事务，不用batch", true, false);
			// 不仅用事务，还用batch
			testBatch("不仅用事务，还用batch", true, true);

			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void testBatch(String msg, Boolean openTransaction, Boolean useBatch) throws SQLException {
		if (openTransaction)
			conn.setAutoCommit(false);

		if (pstmt != null) {
			pstmt.clearParameters();
			pstmt.clearBatch();
		}

		pstmt = conn.prepareStatement("insert into person (name) values (?)");
		long start = System.currentTimeMillis();
		for (int a = 0; a < limitNum; a++) {
			String name = "ruqing - " + a;
			pstmt.setString(1, name);
			if (useBatch) {
				pstmt.addBatch();

				if (a > 0 && a % 100000 == 0) {
					pstmt.executeBatch();
					// 如果不想出错后，完全没保留数据，则可以没执行一次提交一次，但得保证数据不会重复
					if (openTransaction)
						conn.commit();
				}

			} else {
				pstmt.executeUpdate();
			}
		}

		if (useBatch) {
			pstmt.executeBatch();
			// pstmt.close();

		}

		if (openTransaction) {
			conn.commit();
			conn.setAutoCommit(true);
			// conn.close();
		}
		long end = System.currentTimeMillis();
		System.out.println(msg + ":   use time:" + (end - start) + " ms");

	}

	// main method
	public static void main(String[] args) {
		ExecuteBatchTest ebt = new ExecuteBatchTest();
		ebt.changeData();
	}

}