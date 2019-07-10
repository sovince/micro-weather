package com.sovince.microweather.weather.service.impl;

import com.sovince.microweather.weather.service.CityDataService;
import com.sovince.microweather.weather.util.XmlBuilder;
import com.sovince.microweather.weather.vo.City;
import com.sovince.microweather.weather.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/7/3
 * Time: 23:22
 * Description:
 */
@Service
public class CityDataServiceImpl implements CityDataService {
    @Override
    public List<City> listCity() throws Exception {
        ClassPathResource resource = new ClassPathResource("city-list.xml");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8));

        StringBuffer buffer = new StringBuffer();
        String line = null;
        while ((line=bufferedReader.readLine())!=null){
            buffer.append(line);
        }
        bufferedReader.close();

        String body = buffer.toString();
        CityList cityList = (CityList) XmlBuilder.xmlStrToObject(CityList.class, body);
        return cityList.getCityList();
    }
}
