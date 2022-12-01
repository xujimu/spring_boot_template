package com.template.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xjm
 * @Date: 2021/10/14/15:59
 * @Description: 每日日报定时推送
 */


@Component
@EnableScheduling
@Slf4j
public class TestTask {



    /**
     * 推送日报
     */
    @Scheduled(cron = "0/60 * * * * *")
    public void push() throws ParseException {

    }



}
