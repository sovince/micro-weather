package com.sovince.microweather.weather.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/7/2
 * Time: 21:49
 * Description:
 * {
 * 	"data": {
 * 	------------------------
 * 		"yesterday": {
 * 			"date": "1日星期一",
 * 			"high": "高温 35℃",
 * 			"fx": "北风",
 * 			"low": "低温 22℃",
 * 			"fl": "<![CDATA[<3级]]>",
 * 			"type": "晴"
 *                },
 * 		"city": "北京",
 * 		"forecast": [{
 * 			"date": "2日星期二",
 * 			"high": "高温 35℃",
 * 			"fengli": "<![CDATA[<3级]]>",
 * 			"low": "低温 22℃",
 * 			"fengxiang": "南风",
 * 			"type": "雷阵雨"
 *        }, {
 * 			"date": "3日星期三",
 * 			"high": "高温 36℃",
 * 			"fengli": "<![CDATA[<3级]]>",
 * 			"low": "低温 24℃",
 * 			"fengxiang": "南风",
 * 			"type": "晴"
 *        }, {
 * 			"date": "4日星期四",
 * 			"high": "高温 38℃",
 * 			"fengli": "<![CDATA[3-4级]]>",
 * 			"low": "低温 26℃",
 * 			"fengxiang": "南风",
 * 			"type": "晴"
 *        }, {
 * 			"date": "5日星期五",
 * 			"high": "高温 31℃",
 * 			"fengli": "<![CDATA[<3级]]>",
 * 			"low": "低温 24℃",
 * 			"fengxiang": "东南风",
 * 			"type": "多云"
 *        }, {
 * 			"date": "6日星期六",
 * 			"high": "高温 31℃",
 * 			"fengli": "<![CDATA[<3级]]>",
 * 			"low": "低温 20℃",
 * 			"fengxiang": "东北风",
 * 			"type": "多云"
 *        }],
 * 		"ganmao": "各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。",
 * 		"wendu": "25"* 	},
 * 	-----------------------------------------
 * 	"status": 1000,
 * 	"desc": "OK"
 * }
 *
 * yesterday
 * city
 * forecast 5天
 * ganmao
 * wendu
 */
public class Weather implements Serializable {

    private String city;
    private String ganmao;
    private String wendu;

    private Yesterday yesterday;
    private List<Forecast> forecast;

    public Weather() {
    }

    public Weather(String city, String ganmao, String wendu, Yesterday yesterday, List<Forecast> forecast) {
        this.city = city;
        this.ganmao = ganmao;
        this.wendu = wendu;
        this.yesterday = yesterday;
        this.forecast = forecast;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    public Yesterday getYesterday() {
        return yesterday;
    }

    public void setYesterday(Yesterday yesterday) {
        this.yesterday = yesterday;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }
}
