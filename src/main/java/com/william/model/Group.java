package com.william.model;

public class Group {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column groups.id
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column groups.name
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column groups.is_admin
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    private Byte isAdmin;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column groups.id
     *
     * @return the value of groups.id
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column groups.id
     *
     * @param id the value for groups.id
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column groups.name
     *
     * @return the value of groups.name
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column groups.name
     *
     * @param name the value for groups.name
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column groups.is_admin
     *
     * @return the value of groups.is_admin
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public Byte getIsAdmin() {
        return isAdmin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column groups.is_admin
     *
     * @param isAdmin the value for groups.is_admin
     *
     * @mbggenerated Sat Mar 18 23:41:51 CST 2017
     */
    public void setIsAdmin(Byte isAdmin) {
        this.isAdmin = isAdmin;
    }
}