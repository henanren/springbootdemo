package com.laomn.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.RandomAccessFile;

public class LineNumberReaderTest {
	private static RandomAccessFile rf;

	public static void main(String[] args) throws Throwable {
		test();
		// int lineNumber = getFileLineNumber("‪d:/single.txt");
		//
		// System.out.println("the line number of specified file is " +
		// lineNumber);
		//
		// long lines = Files.lines(Paths.get(new
		// File("E:\\single.txt").getPath())).count();
		// System.out.println("the line number of specified file is " + lines);
	}

	public static int getFileLineNumber(String filePath) throws Exception {
		File file = new File("E:\\single.txt");
		if (!file.exists()) {
			System.out.println(123);
			return 0;
		}
		LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(file));
		// it will return the number of characters actually skipped
		lineNumberReader.skip(Long.MAX_VALUE);

		int lineNumber = lineNumberReader.getLineNumber();

		lineNumber++;

		rf = new RandomAccessFile("E:\\single.txt ", "r");

		rf.seek(lineNumber);
		String line = new String(rf.readLine().getBytes("ISO-8859-1"), "UTF-8");
		System.out.println(line);

		lineNumberReader.close();

		return lineNumber;
	}

	public static void test() throws Throwable {
		String pathName = "E:\\single.txt ";
		String myCharset = "UTF-8";// 因为hello.txt使用UTF-8字符集
		LineNumberReader lnr = new LineNumberReader(new InputStreamReader(new FileInputStream(pathName), myCharset));

		String line = null;
		while ((line = lnr.readLine()) != null) {
			// getLineNumber 可得到行号挺好用的

			if (lnr.getLineNumber() == 3) {
				// 如果行号为3了，那么将原本是3的行号改为10
				lnr.setLineNumber(10);
				System.out.println(lnr.getLineNumber() + ":" + line);
			}

		}

		lnr.close();
	}
}
