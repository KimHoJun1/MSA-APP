폐업플레이 (2021.02.19 Ver.01)
=============
> 폐업 가게들의 용품을 판매하는 모바일 어플리케이션 서버 프로젝트



## 0.설정법 (2021.02.22)
> 1. git clone https://github.com/EooHoSun/MSA-APP
> 2. [kafka download ( window )][kafka]
> 3. kafka-server-start.bat 설정 변경
> 3-1. ${kafka}\bin\windows\kafka-server-start.bat => 편집
> ![ex_screenshot](./kafka%20설정변경.png)
> 4. zookeeper 실행 ${kafka}\bin\windows\zookeeper-server-start.bat ../../config/zookeeper.properties
> 5. kafka 실행 ${kafka}\bin\windows\kafka-server-start.bat ../../config/server.properties
> 6. apigateway, eureka, msa server 기동

[kafka]: https://downloads.apache.org/kafka/2.7.0/kafka_2.12-2.7.0.tgz


## 1. 사용기술
> 1. 언어 : Java
> 2. 프레임워크 : Spring Boot
> 3. Library : JPA(Query DSL), Eureka, Zuul, Kafka(미정)
> 4. DB : Maria DB
> 5. 배포 : AWS S3
> 6. Tool : Git, Slack, Zoom

## 2. 프로젝트 관리

#### 2-1. WBS
> 프로젝트 초기작성 WBS
![ex_screenshot](./WBS.jpg)




## 3. 설계
 
> DB 설계
![ex_screenshot](./DB설계.png)
>ERD Cloud 물리설계( Ver.01 )



## 4. 진행 과정 
> 2021-02-18
>> 1. kafka 설정 미완료, AWS EC2에 Kafkka 서버기동만 완료, 이후 
>> 2. message que적용은 검토필요
>> 3. jpa 기본template 완성 -> Query DSL 적용중

> 2021-02-22
>> 1. kafka server local 기본설정완료 ( broker, partition, topic, consumer, producer 등 설정 및 설계 과정 필요 )
>> 3. jpa 기본template 완성 -> Query DSL 적용중


> 2021-02-23
>> 1. Community-svc Query DSL 예제 추가(update) -> kafka consumer 연계

***
## 5. 참여자
- [호선][eoohosun]
- [수현][eoohosun]
- [태용][eoohosun]
- [호준][eoohosun]
- [여진][yeojin]
- [종훈][eoohosun]


[eoohosun]: https://github.com/EooHoSun
[yeojin]: https://github.com/YeojinJeon
