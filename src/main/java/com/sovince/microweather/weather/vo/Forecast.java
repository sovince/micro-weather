package com.sovince.microweather.weather.vo;

import java.io.Serializable;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/7/2
 * Time: 22:04
 * Description:
 *          "date": "2日星期二",
 * 			"high": "高温 32℃",
 * 			"fengli": "<![CDATA[3-4级]]>",
 * 			"low": "低温 26℃",
 * 			"fengxiang": "东南风",
 * 			"type": "小雨"
 */
public class Forecast implements Serializable {
    private String date;
    private String high;
    private String fengli;
    private String low;
    private String fengxiang;
    private String type;

    public Forecast() {
    }

    public Forecast(String date, String high, String fengli, String low, String fengxiang, String type) {
        this.date = date;
        this.high = high;
        this.fengli = fengli;
        this.low = low;
        this.fengxiang = fengxiang;
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getFengli() {
        return fengli;
    }

    public void setFengli(String fengli) {
        this.fengli = fengli;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getFengxiang() {
        return fengxiang;
    }

    public void setFengxiang(String fengxiang) {
        this.fengxiang = fengxiang;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
