package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.model.Coffee;

import java.util.List;

public interface CoffeeMapper {
    int save(Coffee coffee);
    List<Coffee> findAll();
}
