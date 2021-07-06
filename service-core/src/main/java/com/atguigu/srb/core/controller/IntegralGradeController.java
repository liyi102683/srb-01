package com.atguigu.srb.core.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.scene.chart.ValueAxis;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 积分等级表 前端控制器
 * </p>
 *
 * @author ly
 * @since 2021-06-09
 */
@Api(value = "网站积分等级管理")
@RestController
@RequestMapping("api/core/integralGrade")
public class IntegralGradeController {
    @ApiOperation(value = "测试接口")
    @GetMapping("/test")
    public void test(){
        return;
    }

}

