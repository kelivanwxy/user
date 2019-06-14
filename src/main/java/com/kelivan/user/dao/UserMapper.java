package com.kelivan.user.dao;

import com.kelivan.user.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    int postUser(User user);

    int deleteUser(Long id);

    int deleteUserBatch(Long[] ids);

    int putUser(User user);

    List<Map<String, Object>> getUserList(Map<String, Object> params);

    Map<String, Object> getUser(Long id);

    Map<String, Object> isHasAdmin(Map<String, Object> params);
}