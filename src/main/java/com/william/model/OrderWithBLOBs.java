package com.william.model;

public class OrderWithBLOBs extends Order {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.custom_field
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    private String customField;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.remark
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.custom_field
     *
     * @return the value of orders.custom_field
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public String getCustomField() {
        return customField;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.custom_field
     *
     * @param customField the value for orders.custom_field
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public void setCustomField(String customField) {
        this.customField = customField == null ? null : customField.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.remark
     *
     * @return the value of orders.remark
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.remark
     *
     * @param remark the value for orders.remark
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}