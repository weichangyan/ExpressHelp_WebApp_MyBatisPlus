package com.wcy.mpdemo.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author wcy
 * @since 2021-08-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private Integer stuNum;

    private String type;

    private String nickName;

    private String name;

    private String phone;

    private Integer points;

    private Integer creditPoints;

    @Version
    private Integer version;


}
