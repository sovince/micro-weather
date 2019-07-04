package com.sovince.microweather.weather.service;

import com.sovince.microweather.weather.vo.City;

import java.util.List;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/7/3
 * Time: 23:21
 * Description:
 */
public interface CityDataService {

    /**
     * 获取城市列表
     * @return
     * @throws Exception
     */
    List<City> listCity() throws Exception;
}
