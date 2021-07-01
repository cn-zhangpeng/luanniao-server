package com.zp95sky.luanniao.software.service;

import com.zp95sky.luanniao.annotation.CommonTestAnnotation;
import com.zp95sky.luanniao.software.dto.AddSoftwareDto;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 软件业务测试类
 * @author 山海散客
 * @date 2021年06月24日 13:31
 */
@CommonTestAnnotation
public class SoftwareServiceTest {

    @Resource
    private SoftwareService softwareService;

    @Test
    public void testAddSoftware() {
        String[] softwareArr = {"Another Redis Desktop Manager"};
        List<AddSoftwareDto> softwareList = new ArrayList<>(softwareArr.length);
        for (String name : softwareArr) {
            softwareList.add(constructAddSoftwareDto(name));
        }
        softwareService.batchAddSoftware(softwareList);
    }

    private AddSoftwareDto constructAddSoftwareDto(String softwareName) {
        AddSoftwareDto softwareDto = new AddSoftwareDto();
        softwareDto.setSoftwareName(softwareName);
        return softwareDto;
    }

}