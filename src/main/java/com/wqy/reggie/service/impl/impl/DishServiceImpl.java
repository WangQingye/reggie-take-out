package com.wqy.reggie.service.impl.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wqy.reggie.dto.DishDto;
import com.wqy.reggie.entity.Dish;
import com.wqy.reggie.mapper.DishMapper;
import com.wqy.reggie.service.impl.DishFlavorService;
import com.wqy.reggie.service.impl.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {

    @Autowired
    private DishFlavorService dishFlavorService;

    @Override
    public void saveWithFlavor(DishDto dishDto) {
        // 保存菜品
        this.save(dishDto);
        // 保存完之后就已经是
        Long dishId = dishDto.getId();
        dishFlavorService.saveBatch()
    }
}
