package com.zp95sky.luanniao.softwaretime.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zp95sky.luanniao.softwaretime.dto.AddSoftwareDto;
import com.zp95sky.luanniao.softwaretime.entity.Software;

import java.util.List;

/**
 * 软件业务处理
 * @author 山海散客
 * @date 2021年06月24日 13:33
 */
public interface SoftwareService extends IService<Software> {

    /**
     * 添加软件
     * @param softwareDto 软件参数
     */
    void addSoftware(AddSoftwareDto softwareDto);

    /**
     * 批量添加软件
     * @param softwareDtoList 软件信息列表
     */
    void batchAddSoftware(List<AddSoftwareDto> softwareDtoList);

}
