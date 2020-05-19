package com.zm.wte;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

@ServletComponentScan
@Configuration
@MapperScan("com.zm.wte.**.dao")
@SpringBootApplication
public class WteApplication {

	public static void main(String[] args) {
		SpringApplication.run(WteApplication.class, args);
		System.out.println("============zm===========");
	}

}
