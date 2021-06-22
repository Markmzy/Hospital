package com.markmzy.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.markmzy.service.IRecordInfoService;
import com.markmzy.model.RecordInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 就诊记录信息 前端控制器
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
@Api(tags = {"就诊记录信息"})
@RestController
@RequestMapping("/record-info")
public class RecordInfoController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IRecordInfoService recordInfoService;


    @ApiOperation(value = "新增就诊记录信息")
    @PostMapping()
    public int add(@RequestBody RecordInfo recordInfo){
        return recordInfoService.add(recordInfo);
    }

    @ApiOperation(value = "删除就诊记录信息")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return recordInfoService.delete(id);
    }

    @ApiOperation(value = "更新就诊记录信息")
    @PutMapping()
    public int update(@RequestBody RecordInfo recordInfo){
        return recordInfoService.updateData(recordInfo);
    }

    @ApiOperation(value = "查询就诊记录信息分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<RecordInfo> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return recordInfoService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询就诊记录信息")
    @GetMapping("{id}")
    public RecordInfo findById(@PathVariable Long id){
        return recordInfoService.findById(id);
    }

}
