# micro-weather
由一个天气预报小项目起手Spring Cloud

Introduction to Spring Cloud by a micro-project

## 子项目
0. **micro-weather-single** 单一结构的天气预报项目，由此拆分微服务
1. **micro-weather-city-service** 提供**城市列表服务**（接口）
2. **micro-weather-collection-service** 天气数据采集服务，采集数据并入库redis，依赖于 **城市列表服务**
3. **micro-weather-data-service** 提供**天气数据服务**（接口），即从redis查询采集的数据
4. **micro-weather-report-service** 天气预报展示，依赖于**城市列表服务**和**天气数据服务**，通过zuul获取两个服务数据
5. **micro-weather-eureka-client-zuul** 作为网关，聚合**城市列表服务**和**天气数据服务**的请求入口
6. **micro-weather-config-server** 项目的配置中心，coding...


## 启动
```
## 城市数据服务
java -jar micro-weather-city-service/target/micro-weather-city-service-0.0.1-SNAPSHOT.jar --server.port=10001
java -jar micro-weather-city-service/target/micro-weather-city-service-0.0.1-SNAPSHOT.jar --server.port=

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
```

访问
```
http://localhost:10007/report/cityName/香港
```
