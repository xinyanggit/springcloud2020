package com.yx.springcloud.controller.blockHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yx.springcloud.payment.entity.CommonResult;

/**
 * @author yx start
 * @create 2020/4/18,22:56
 */
public class CustomBlockHandler {
    /***
     * 注意一定要是 static  static static  static  static
     * @param blockException
     * @return
     */
    public static CommonResult customHandlerError(BlockException blockException){
        return  new CommonResult(400,"blockException customHandler error访问1");
    }
    public static CommonResult customHandlerError2(BlockException blockException){
        return  new CommonResult(400,"blockException customHandler error访问2");
    }
}
