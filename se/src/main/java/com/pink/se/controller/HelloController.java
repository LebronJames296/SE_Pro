package com.pink.se.controller;

import com.pink.se.model.Category;
import com.pink.se.response.RespBean;
import com.pink.se.service.CategoryService;
import com.pink.se.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



/**
 * 测试控制器
 */
@RestController
public class HelloController {

    @Autowired
    PositionService positionService;
    @Autowired
    CategoryService categoryService;


    @RequestMapping("/hello")
    public RespBean hello(){
        return  RespBean.success("Hello World");
    }


    @GetMapping("/get")
    public RespBean getAllPosition(){
         return RespBean.success("查询成功",positionService.getAllPosition());
    }

    @PutMapping("/category")
    public RespBean addCategory(@RequestBody Category category ){
        if (categoryService.addCategory(category)){
            return RespBean.success("添加成功");
        }else{
            return RespBean.fail("添加失败");
        }

    }





}
