/*
* Conditions Of Use
*
* This software was developed by employees of the Sigmatrix(Beijing) Corporation.
* This software is provided by sigmatrix as a service and is expressly
* provided "AS IS."  Sigmatrix MAKES NO WARRANTY OF ANY KIND, EXPRESS, IMPLIED
* OR STATUTORY, INCLUDING, WITHOUT LIMITATION, THE IMPLIED WARRANTY OF
* MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, NON-INFRINGEMENT
* AND DATA ACCURACY.  Sigmatrix does not warrant or make any representations
* regarding the use of the software or the results thereof, including but
* not limited to the correctness, accuracy, reliability or usefulness of
* the software.
*
* Permission to use this software is contingent upon your acceptance
* of the terms of this agreement.
*
*/
package com.laomn.example.mongodb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import com.mongodb.MongoClientURI;
import com.mongodb.ReadPreference;

/**
 * @ClassName: MongoConfig
 * @Description: 
 * @author liuzelei
 * @date 2017年8月17日 下午5:23:10
 */
@ConfigurationProperties(prefix = "spring.data.mongodb")
@Configuration
public class MongoConfig {
	private static final Logger LOGGER = LoggerFactory.getLogger(MongoConfig.class);
	private String uri;

	public MongoDbFactory mongoDbFactory() throws Exception {
		LOGGER.info("spring.data.mongodb.uri={}", uri);
		System.err.println(uri);
		return new SimpleMongoDbFactory(new MongoClientURI(uri));
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {

		// remove _class
		MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory()),
				new MongoMappingContext());
		converter.setTypeMapper(new DefaultMongoTypeMapper(null));

		// 设置读写分离策略
		ReadPreference preference = ReadPreference.secondaryPreferred();
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(), converter);
		mongoTemplate.setReadPreference(preference);
		mongoTemplate.getDb().setReadPreference(ReadPreference.secondaryPreferred());
		mongoTemplate.getDb().slaveOk();
		return mongoTemplate;

	}

	/**
	 * @return the uri
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * @param uri the uri to set
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

}
