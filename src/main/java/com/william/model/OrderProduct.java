package com.william.model;

import java.math.BigDecimal;

public class OrderProduct extends OrderProductKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_order.quantity
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    private Integer quantity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_order.price
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    private BigDecimal price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_order.isnew
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    private Short isnew;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_order.quantity
     *
     * @return the value of product_order.quantity
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_order.quantity
     *
     * @param quantity the value for product_order.quantity
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_order.price
     *
     * @return the value of product_order.price
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_order.price
     *
     * @param price the value for product_order.price
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_order.isnew
     *
     * @return the value of product_order.isnew
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public Short getIsnew() {
        return isnew;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_order.isnew
     *
     * @param isnew the value for product_order.isnew
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public void setIsnew(Short isnew) {
        this.isnew = isnew;
    }
}