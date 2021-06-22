package com.markmzy.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.markmzy.service.IPatientInfoService;
import com.markmzy.model.PatientInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 病人信息表 前端控制器
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
@Api(tags = {"病人信息表"})
@RestController
@RequestMapping("/patient-info")
public class PatientInfoController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IPatientInfoService patientInfoService;


    @ApiOperation(value = "新增病人信息表")
    @PostMapping()
    public int add(@RequestBody PatientInfo patientInfo){
        return patientInfoService.add(patientInfo);
    }

    @ApiOperation(value = "删除病人信息表")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return patientInfoService.delete(id);
    }

    @ApiOperation(value = "更新病人信息表")
    @PutMapping()
    public int update(@RequestBody PatientInfo patientInfo){
        return patientInfoService.updateData(patientInfo);
    }

    @ApiOperation(value = "查询病人信息表分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<PatientInfo> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return patientInfoService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询病人信息表")
    @GetMapping("{id}")
    public PatientInfo findById(@PathVariable Long id){
        return patientInfoService.findById(id);
    }

}
