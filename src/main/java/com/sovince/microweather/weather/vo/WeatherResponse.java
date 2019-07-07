package com.sovince.microweather.weather.vo;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/7/2
 * Time: 22:16
 * Description: 响应
 */
public class WeatherResponse {
    private Weather data;
    private Integer status;
    private String desc;

    public WeatherResponse() {
    }

    public WeatherResponse(Weather data, Integer status, String desc) {
        this.data = data;
        this.status = status;
        this.desc = desc;
    }

    public Weather getData() {
        return data;
    }

    public void setData(Weather data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "data=" + data +
                ", status=" + status +
                ", desc='" + desc + '\'' +
                '}';
    }
}
