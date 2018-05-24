// package com.laomn.interceptor;
//
// import org.apache.commons.lang.StringUtils;
// import org.hibernate.EmptyInterceptor;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
//
// import com.laomn.common.TenantContextHolder;
//
// public class ChangeSchemaInterceptor extends EmptyInterceptor {
// /**
// *
// */
// private static final long serialVersionUID = 7302283021933147127L;
// private static final String SCHEMA_START = "/*!mycat:schema=";
// private static final String SCHEMA_END = " */";
// private static Logger logger =
// LoggerFactory.getLogger(ChangeSchemaInterceptor.class);
//
// @Override
// public String onPrepareStatement(String sql) {
// String schema_name = TenantContextHolder.getTenant();
// String full_sql = sql;
// if (StringUtils.isNotEmpty(schema_name)) {
// String mycat_annotation = SCHEMA_START + schema_name + SCHEMA_END;
// full_sql = mycat_annotation + sql;
// }
// logger.info("prepare " + sql);
// return super.onPrepareStatement(full_sql);
// }
//
// }