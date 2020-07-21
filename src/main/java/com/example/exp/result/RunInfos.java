package com.example.exp.result;

import lombok.Data;

import java.util.List;

/**
 * RunInfos
 *
 * @author xzr
 * 2020/7/20 16:33
 **/
@Data
public class RunInfos {
    private List<Irrelevant> irrelevants;
    private SqlText sqlText;
}
