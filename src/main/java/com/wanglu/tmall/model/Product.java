package com.wanglu.tmall.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 * Created by wanglu on 17/2/16.
 */
@Entity
@Table(name = "product")
public class Product {
    @Id
    private int id;

    @Column
    private String name;

    @Column
    private String subTitle;
    @Column
    private float orignalPrice;
    @Column
    private float promotePrice;
    @Column
    private int stock;

    @Column
    private Date createDate;

    @ManyToOne
    @JoinColumn(name="cid")
    private Category category;

    @Transient
    private ProductImage firstProductImage;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "product",targetEntity = ProductImage.class,orphanRemoval = true)//用户作为一方使用OneToMany注解
    private Set<ProductImage> productImages;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public float getOrignalPrice() {
        return orignalPrice;
    }

    public void setOrignalPrice(float orignalPrice) {
        this.orignalPrice = orignalPrice;
    }

    public float getPromotePrice() {
        return promotePrice;
    }

    public void setPromotePrice(float promotePrice) {
        this.promotePrice = promotePrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<ProductImage> getProductImages() {
        return productImages;
    }

    public void setProductImages(Set<ProductImage> productImages) {
        this.productImages = productImages;
    }

    public ProductImage getFirstProductImage() {
        return firstProductImage;
    }

    public void setFirstProductImage(ProductImage firstProductImage) {
        this.firstProductImage = firstProductImage;
    }
}