package com.wqy.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wqy.reggie.common.R;
import com.wqy.reggie.entity.Category;
import com.wqy.reggie.service.impl.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 新增分类
     * @param category
     * @return
     */
    @PostMapping
    public R<String> save(HttpServletRequest request, @RequestBody Category category) {
        log.info("新增分类，分类信息：{}", category.toString());
        categoryService.save(category);
        return R.success("新增分类成功");
    }

    /**
     * 分页查询分类
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String name) {
        Page pageInfo = new Page(page, pageSize);

        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.orderByAsc(Category::getSort);

        categoryService.page(pageInfo, queryWrapper);
        return R.success(pageInfo);
    }

    /**
     * 删除分类
     */
    @DeleteMapping
    public R<String> delete(Long id) {
        categoryService.remove(id);
        return R.success("删除成功");
    }


    /**
     * 编辑分类
     *
     * @param category
     * @return
     */
    @PutMapping
    public R<String> update(HttpServletRequest request, @RequestBody Category category) {

//        category.setUpdateTime(LocalDateTime.now());
//        Long empId = (Long) request.getSession().getAttribute("category");
//        category.setUpdateUser(empId);

        log.info("编辑分类，分类信息：{}", category.toString());
        categoryService.updateById(category);

        return R.success("编辑分类成功");
    }

    @GetMapping("/list")
    public R<List<Category>> list(Category category) {
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.eq(category.getType() != null, Category::getType, category.getType());
        queryWrapper.orderByAsc(Category::getSort).orderByDesc(Category::getUpdateTime);

        List<Category> list = categoryService.list(queryWrapper);

        return R.success(list);
    }
}
