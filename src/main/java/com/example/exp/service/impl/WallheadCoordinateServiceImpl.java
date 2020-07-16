package com.example.exp.service.impl;

import com.example.exp.service.WallheadCoordinateService;
import com.example.exp.utils.HttpUtil;
import com.example.exp.vo.WallheadCoordinateVo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * WallheadCoordinateServiceImpl
 *
 * @author xzr
 * 2020/7/15 11:37
 **/
@Service
public class WallheadCoordinateServiceImpl implements WallheadCoordinateService {
    @Override
    public List<Object> getWallheadCoordinateDeatil(HashMap<Object, Object> map) {
        List<Object> list = HttpUtil.httpGet(map);
        return list;
    }
}
