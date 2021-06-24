package com.markmzy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.markmzy.model.OrderInfo;
import com.markmzy.service.IOrderInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 病人的预约记录 前端控制器
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
@Api(tags = {"病人的预约记录"})
@RestController
@RequestMapping("/order-info")
public class OrderInfoController
{

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IOrderInfoService orderInfoService;


    @ApiOperation(value = "新增病人的预约记录")
    @PostMapping()
    public int add(@RequestBody OrderInfo orderInfo)
    {
        return orderInfoService.add(orderInfo);
    }

    @ApiOperation(value = "删除病人的预约记录")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id)
    {
        return orderInfoService.delete(id);
    }

    @ApiOperation(value = "更新病人的预约记录")
    @PutMapping()
    public int update(@RequestBody OrderInfo orderInfo)
    {
        return orderInfoService.updateData(orderInfo);
    }

    @ApiOperation(value = "查询病人的预约记录分页数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码"),
            @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<OrderInfo> findListByPage(@RequestParam Integer page,
                                           @RequestParam Integer pageCount)
    {
        return orderInfoService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询病人的预约记录")
    @GetMapping("{id}")
    public OrderInfo findById(@PathVariable Long id)
    {
        return orderInfoService.findById(id);
    }

}
