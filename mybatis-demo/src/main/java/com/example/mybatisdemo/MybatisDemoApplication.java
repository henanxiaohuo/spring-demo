package com.example.mybatisdemo;

import com.example.mybatisdemo.mapper.CoffeeMapper;
import com.example.mybatisdemo.model.Coffee;
import com.github.pagehelper.PageHelper;
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

import java.util.List;

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
//		Coffee coffee = Coffee.builder().name("zuixin")
//				.price(Money.of(CurrencyUnit.of("CNY"),255.0))
//				.build();
//		int count = coffeeMapper.save(coffee);
//		log.info("count：{}",count);
		pageMethod();
	}
   public void pageMethod(){
	   PageHelper.startPage(3,2);
	   List<Coffee> list = coffeeMapper.findAll();
	   log.info("获取分页结果是:{}",list);

   }
}


