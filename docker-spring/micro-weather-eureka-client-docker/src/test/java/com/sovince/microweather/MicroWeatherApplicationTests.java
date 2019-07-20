package com.sovince.microweather;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MicroWeatherApplicationTests {

    @Value("auther")
    private String auther;

    @Test
    public void contextLoads() {

    }

    /**
     * 测试cloud-config
     */
    @Test
    public void foo(){
        //git中的配置
        System.out.println(auther);
    }

}
