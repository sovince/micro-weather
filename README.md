# micro-weather
由一个天气预报小项目起手Spring Cloud

Introduction to Spring Cloud by a micro-project

[测试链接 http://weather.sovince.com/report/cityName/杭州](http://weather.sovince.com/report/cityName/%E6%9D%AD%E5%B7%9E)

## 主要子项目
0. **micro-weather-single** 单一结构的天气预报项目，由此拆分微服务
1. **micro-weather-eureka-server** 服务注册发现
2. **micro-weather-city-service** 提供**城市列表服务**（接口）
3. **micro-weather-collection-service** 天气数据采集服务，采集数据并入库redis，依赖于 **城市列表服务**
4. **micro-weather-data-service** 提供**天气数据服务**（接口），即从redis查询采集的数据
5. **micro-weather-report-service** 天气预报展示，依赖于**城市列表服务**和**天气数据服务**，通过zuul获取两个服务数据
6. **micro-weather-eureka-client-zuul** 作为网关，聚合**城市列表服务**和**天气数据服务**的请求入口
7. **docker-spring** 容器编排测试例子

---
## 次要子项目

7. **micro-weather-config-server** 项目的配置中心
8. **micro-weather-eureka-client** 测试服务发现、配置中心读取、Feign...，

## 启动
```
## 服务注册发现
java -jar micro-weather-eureka-server/target/micro-weather-eureka-server-0.0.1-SNAPSHOT.jar

## 城市数据服务
java -jar micro-weather-city-service/target/micro-weather-city-service-0.0.1-SNAPSHOT.jar --server.port=10001
java -jar micro-weather-city-service/target/micro-weather-city-service-0.0.1-SNAPSHOT.jar --server.port=10002

## 采集服务 依赖于 城市数据服务
java -jar micro-weather-collection-service/target/micro-weather-collection-service-0.0.1-SNAPSHOT.jar --server.port=10003
java -jar micro-weather-collection-service/target/micro-weather-collection-service-0.0.1-SNAPSHOT.jar --server.port=10004

## 天气数据提供服务 依赖于redis中的数据
java -jar micro-weather-data-service/target/micro-weather-data-service-0.0.1-SNAPSHOT.jar --server.port=10005
java -jar micro-weather-data-service/target/micro-weather-data-service-0.0.1-SNAPSHOT.jar --server.port=10006

## 启用网关zuul  天气预报展示服务从zuul请求数据
java -jar micro-weather-eureka-client-zuul/target/micro-weather-eureka-client-zuul-0.0.1-SNAPSHOT.jar --server.port=10009
java -jar micro-weather-eureka-client-zuul/target/micro-weather-eureka-client-zuul-0.0.1-SNAPSHOT.jar --server.port=10010

## 天气预报展示服务 依赖于 城市数据服务和天气数据提供服务,zuul
java -jar micro-weather-report-service/target/micro-weather-report-service-0.0.1-SNAPSHOT.jar --server.port=10007
java -jar micro-weather-report-service/target/micro-weather-report-service-0.0.1-SNAPSHOT.jar --server.port=10008

## 配置中心，集中管理配置，仅测试和天气项目无关，可不启动
java -jar micro-weather-config-server/target/micro-weather-config-server-0.0.1-SNAPSHOT.jar
```

#### 访问
```
http://localhost:10007/report/cityName/香港
```

![图片](http://image.sovince.com/20190711/weather-report-normal.png)

#### 停止城市数据服务和天气数据数据服务

![图片](http://image.sovince.com/20190711/weather-report-break.png)
