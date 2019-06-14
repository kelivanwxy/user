package com.kelivan.user.service;


import com.kelivan.user.model.User;

import java.util.Map;

public interface UserService {

   int postUser(User user);

   int deleteUser(Long id);

   int deleteUserBatch(Long[] ids);

   int putUser(Long id, User user);

    Map<String, Object> getUserList(Integer pageNum, Integer pageSize, Map<String, Object> params);

    Map<String, Object> getUser(Long id);

    Map<String, Object> isHasAdmin(Map<String, Object> params);
}
