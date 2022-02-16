package com.zp95sky.luanniao.software.mapper;

import com.zp95sky.luanniao.annotation.CommonTestAnnotation;
import com.zp95sky.luanniao.software.domain.YearDateStatisticDo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

/**
 * 软件使用时长 mapper 测试
 * @author 山海紫穹
 * @date 2021年07月05日 14:17
 */
@CommonTestAnnotation
@Slf4j
public class SoftwareUseTimeMapperTest {

    @Resource
    private SoftwareUseTimeMapper useTimeMapper;

    @Test
    public void testSelectYearDateStatistic() {
        int curYear = LocalDate.now().getYear();
        List<YearDateStatisticDo> statisticDoList = useTimeMapper.selectYearDateStatistic(curYear);
        for (YearDateStatisticDo s : statisticDoList) {
            log.info("date: {}, software use time: {}", s.getCurDate(), s.getUseTimeLength());
        }
    }

}
