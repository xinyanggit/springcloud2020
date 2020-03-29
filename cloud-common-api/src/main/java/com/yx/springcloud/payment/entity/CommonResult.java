package com.yx.springcloud.payment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 后台统一返回数据给前端使用
 * @author yx start
 * @create 2020/3/28,12:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message ;
    private  T data  ;

    public CommonResult(Integer code, String message) {
        this(code,message,null);
    }
}
