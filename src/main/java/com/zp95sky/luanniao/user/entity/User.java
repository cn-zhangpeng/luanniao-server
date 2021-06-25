package com.zp95sky.luanniao.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户类
 * @author 山海散客
 * @date 2021年06月25日 12:59
 */
@TableName("user")
@Data
@Builder
public class User {

    /** 用户ID */
    @TableId("id")
    private Long userId;

    /** 用户名 */
    @TableField("username")
    private String username;

    /** 密码 */
    @TableField("password")
    private String password;

    /** 昵称 */
    @TableField("nickname")
    private String nickname;

    /** 创建时间 */
    @TableField("create_time")
    private LocalDateTime createTime;

}

