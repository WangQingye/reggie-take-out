package com.wqy.reggie.service.impl.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wqy.reggie.common.CustomException;
import com.wqy.reggie.entity.Category;
import com.wqy.reggie.entity.Dish;
import com.wqy.reggie.entity.Setmeal;
import com.wqy.reggie.mapper.CategoryMapper;
import com.wqy.reggie.service.impl.CategoryService;
import com.wqy.reggie.service.impl.DishService;
import com.wqy.reggie.service.impl.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private DishService dishService;
    @Autowired
    private SetmealService setmealService;

    /**
     * 根据id删除分类，删除前需判断是否关联了菜品或套餐
     *
     * @param id
     */
    @Override
    public void remove(Long id) {
        LambdaQueryWrapper<Dish> dishWrapper = new LambdaQueryWrapper<>();
        dishWrapper.eq(Dish::getCategoryId, id);
        int dishCount = dishService.count(dishWrapper);
        if (dishCount > 0) {
            throw new CustomException("当前分类下有菜品");
        }

        LambdaQueryWrapper<Setmeal> setmealWrapper = new LambdaQueryWrapper<>();
        setmealWrapper.eq(Setmeal::getCategoryId, id);
        int setmealCount = setmealService.count(setmealWrapper);
        if (setmealCount > 0) {
            throw new CustomException("当前分类下有套餐");
        }
        super.removeById(id);
    }
}
