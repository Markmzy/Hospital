package com.markmzy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.markmzy.jwt.JWTUtil;
import com.markmzy.model.OrderInfo;
import com.markmzy.model.PatientInfo;
import com.markmzy.service.IOrderInfoService;
import com.markmzy.util.JsonObject;
import com.markmzy.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

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
@RequestMapping("/order")
public class OrderInfoController
{

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IOrderInfoService orderInfoService;

    @RequestMapping("/queryOrderInfoAll")
    public JsonObject queryOrderInfoAll(PatientInfo patientInfo, Integer status,
                                        @RequestParam(defaultValue = "1") Integer page,
                                        @RequestParam(defaultValue = "15") Integer limit)
    {
        OrderInfo info = new OrderInfo();
        info.setPatientInfo(patientInfo);
        info.setStatus(status);
        JsonObject object = new JsonObject();
        PageInfo<OrderInfo> pageInfo = orderInfoService.findOrderInfoAll(page, limit, info);
        object.setMsg("ok");
        object.setCode(0);
        object.setCount(pageInfo.getTotal());
        object.setData(pageInfo.getList());
        return object;

    }

    @RequestMapping("/queryOrderInfoAll2")
    public JsonObject queryOrderInfoAll2(PatientInfo patientInfo, Integer status, HttpServletRequest request,
                                         @RequestParam(defaultValue = "1") Integer page,
                                         @RequestParam(defaultValue = "15") Integer limit)
    {
        OrderInfo info = new OrderInfo();
        info.setPatientInfo(patientInfo);
        info.setStatus(status);
        //获取登录用户信息
        String token = request.getHeader("token");
        Integer userId = JWTUtil.getUserId(token);
        info.setUserId(userId);

        JsonObject object = new JsonObject();
        PageInfo<OrderInfo> pageInfo = orderInfoService.findOrderInfoAll(page, limit, info);
        object.setMsg("ok");
        object.setCode(0);
        object.setCount(pageInfo.getTotal());
        object.setData(pageInfo.getList());
        return object;

    }


    @ApiOperation(value = "新增病人的预约记录")
    @RequestMapping("/add")
    public R add(@RequestBody OrderInfo orderInfo)
    {
        orderInfo.setStatus(0);
        int num = orderInfoService.add(orderInfo);
        if(num > 0)
        {
            return R.ok("添加预约成功");
        }
        return R.fail("添加预约失败");
    }

    @RequestMapping("/add2")
    public R add2(@RequestBody Map<String, String> map, HttpServletRequest request)
    {
        OrderInfo info = new OrderInfo();
        info.setStatus(0);

        //获取登录用户信息
        String token = request.getHeader("token");
        Integer patId = JWTUtil.getUserId(token);
        info.setPatientId(patId);

        Integer userId = Integer.parseInt(map.get("userId"));
        info.setUserId(userId);
        info.setDayTime(map.get("dayTime"));
        String day = map.get("day");
        if(day.equals("today"))
        {
            info.setDay(new Date().toString());
        }
        else
        {
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE, 1);
            info.setDay(c.getTime().toString());
        }
        int num = orderInfoService.add(info);
        if(num > 0)
        {
            return R.ok("添加预约成功");
        }
        return R.fail("添加预约失败");
    }

    @ApiOperation(value = "删除病人的预约记录")
    @RequestMapping("/deleteByIds")
    public R delete(String ids)
    {
        //把字符串转成集合对象
        String[] list = ids.split(",");
        int num = 0;
        for(String idString : list)
        {
            num += orderInfoService.delete(new Long(idString));
        }
        if(num > 0)
        {
            return R.ok("删除预约成功");
        }
        return R.fail("删除预约失败");
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
