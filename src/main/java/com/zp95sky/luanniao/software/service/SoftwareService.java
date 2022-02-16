package com.zp95sky.luanniao.software.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zp95sky.luanniao.software.domain.SoftwareListDo;
import com.zp95sky.luanniao.software.dto.AddSoftwareDto;
import com.zp95sky.luanniao.software.entity.Software;

import java.util.List;

/**
 * 软件业务处理
 * @author 山海紫穹
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

    /**
     * 查询软件列表
     * @return 软件列表
     */
    List<SoftwareListDo> getSoftwareList();

}
