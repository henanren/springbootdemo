package com.laomn.entites;

import java.util.Date;

public class Test {
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column test.id
	 *
	 * @mbggenerated Tue May 22 15:38:04 CST 2018
	 */
	private Long id;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column test.name
	 *
	 * @mbggenerated Tue May 22 15:38:04 CST 2018
	 */
	private String name;

	private String name1;

	public final String getName1() {
		return name1;
	}

	public final void setName1(String name1) {
		this.name1 = name1;
	}

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database column test.cre_time
	 *
	 * @mbggenerated Tue May 22 15:38:04 CST 2018
	 */
	private Date creTime;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column test.id
	 *
	 * @return the value of test.id
	 *
	 * @mbggenerated Tue May 22 15:38:04 CST 2018
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column test.id
	 *
	 * @param id
	 *            the value for test.id
	 *
	 * @mbggenerated Tue May 22 15:38:04 CST 2018
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column test.name
	 *
	 * @return the value of test.name
	 *
	 * @mbggenerated Tue May 22 15:38:04 CST 2018
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column test.name
	 *
	 * @param name
	 *            the value for test.name
	 *
	 * @mbggenerated Tue May 22 15:38:04 CST 2018
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column test.cre_time
	 *
	 * @return the value of test.cre_time
	 *
	 * @mbggenerated Tue May 22 15:38:04 CST 2018
	 */
	public Date getCreTime() {
		return creTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of
	 * the database column test.cre_time
	 *
	 * @param creTime
	 *            the value for test.cre_time
	 *
	 * @mbggenerated Tue May 22 15:38:04 CST 2018
	 */
	public void setCreTime(Date creTime) {
		this.creTime = creTime;
	}

	@Override
	public String toString() {
		return "id=" + id;
	}
}