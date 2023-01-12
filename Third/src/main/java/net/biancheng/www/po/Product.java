package net.biancheng.www.po;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter(value = AccessLevel.PUBLIC) // 生成的get方法全是public修饰的
@Setter(value = AccessLevel.PUBLIC) // 生成的set方法全是public修饰的
@ToString
@Entity
@Table(name = "tbl_product")
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    private String url; // 不加Column注解默认生成url数据列
}
