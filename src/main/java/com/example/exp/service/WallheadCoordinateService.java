package com.example.exp.service;

import com.example.exp.vo.WallheadCoordinateVo;

import java.util.HashMap;
import java.util.List;

/**
 * WallheadCoordinateService
 *
 * @author xzr
 * 2020/7/15 11:36
 **/
public interface WallheadCoordinateService {
    List<Object> getWallheadCoordinateDeatil(HashMap<Object, Object> map);

}
