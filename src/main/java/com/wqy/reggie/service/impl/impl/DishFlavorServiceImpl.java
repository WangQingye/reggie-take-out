package com.wqy.reggie.service.impl.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wqy.reggie.entity.DishFlavor;
import com.wqy.reggie.mapper.DishFlavorMapper;
import com.wqy.reggie.service.impl.DishFlavorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
