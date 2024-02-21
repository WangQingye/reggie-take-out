package com.wqy.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wqy.reggie.dto.DishDto;
import com.wqy.reggie.entity.Dish;

public interface DishService extends IService<Dish> {
    public void saveWithFlavor(DishDto dishDto);
}
