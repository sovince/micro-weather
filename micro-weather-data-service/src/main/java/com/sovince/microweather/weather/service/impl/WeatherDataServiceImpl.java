package com.sovince.microweather.weather.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sovince.microweather.weather.service.WeatherDataService;
import com.sovince.microweather.weather.vo.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/7/2
 * Time: 22:25
 * Description:
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "?citykey=" + cityId;
        return doGetWeather(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "?city=" + cityName;
        return doGetWeather(uri);
    }


    private WeatherResponse doGetWeather(String uri) {
        String key = genarateKey(uri);
        //redis crud句柄
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        WeatherResponse weatherResponse = null;
//        String body = null;
//        if(stringRedisTemplate.hasKey(key)){
//            logger.info("Getting data from redis...");
//            body = ops.get(key);
//        }else{
//            logger.info("Getting data from uri...");
//            body = getBodyFromUri(uri);
//            ops.set(key,body,1800, TimeUnit.SECONDS);
//        }

        logger.info("Getting data from redis...");
        String body = ops.get(key);

        if(body!=null){
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                weatherResponse = objectMapper.readValue(body, WeatherResponse.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return weatherResponse;
    }


    private String genarateKey(String uri){
        return "weather:"+uri;
    }
}
