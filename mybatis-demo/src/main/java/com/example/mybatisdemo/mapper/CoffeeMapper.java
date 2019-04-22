package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.model.Coffee;

//@Mapper
public interface CoffeeMapper {
//    @Insert("insert into t_coffee(name,price) values(#{name},#{price})")
    int save(Coffee coffee);
}
