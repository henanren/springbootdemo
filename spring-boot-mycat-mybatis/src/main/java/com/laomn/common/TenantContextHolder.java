package com.laomn.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.laomn.Caller;

@Service
public class TenantContextHolder {

	private ThreadLocal<String> tenantThreadLocal = new ThreadLocal<String>();

	private Map<Long, String> CACHE = new HashMap<Long, String>();

	public void setTenant(String scheme) {

		Caller caller = (Caller) SpringContext.getBean(Caller.class);

		CACHE.put(Thread.currentThread().getId(), scheme);
		tenantThreadLocal.set(scheme);

	}

	public String getTenant() {
		String scheme = tenantThreadLocal.get();
		// if (scheme == null) {
		// scheme = "";
		long id = Thread.currentThread().getId();
		scheme = CACHE.get(id);
		// }
		return scheme;
	}

	public final void remove() {
		tenantThreadLocal.remove();
	}

}