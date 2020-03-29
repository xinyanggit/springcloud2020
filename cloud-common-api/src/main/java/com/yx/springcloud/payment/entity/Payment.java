package com.yx.springcloud.payment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Payment)实体类
 *
 * @author yx
 * @since 2020-03-28 12:10:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Payment implements Serializable {
    private static final long serialVersionUID = 604208873647975004L;
    
    private Integer id;
    private String descript;


}