package com.example.mybatisdemo;

import com.example.mybatisdemo.mapper.CoffeeMapper;
import com.example.mybatisdemo.model.Coffee;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
@MapperScan("com.example.mybatisdemo.mapper")
public class MybatisDemoApplication implements ApplicationRunner {
	@Autowired
    private CoffeeMapper coffeeMapper;
	public static void main(String[] args) {
		SpringApplication.run(MybatisDemoApplication.class, args);

	}
	@Override
	public void run(ApplicationArguments args) throws Exception{
		Logger logger = LoggerFactory.getLogger(MybatisDemoApplication.class);
		Coffee coffee = Coffee.builder().name("natie")
				.price(Money.of(CurrencyUnit.of("CNY"),25.0))
				.build();
		int count = coffeeMapper.save(coffee);
		log.info("count：{}",count);
	}

}


