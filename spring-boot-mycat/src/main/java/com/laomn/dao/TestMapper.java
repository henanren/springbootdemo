package com.laomn.dao;

import java.util.Map;

import com.laomn.entites.Test;

public interface TestMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table test
	 *
	 * @mbggenerated Tue May 22 15:38:04 CST 2018
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table test
	 *
	 * @mbggenerated Tue May 22 15:38:04 CST 2018
	 */
	int insert(Test record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table test
	 *
	 * @mbggenerated Tue May 22 15:38:04 CST 2018
	 */
	int insertSelective(Test record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table test
	 *
	 * @mbggenerated Tue May 22 15:38:04 CST 2018
	 */
	Test selectByPrimaryKey(Long id);

	Test selectByName1(Map<String, String> map);

	Test selectByName(String name);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table test
	 *
	 * @mbggenerated Tue May 22 15:38:04 CST 2018
	 */
	int updateByPrimaryKeySelective(Test record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table test
	 *
	 * @mbggenerated Tue May 22 15:38:04 CST 2018
	 */
	int updateByPrimaryKey(Test record);
}