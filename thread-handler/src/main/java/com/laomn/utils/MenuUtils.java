package com.laomn.utils;

import java.util.Map;

/**
 * 
 * @author Administrator
 *
 */
public class MenuUtils {
	/**
	 * 
	 * @param model
	 * @param menu
	 */
	public static void setMenu(Map<String, Object> model, String menu) {
		if ("queue".equals(menu)) {
			model.put("queue_menu", 1);
			model.put("first_menu", 0);
			model.put("status_menu", 0);
			model.put("thread_menu", 0);
		} else if ("status".equals(menu)) {
			model.put("queue_menu", 0);
			model.put("first_menu", 0);
			model.put("status_menu", 1);
			model.put("thread_menu", 0);
		} else if ("thread".equals(menu)) {
			model.put("queue_menu", 0);
			model.put("first_menu", 0);
			model.put("status_menu", 0);
			model.put("thread_menu", 1);
		} else if ("first".equals(menu)) {
			model.put("queue_menu", 0);
			model.put("first_menu", 1);
			model.put("status_menu", 0);
			model.put("thread_menu", 0);
		}

	}
}
