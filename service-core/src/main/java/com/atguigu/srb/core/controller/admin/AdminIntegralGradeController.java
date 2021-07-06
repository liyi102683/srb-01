package com.atguigu.srb.core.controller.admin;


import com.atguigu.common.exception.Assert;
import com.atguigu.common.exception.BusinessException;
import com.atguigu.common.result.R;
import com.atguigu.common.result.ResponseEnum;
import com.atguigu.srb.core.pojo.entity.IntegralGrade;
import com.atguigu.srb.core.service.IntegralGradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.omg.PortableServer.THREAD_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 积分等级表 前端控制器
 * </p>
 *
 * @author ly
 * @since 2021-06-09
 */
@Slf4j
@Api(tags = {"积分等级管理"})
@CrossOrigin
@RestController
@RequestMapping("/admin/core/integralGrade")
public class AdminIntegralGradeController {
    @Autowired
    private IntegralGradeService integralGradeService;

    @ApiOperation("积分等级列表")
    @GetMapping("/list")
    public R listAll() {
        log.info("hi i'm helen");
        log.warn("warning!!!");
        log.error("it's a error");

        List<IntegralGrade> integralGradeList = integralGradeService.list();
        if (integralGradeList == null || integralGradeList.size() == 0) {
            return R.error().message("数据不存在");
        } else {
            return R.ok().data("list",integralGradeList);
        }
    }

    @ApiOperation("根据id删除记录")
    @DeleteMapping("/remove/{id}")
    public R removeById(
            @ApiParam(value = "数据id",example = "100",required = true)
            @PathVariable("id") Long id) {
        boolean r = integralGradeService.removeById(id);
        if (r){
            return R.ok().message("删除成功");
        } else {
            return R.error().message("删除失败");
        }

    }
    @ApiOperation("根据id查询积分等级")
    @GetMapping("/get/{id}")
    public R getById(@PathVariable("id") Integer id) {
        IntegralGrade integralGradeEntity = this.integralGradeService.getById(id);
        if (integralGradeEntity != null) {
           return R.ok().data("record",integralGradeEntity);
        } else {
            return R.error().message("数据不存在");
        }
    }

    @ApiOperation("新增积分等级")
    @PostMapping("/save")
    public R save(
            @ApiParam(value = "积分等级对象", required = true)
            @RequestBody IntegralGrade integralGrade) {

       /* //如果借款额度为空就手动抛出一个自定义的异常！
        if(integralGrade.getBorrowAmount() == null){
            //BORROW_AMOUNT_NULL_ERROR(-201, "借款额度不能为空"),
            throw new BusinessException(ResponseEnum.BORROW_AMOUNT_NULL_ERROR);
        }*/
        Assert.notNull(integralGrade.getBorrowAmount(), ResponseEnum.BORROW_AMOUNT_NULL_ERROR);

        boolean r = this.integralGradeService.save(integralGrade);
        if (r) {
            return R.ok().message("保存成功");
        } else {
            return R.error().message("保存失败");
        }
    }

    @ApiOperation("修改积分等级")
    @PutMapping("/update")
    public R update(
            @ApiParam(value = "积分等级对象", required = true)
            @RequestBody IntegralGrade integralGrade) {
        boolean r = this.integralGradeService.updateById(integralGrade);
        if (r) {
            return R.ok().message("修改成功");
        } else {
            return R.error().message("修改失败");
        }
    }


}

