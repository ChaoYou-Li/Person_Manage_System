package cn.zdxh.personnelmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.zdxh.personnelmanage.mapper") //包扫描
@SpringBootApplication
public class PersonnelmanageApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonnelmanageApplication.class, args);
	}

}
