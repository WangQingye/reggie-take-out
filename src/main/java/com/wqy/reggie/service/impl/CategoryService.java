package com.wqy.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wqy.reggie.entity.Category;

public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
