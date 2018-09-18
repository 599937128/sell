package com.imooc.controller;

import com.imooc.VO.ResultVO;
import com.imooc.converter.OrderForm2OrderDTOConverter;
import com.imooc.dataobject.OrderDetail;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.form.OrderForm;
import com.imooc.service.BuyerService;
import com.imooc.service.OrderService;
import com.imooc.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: sell
 * @Date: 2018/9/9 16:20
 * @Author: Mr.lv
 * @Description:
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;

    // 创建订单
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm,
                                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("[创建表单] 参数不正确, orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_REEOR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("[创建订单] 购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createReslut = orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>();
        map.put("orderId", createReslut.getOrderId());

        return ResultVOUtil.success(map);
    }

    // 订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page", defaultValue = "0")  Integer page,
                                         @RequestParam(value = "size", defaultValue = "10")  Integer size) {
        if (StringUtils.isEmpty(openid)) {
            log.error("查询订单列表 openid 为空");
            throw new SellException(ResultEnum.PARAM_REEOR);
        }
        PageRequest pageRequest = new PageRequest(page, size);
        Page<OrderDTO> orderDTOPage =  orderService.findList(openid, pageRequest);

        return ResultVOUtil.success(orderDTOPage.getContent());

    }

    // 订单详情
    @GetMapping("/detail")
    public ResultVO<OrderDetail> detail(@RequestParam("openid") String openid,
                                        @RequestParam("orderid") String orderid) {
        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderid);
        return ResultVOUtil.success(orderDTO);
    }

    // 取消订单
    @PostMapping("/cancel")
    public ResultVO  cancel(@RequestParam("openid") String openid,
                            @RequestParam("orderid") String orderid) {
        OrderDTO orderDTO = buyerService.cancelOrder(openid, orderid);
        return ResultVOUtil.success();
    }

}
