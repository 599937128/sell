package com.imooc.converter;

import com.imooc.dataobject.OrderMaster;
import com.imooc.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: sell
 * @Date: 2018/9/8 18:19
 * @Author: Mr.lv
 * @Description: 转换器,master转为dto
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO conver(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> conver(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream().map(e ->
                conver(e)
        ).collect(Collectors.toList());
    }
}
