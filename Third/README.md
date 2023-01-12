###
* 注解式开发
```shell
http://t.zoukankan.com/qlqwjy-p-9545453.html
```
### 自定义数据库方言
```shell
# 配置文件更改
<property name="hibernate.dialect">net.biancheng.www.dialect.MySQL57CustomDialect</property>
```
###
```shell
# package com.vladmihalcea.hibernate.type 包里面含有可以使用的自定义用户类型(供参考)
<dependency>
    <groupId>com.vladmihalcea</groupId>
    <artifactId>hibernate-types-52</artifactId>
    <version>2.11.1</version>
</dependency>
```