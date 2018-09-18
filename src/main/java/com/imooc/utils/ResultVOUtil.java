package com.imooc.utils;

import com.imooc.VO.ResultVO;

/**
 * Created by nantian on 2018/9/6.
 */
public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success(){
        return null;
    }

    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
