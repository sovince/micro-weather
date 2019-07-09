package com.sovince.microweather.weather.vo;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/7/3
 * Time: 23:10
 * Description:
 */
@XmlRootElement(name="china")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityList {

    @XmlElement(name="city")
    private List<City> cityList;

    public CityList() {
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
