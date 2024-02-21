package com.wqy.reggie.dto;

import com.wqy.reggie.entity.Dish;
import com.wqy.reggie.entity.DishFlavor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 注意该类继承了Dish
 */
@Data
public class DishDto extends Dish {
    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}