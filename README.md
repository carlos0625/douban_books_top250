# Java爬取豆瓣Top250并存入MySQL数据库

- ## 构建：

  项目通过Maven构建，使用**jsoup** + **mybatis** + **log4j**

- ##项目目录结构：

```
  ./
  |--.idea
  |--src
  |   |--main
  |   |   |--java
  |   |   |  |--cn.edu.ncu.carlos
  |   |   |     |--dao
  |   |   |     |--model
  |   |   |     |--parse
  |   |   |     |--service
  |   |   |     |--util
  |   |   |     |--App.java
  |   |   |
  |   |   |--resources
  |   |       |--jdbc.properties
  |   |       |--log4j.properties
  |   |       |--BookMapper.xml
  |   |       |--mybatis-config.xml
  |   |
  |   |--test
  |       |--java
  |       |--resources
  |      
  |--book_web.iml
  |--pom.xml
  |--README.md
```
