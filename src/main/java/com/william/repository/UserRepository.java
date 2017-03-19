package com.william.repository;

import com.william.mapper.GroupMapper;
import com.william.mapper.GroupUserMapper;
import com.william.mapper.UserMapper;
import com.william.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by william on 17/3/18.
 */
@Repository
public class UserRepository {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private GroupUserMapper groupUserMapper;

    @Autowired
    private GroupMapper groupMapper;



    public User selectByPhone(String phone)
    {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andPhoneEqualTo(phone);
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size()==0)
        {
            return  null;
        }
        return users.get(0);
    }

    public List<Group> getGroups(String phone)
    {
        List<Group> groups = new ArrayList<>();
        User user = this.selectByPhone(phone);
        GroupUserExample groupUserExample = new GroupUserExample();
        groupUserExample.createCriteria().andUserIdEqualTo(user.getId());
        List<GroupUserKey> groupUserKeyList= groupUserMapper.selectByExample(groupUserExample);

        groupUserKeyList.forEach((key)->{
            groups.add(groupMapper.selectByPrimaryKey(key.getGroupId()));
        });

        return groups;
    }

    public User create(String phone,String pwd,String name)
    {
        Date curTime = new Date();
        Date createdAt = new Date(curTime.getYear(),curTime.getMonth(),curTime.getDay(),
                curTime.getHours(),curTime.getMinutes(),curTime.getSeconds());

        User user = new User();
        user.setBalance(new BigDecimal(0));
        user.setSchoolId(1);
        user.setPoints(1);
        user.setPhone(phone);
        user.setPassword(pwd);
        user.setUserName(name);
        user.setCreatedAt(createdAt);
        UserExample userExample = new UserExample();
        userMapper.insert(user);
        userExample.createCriteria().andCreatedAtEqualTo(createdAt);
        return userMapper.selectByExample(userExample).get(0);
    }
}
