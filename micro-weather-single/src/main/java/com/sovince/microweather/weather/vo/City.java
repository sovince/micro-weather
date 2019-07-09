package com.sovince.microweather.weather.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/7/3
 * Time: 22:53
 * Description:
 */
@XmlRootElement(name="city")
@XmlAccessorType(XmlAccessType.FIELD)
public class City {
    @XmlAttribute(name = "quName")
    private String quName;//区名

    @XmlAttribute(name = "pyName")
    private String pyName;//拼音

    @XmlAttribute(name = "cityname")
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
