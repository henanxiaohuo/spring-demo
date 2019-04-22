package com.example.mybatisdemo.model;

import lombok.*;
import org.joda.money.Money;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Coffee {
    private Long id;
    private String name;
    private Money price;
    private Date createTime;
    private Date updateTime;
}
