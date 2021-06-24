package com.zp95sky.luanniao.softwaretime.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 使用软件
 * @author 山海散客
 * @date 2021年06月23日 14:06
 */
@TableName("software")
@Data
public class Software {

    @TableId
    private Long id;

    @TableField("software_name")
    private String softwareName;

}
