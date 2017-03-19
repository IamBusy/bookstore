package com.william.mapper;

import com.william.model.GroupUserExample;
import com.william.model.GroupUserKey;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface GroupUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group
     *
     * @mbggenerated Sun Mar 19 14:12:31 CST 2017
     */
    @SelectProvider(type=GroupUserSqlProvider.class, method="countByExample")
    int countByExample(GroupUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group
     *
     * @mbggenerated Sun Mar 19 14:12:31 CST 2017
     */
    @DeleteProvider(type=GroupUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(GroupUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group
     *
     * @mbggenerated Sun Mar 19 14:12:31 CST 2017
     */
    @Delete({
        "delete from user_group",
        "where user_id = #{userId,jdbcType=INTEGER}",
          "and group_id = #{groupId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(GroupUserKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group
     *
     * @mbggenerated Sun Mar 19 14:12:31 CST 2017
     */
    @Insert({
        "insert into user_group (user_id, group_id)",
        "values (#{userId,jdbcType=INTEGER}, #{groupId,jdbcType=INTEGER})"
    })
    int insert(GroupUserKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group
     *
     * @mbggenerated Sun Mar 19 14:12:31 CST 2017
     */
    @InsertProvider(type=GroupUserSqlProvider.class, method="insertSelective")
    int insertSelective(GroupUserKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group
     *
     * @mbggenerated Sun Mar 19 14:12:31 CST 2017
     */
    @SelectProvider(type=GroupUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.INTEGER, id=true)
    })
    List<GroupUserKey> selectByExample(GroupUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group
     *
     * @mbggenerated Sun Mar 19 14:12:31 CST 2017
     */
    @UpdateProvider(type=GroupUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") GroupUserKey record, @Param("example") GroupUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group
     *
     * @mbggenerated Sun Mar 19 14:12:31 CST 2017
     */
    @UpdateProvider(type=GroupUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") GroupUserKey record, @Param("example") GroupUserExample example);
}