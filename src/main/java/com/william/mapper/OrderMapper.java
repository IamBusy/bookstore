package com.william.mapper;

import com.william.model.Order;
import com.william.model.OrderExample;
import com.william.model.OrderWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface OrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Fri Mar 17 15:26:19 CST 2017
     */
    @SelectProvider(type=OrderSqlProvider.class, method="countByExample")
    int countByExample(OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Fri Mar 17 15:26:19 CST 2017
     */
    @DeleteProvider(type=OrderSqlProvider.class, method="deleteByExample")
    int deleteByExample(OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Fri Mar 17 15:26:19 CST 2017
     */
    @Delete({
        "delete from orders",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Fri Mar 17 15:26:19 CST 2017
     */
    @Insert({
        "insert into orders (id, mode, ",
        "store_name, user_name, ",
        "total, discount, ",
        "actual_pay_foregift, foregift, ",
        "coupon_id, pay_amount, ",
        "phone, user_id, store_id, ",
        "order_status_id, payment_id, ",
        "payment_name, actual_pay_amount, ",
        "shipping_id, shipping_name, ",
        "school_id, school_name, ",
        "province, province_name, ",
        "city, city_name, ",
        "district, district_name, ",
        "address, postcode, ",
        "ip, created_at, ",
        "updated_at, deleted_at, ",
        "ispaid, shipping_amount, ",
        "express_number, reservation_pay_time, ",
        "custom_field, remark)",
        "values (#{id,jdbcType=INTEGER}, #{mode,jdbcType=SMALLINT}, ",
        "#{storeName,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, ",
        "#{total,jdbcType=DECIMAL}, #{discount,jdbcType=DECIMAL}, ",
        "#{actualPayForegift,jdbcType=DECIMAL}, #{foregift,jdbcType=DECIMAL}, ",
        "#{couponId,jdbcType=INTEGER}, #{payAmount,jdbcType=DECIMAL}, ",
        "#{phone,jdbcType=VARCHAR}, #{userId,jdbcType=INTEGER}, #{storeId,jdbcType=INTEGER}, ",
        "#{orderStatusId,jdbcType=INTEGER}, #{paymentId,jdbcType=INTEGER}, ",
        "#{paymentName,jdbcType=VARCHAR}, #{actualPayAmount,jdbcType=DECIMAL}, ",
        "#{shippingId,jdbcType=INTEGER}, #{shippingName,jdbcType=VARCHAR}, ",
        "#{schoolId,jdbcType=INTEGER}, #{schoolName,jdbcType=VARCHAR}, ",
        "#{province,jdbcType=INTEGER}, #{provinceName,jdbcType=VARCHAR}, ",
        "#{city,jdbcType=INTEGER}, #{cityName,jdbcType=VARCHAR}, ",
        "#{district,jdbcType=INTEGER}, #{districtName,jdbcType=VARCHAR}, ",
        "#{address,jdbcType=VARCHAR}, #{postcode,jdbcType=CHAR}, ",
        "#{ip,jdbcType=VARCHAR}, #{createdAt,jdbcType=TIMESTAMP}, ",
        "#{updatedAt,jdbcType=TIMESTAMP}, #{deletedAt,jdbcType=TIMESTAMP}, ",
        "#{ispaid,jdbcType=TINYINT}, #{shippingAmount,jdbcType=DECIMAL}, ",
        "#{expressNumber,jdbcType=VARCHAR}, #{reservationPayTime,jdbcType=DATE}, ",
        "#{customField,jdbcType=LONGVARCHAR}, #{remark,jdbcType=LONGVARCHAR})"
    })
    int insert(OrderWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Fri Mar 17 15:26:19 CST 2017
     */
    @InsertProvider(type=OrderSqlProvider.class, method="insertSelective")
    int insertSelective(OrderWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Fri Mar 17 15:26:19 CST 2017
     */
    @SelectProvider(type=OrderSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="mode", property="mode", jdbcType=JdbcType.SMALLINT),
        @Result(column="store_name", property="storeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="total", property="total", jdbcType=JdbcType.DECIMAL),
        @Result(column="discount", property="discount", jdbcType=JdbcType.DECIMAL),
        @Result(column="actual_pay_foregift", property="actualPayForegift", jdbcType=JdbcType.DECIMAL),
        @Result(column="foregift", property="foregift", jdbcType=JdbcType.DECIMAL),
        @Result(column="coupon_id", property="couponId", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_amount", property="payAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="store_id", property="storeId", jdbcType=JdbcType.INTEGER),
        @Result(column="order_status_id", property="orderStatusId", jdbcType=JdbcType.INTEGER),
        @Result(column="payment_id", property="paymentId", jdbcType=JdbcType.INTEGER),
        @Result(column="payment_name", property="paymentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="actual_pay_amount", property="actualPayAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="shipping_id", property="shippingId", jdbcType=JdbcType.INTEGER),
        @Result(column="shipping_name", property="shippingName", jdbcType=JdbcType.VARCHAR),
        @Result(column="school_id", property="schoolId", jdbcType=JdbcType.INTEGER),
        @Result(column="school_name", property="schoolName", jdbcType=JdbcType.VARCHAR),
        @Result(column="province", property="province", jdbcType=JdbcType.INTEGER),
        @Result(column="province_name", property="provinceName", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.INTEGER),
        @Result(column="city_name", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="district", property="district", jdbcType=JdbcType.INTEGER),
        @Result(column="district_name", property="districtName", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="postcode", property="postcode", jdbcType=JdbcType.CHAR),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleted_at", property="deletedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ispaid", property="ispaid", jdbcType=JdbcType.TINYINT),
        @Result(column="shipping_amount", property="shippingAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="express_number", property="expressNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="reservation_pay_time", property="reservationPayTime", jdbcType=JdbcType.DATE),
        @Result(column="custom_field", property="customField", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<OrderWithBLOBs> selectByExampleWithBLOBs(OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Fri Mar 17 15:26:19 CST 2017
     */
    @SelectProvider(type=OrderSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="mode", property="mode", jdbcType=JdbcType.SMALLINT),
        @Result(column="store_name", property="storeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="total", property="total", jdbcType=JdbcType.DECIMAL),
        @Result(column="discount", property="discount", jdbcType=JdbcType.DECIMAL),
        @Result(column="actual_pay_foregift", property="actualPayForegift", jdbcType=JdbcType.DECIMAL),
        @Result(column="foregift", property="foregift", jdbcType=JdbcType.DECIMAL),
        @Result(column="coupon_id", property="couponId", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_amount", property="payAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="store_id", property="storeId", jdbcType=JdbcType.INTEGER),
        @Result(column="order_status_id", property="orderStatusId", jdbcType=JdbcType.INTEGER),
        @Result(column="payment_id", property="paymentId", jdbcType=JdbcType.INTEGER),
        @Result(column="payment_name", property="paymentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="actual_pay_amount", property="actualPayAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="shipping_id", property="shippingId", jdbcType=JdbcType.INTEGER),
        @Result(column="shipping_name", property="shippingName", jdbcType=JdbcType.VARCHAR),
        @Result(column="school_id", property="schoolId", jdbcType=JdbcType.INTEGER),
        @Result(column="school_name", property="schoolName", jdbcType=JdbcType.VARCHAR),
        @Result(column="province", property="province", jdbcType=JdbcType.INTEGER),
        @Result(column="province_name", property="provinceName", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.INTEGER),
        @Result(column="city_name", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="district", property="district", jdbcType=JdbcType.INTEGER),
        @Result(column="district_name", property="districtName", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="postcode", property="postcode", jdbcType=JdbcType.CHAR),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleted_at", property="deletedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ispaid", property="ispaid", jdbcType=JdbcType.TINYINT),
        @Result(column="shipping_amount", property="shippingAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="express_number", property="expressNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="reservation_pay_time", property="reservationPayTime", jdbcType=JdbcType.DATE)
    })
    List<Order> selectByExample(OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Fri Mar 17 15:26:19 CST 2017
     */
    @Select({
        "select",
        "id, mode, store_name, user_name, total, discount, actual_pay_foregift, foregift, ",
        "coupon_id, pay_amount, phone, user_id, store_id, order_status_id, payment_id, ",
        "payment_name, actual_pay_amount, shipping_id, shipping_name, school_id, school_name, ",
        "province, province_name, city, city_name, district, district_name, address, ",
        "postcode, ip, created_at, updated_at, deleted_at, ispaid, shipping_amount, express_number, ",
        "reservation_pay_time, custom_field, remark",
        "from orders",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="mode", property="mode", jdbcType=JdbcType.SMALLINT),
        @Result(column="store_name", property="storeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="total", property="total", jdbcType=JdbcType.DECIMAL),
        @Result(column="discount", property="discount", jdbcType=JdbcType.DECIMAL),
        @Result(column="actual_pay_foregift", property="actualPayForegift", jdbcType=JdbcType.DECIMAL),
        @Result(column="foregift", property="foregift", jdbcType=JdbcType.DECIMAL),
        @Result(column="coupon_id", property="couponId", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_amount", property="payAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="store_id", property="storeId", jdbcType=JdbcType.INTEGER),
        @Result(column="order_status_id", property="orderStatusId", jdbcType=JdbcType.INTEGER),
        @Result(column="payment_id", property="paymentId", jdbcType=JdbcType.INTEGER),
        @Result(column="payment_name", property="paymentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="actual_pay_amount", property="actualPayAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="shipping_id", property="shippingId", jdbcType=JdbcType.INTEGER),
        @Result(column="shipping_name", property="shippingName", jdbcType=JdbcType.VARCHAR),
        @Result(column="school_id", property="schoolId", jdbcType=JdbcType.INTEGER),
        @Result(column="school_name", property="schoolName", jdbcType=JdbcType.VARCHAR),
        @Result(column="province", property="province", jdbcType=JdbcType.INTEGER),
        @Result(column="province_name", property="provinceName", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.INTEGER),
        @Result(column="city_name", property="cityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="district", property="district", jdbcType=JdbcType.INTEGER),
        @Result(column="district_name", property="districtName", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="postcode", property="postcode", jdbcType=JdbcType.CHAR),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleted_at", property="deletedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ispaid", property="ispaid", jdbcType=JdbcType.TINYINT),
        @Result(column="shipping_amount", property="shippingAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="express_number", property="expressNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="reservation_pay_time", property="reservationPayTime", jdbcType=JdbcType.DATE),
        @Result(column="custom_field", property="customField", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.LONGVARCHAR)
    })
    OrderWithBLOBs selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Fri Mar 17 15:26:19 CST 2017
     */
    @UpdateProvider(type=OrderSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OrderWithBLOBs record, @Param("example") OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Fri Mar 17 15:26:19 CST 2017
     */
    @UpdateProvider(type=OrderSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") OrderWithBLOBs record, @Param("example") OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Fri Mar 17 15:26:19 CST 2017
     */
    @UpdateProvider(type=OrderSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Fri Mar 17 15:26:19 CST 2017
     */
    @UpdateProvider(type=OrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OrderWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Fri Mar 17 15:26:19 CST 2017
     */
    @Update({
        "update orders",
        "set mode = #{mode,jdbcType=SMALLINT},",
          "store_name = #{storeName,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "total = #{total,jdbcType=DECIMAL},",
          "discount = #{discount,jdbcType=DECIMAL},",
          "actual_pay_foregift = #{actualPayForegift,jdbcType=DECIMAL},",
          "foregift = #{foregift,jdbcType=DECIMAL},",
          "coupon_id = #{couponId,jdbcType=INTEGER},",
          "pay_amount = #{payAmount,jdbcType=DECIMAL},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "store_id = #{storeId,jdbcType=INTEGER},",
          "order_status_id = #{orderStatusId,jdbcType=INTEGER},",
          "payment_id = #{paymentId,jdbcType=INTEGER},",
          "payment_name = #{paymentName,jdbcType=VARCHAR},",
          "actual_pay_amount = #{actualPayAmount,jdbcType=DECIMAL},",
          "shipping_id = #{shippingId,jdbcType=INTEGER},",
          "shipping_name = #{shippingName,jdbcType=VARCHAR},",
          "school_id = #{schoolId,jdbcType=INTEGER},",
          "school_name = #{schoolName,jdbcType=VARCHAR},",
          "province = #{province,jdbcType=INTEGER},",
          "province_name = #{provinceName,jdbcType=VARCHAR},",
          "city = #{city,jdbcType=INTEGER},",
          "city_name = #{cityName,jdbcType=VARCHAR},",
          "district = #{district,jdbcType=INTEGER},",
          "district_name = #{districtName,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "postcode = #{postcode,jdbcType=CHAR},",
          "ip = #{ip,jdbcType=VARCHAR},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP},",
          "updated_at = #{updatedAt,jdbcType=TIMESTAMP},",
          "deleted_at = #{deletedAt,jdbcType=TIMESTAMP},",
          "ispaid = #{ispaid,jdbcType=TINYINT},",
          "shipping_amount = #{shippingAmount,jdbcType=DECIMAL},",
          "express_number = #{expressNumber,jdbcType=VARCHAR},",
          "reservation_pay_time = #{reservationPayTime,jdbcType=DATE},",
          "custom_field = #{customField,jdbcType=LONGVARCHAR},",
          "remark = #{remark,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(OrderWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Fri Mar 17 15:26:19 CST 2017
     */
    @Update({
        "update orders",
        "set mode = #{mode,jdbcType=SMALLINT},",
          "store_name = #{storeName,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "total = #{total,jdbcType=DECIMAL},",
          "discount = #{discount,jdbcType=DECIMAL},",
          "actual_pay_foregift = #{actualPayForegift,jdbcType=DECIMAL},",
          "foregift = #{foregift,jdbcType=DECIMAL},",
          "coupon_id = #{couponId,jdbcType=INTEGER},",
          "pay_amount = #{payAmount,jdbcType=DECIMAL},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "store_id = #{storeId,jdbcType=INTEGER},",
          "order_status_id = #{orderStatusId,jdbcType=INTEGER},",
          "payment_id = #{paymentId,jdbcType=INTEGER},",
          "payment_name = #{paymentName,jdbcType=VARCHAR},",
          "actual_pay_amount = #{actualPayAmount,jdbcType=DECIMAL},",
          "shipping_id = #{shippingId,jdbcType=INTEGER},",
          "shipping_name = #{shippingName,jdbcType=VARCHAR},",
          "school_id = #{schoolId,jdbcType=INTEGER},",
          "school_name = #{schoolName,jdbcType=VARCHAR},",
          "province = #{province,jdbcType=INTEGER},",
          "province_name = #{provinceName,jdbcType=VARCHAR},",
          "city = #{city,jdbcType=INTEGER},",
          "city_name = #{cityName,jdbcType=VARCHAR},",
          "district = #{district,jdbcType=INTEGER},",
          "district_name = #{districtName,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "postcode = #{postcode,jdbcType=CHAR},",
          "ip = #{ip,jdbcType=VARCHAR},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP},",
          "updated_at = #{updatedAt,jdbcType=TIMESTAMP},",
          "deleted_at = #{deletedAt,jdbcType=TIMESTAMP},",
          "ispaid = #{ispaid,jdbcType=TINYINT},",
          "shipping_amount = #{shippingAmount,jdbcType=DECIMAL},",
          "express_number = #{expressNumber,jdbcType=VARCHAR},",
          "reservation_pay_time = #{reservationPayTime,jdbcType=DATE}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Order record);
}