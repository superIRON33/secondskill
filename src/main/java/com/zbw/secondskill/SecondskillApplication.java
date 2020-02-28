package com.zbw.secondskill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.zbw.secondskill")
@MapperScan("com.zbw.secondskill.dao")
public class SecondskillApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondskillApplication.class, args);
	}

}
