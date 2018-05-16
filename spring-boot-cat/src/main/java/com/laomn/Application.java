package com.laomn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
//@ComponentScan(basePackages = {"com.laomn.example.mongodb"})
//@RequestMapping("/")
@RestController
//@EnableAutoConfiguration
public class Application {

	

	    public static void main(String[] args) {
	        SpringApplication.run(Application.class, args);
	    }
	    @RequestMapping("/2")
		public String test2() {
			return "2";
		}
	  

}
