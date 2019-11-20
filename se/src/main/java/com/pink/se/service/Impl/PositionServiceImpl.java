package com.pink.se.service.Impl;


import com.pink.se.mapper.PositionMapper;
import com.pink.se.model.Position;
import com.pink.se.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    PositionMapper positionMapper;


    public List<Position> getAllPosition() {
        return positionMapper.getAllPosition();
    }
}
