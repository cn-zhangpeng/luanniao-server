package com.zp95sky.luanniao.softwaretime.service.impl;

import cn.hutool.core.lang.Snowflake;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zp95sky.luanniao.softwaretime.dto.AddSoftwareDto;
import com.zp95sky.luanniao.softwaretime.entity.Software;
import com.zp95sky.luanniao.softwaretime.mapper.SoftwareMapper;
import com.zp95sky.luanniao.softwaretime.service.SoftwareService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 山海散客
 * @date 2021年06月24日 13:36
 */
@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class SoftwareServiceImpl extends ServiceImpl<SoftwareMapper, Software> implements SoftwareService {

    private final Snowflake snowflake;

    @Override
    public void addSoftware(AddSoftwareDto softwareDto) {
        Software software = constructSoftware(softwareDto.getSoftwareName());
        save(software);
    }

    @Override
    public void batchAddSoftware(List<AddSoftwareDto> softwareDtoList) {
        List<Software> softwareList = new ArrayList<>(softwareDtoList.size());
        for (AddSoftwareDto softwareDto : softwareDtoList) {
            softwareList.add(constructSoftware(softwareDto.getSoftwareName()));
        }
        saveBatch(softwareList);
    }

    private Software constructSoftware(String softwareName) {
        return Software.builder()
                .id(snowflake.nextId()).softwareName(softwareName)
                .build();
    }

}
