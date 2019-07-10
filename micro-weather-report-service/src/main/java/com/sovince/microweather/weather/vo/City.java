package com.sovince.microweather.weather.vo;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/7/3
 * Time: 22:53
 * Description:
 */
public class City {
    private String quName;//区名

    private String pyName;//拼音

    private String cityname;//城市名

    public City() {
    }

    public City(String quName, String pyName, String cityname) {
        this.quName = quName;
        this.pyName = pyName;
        this.cityname = cityname;
    }

    public String getQuName() {
        return quName;
    }

    public void setQuName(String quName) {
        this.quName = quName;
    }

    public String getPyName() {
        return pyName;
    }

    public void setPyName(String pyName) {
        this.pyName = pyName;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }
}
