package com.bionime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//其中@SpringBootApplication 申明让 spring boot 自动给程序进行必要的配置，等价于以默认属性使用
//@Configuration，@EnableAutoConfiguration 和@ComponentScan
//@RestController 返回 json 字符串的数据，直接可以编写 RESTFul 的接口；
@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
