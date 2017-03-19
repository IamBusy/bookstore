package com.william.model;

import java.math.BigDecimal;
import java.util.Date;

public class Product {


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    private Integer quantity;



    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column products.id
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column products.category_id
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    private Integer categoryId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column products.isbn
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    private String isbn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column products.name
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column products.photo
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    private String photo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column products.publisher
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    private String publisher;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column products.price
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    private BigDecimal price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column products.original_price
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    private BigDecimal originalPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column products.author
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    private String author;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column products.points
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    private Integer points;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column products.minimum
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    private Short minimum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column products.sort_order
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    private Integer sortOrder;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column products.substract
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    private Byte substract;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column products.status
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    private Byte status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column products.sold
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    private Integer sold;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column products.month_sold
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    private Integer monthSold;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column products.store_id
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    private Integer storeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column products.created_at
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    private Date createdAt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column products.updated_at
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    private Date updatedAt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column products.deleted_at
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    private Date deletedAt;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column products.id
     *
     * @return the value of products.id
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column products.id
     *
     * @param id the value for products.id
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column products.category_id
     *
     * @return the value of products.category_id
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column products.category_id
     *
     * @param categoryId the value for products.category_id
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column products.isbn
     *
     * @return the value of products.isbn
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column products.isbn
     *
     * @param isbn the value for products.isbn
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column products.name
     *
     * @return the value of products.name
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column products.name
     *
     * @param name the value for products.name
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column products.photo
     *
     * @return the value of products.photo
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column products.photo
     *
     * @param photo the value for products.photo
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column products.publisher
     *
     * @return the value of products.publisher
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column products.publisher
     *
     * @param publisher the value for products.publisher
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column products.price
     *
     * @return the value of products.price
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column products.price
     *
     * @param price the value for products.price
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column products.original_price
     *
     * @return the value of products.original_price
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column products.original_price
     *
     * @param originalPrice the value for products.original_price
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column products.author
     *
     * @return the value of products.author
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column products.author
     *
     * @param author the value for products.author
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column products.points
     *
     * @return the value of products.points
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public Integer getPoints() {
        return points;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column products.points
     *
     * @param points the value for products.points
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public void setPoints(Integer points) {
        this.points = points;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column products.minimum
     *
     * @return the value of products.minimum
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public Short getMinimum() {
        return minimum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column products.minimum
     *
     * @param minimum the value for products.minimum
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public void setMinimum(Short minimum) {
        this.minimum = minimum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column products.sort_order
     *
     * @return the value of products.sort_order
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public Integer getSortOrder() {
        return sortOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column products.sort_order
     *
     * @param sortOrder the value for products.sort_order
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column products.substract
     *
     * @return the value of products.substract
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public Byte getSubstract() {
        return substract;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column products.substract
     *
     * @param substract the value for products.substract
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public void setSubstract(Byte substract) {
        this.substract = substract;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column products.status
     *
     * @return the value of products.status
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column products.status
     *
     * @param status the value for products.status
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column products.sold
     *
     * @return the value of products.sold
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public Integer getSold() {
        return sold;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column products.sold
     *
     * @param sold the value for products.sold
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public void setSold(Integer sold) {
        this.sold = sold;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column products.month_sold
     *
     * @return the value of products.month_sold
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public Integer getMonthSold() {
        return monthSold;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column products.month_sold
     *
     * @param monthSold the value for products.month_sold
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public void setMonthSold(Integer monthSold) {
        this.monthSold = monthSold;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column products.store_id
     *
     * @return the value of products.store_id
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public Integer getStoreId() {
        return storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column products.store_id
     *
     * @param storeId the value for products.store_id
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column products.created_at
     *
     * @return the value of products.created_at
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column products.created_at
     *
     * @param createdAt the value for products.created_at
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column products.updated_at
     *
     * @return the value of products.updated_at
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column products.updated_at
     *
     * @param updatedAt the value for products.updated_at
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column products.deleted_at
     *
     * @return the value of products.deleted_at
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public Date getDeletedAt() {
        return deletedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column products.deleted_at
     *
     * @param deletedAt the value for products.deleted_at
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
}