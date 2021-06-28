package com.markmzy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.markmzy.model.Exchange;
import com.markmzy.service.IExchangeService;
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
 * 调休记录信息  前端控制器
 * </p>
 *
 * @author Zhiyue Ma
 * @since 2021-06-22
 */
@Api(tags = {"调休记录信息 "})
@RestController
@RequestMapping("/exchange")
public class ExchangeController
{

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IExchangeService exchangeService;


    @ApiOperation(value = "新增调休记录信息 ")
    @PostMapping()
    public int add(@RequestBody Exchange exchange)
    {
        return exchangeService.add(exchange);
    }

    @ApiOperation(value = "删除调休记录信息 ")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id)
    {
        return exchangeService.delete(id);
    }

    @ApiOperation(value = "更新调休记录信息 ")
    @PutMapping()
    public int update(@RequestBody Exchange exchange)
    {
        return exchangeService.updateData(exchange);
    }

    @ApiOperation(value = "查询调休记录信息 分页数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码"),
            @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Exchange> findListByPage(@RequestParam Integer page,
                                          @RequestParam Integer pageCount)
    {
        return exchangeService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询调休记录信息 ")
    @GetMapping("{id}")
    public Exchange findById(@PathVariable Long id)
    {
        return exchangeService.findById(id);
    }

}
