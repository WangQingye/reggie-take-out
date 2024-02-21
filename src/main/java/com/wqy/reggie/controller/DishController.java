package com.wqy.reggie.controller;

import com.wqy.reggie.common.R;
import com.wqy.reggie.dto.DishDto;
import com.wqy.reggie.service.impl.DishFlavorService;
import com.wqy.reggie.service.impl.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dish")
public class DishController {

    @Autowired
    private DishService dishService;

    @Autowired
    private DishFlavorService dishFlavorService;

    @PostMapping
    public R<String> save(@RequestBody DishDto dish) {

    }
}
