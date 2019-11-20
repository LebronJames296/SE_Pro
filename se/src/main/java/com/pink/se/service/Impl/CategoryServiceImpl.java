package com.pink.se.service.Impl;

import com.pink.se.mapper.CategoryMapper;
import com.pink.se.model.Category;
import com.pink.se.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;


    public boolean addCategory(Category category) {
        if (categoryMapper.insertSelective(category)>0){
            return true;
        }
        return false;
    }
}
