package com.kelivan.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kelivan.user.dao.UserMapper;
import com.kelivan.user.model.User;
import com.kelivan.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int postUser(User user) {
        return userMapper.postUser(user);
    }

    @Override
    public int deleteUser(Long id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public int deleteUserBatch(Long[] ids) {
        return userMapper.deleteUserBatch(ids);
    }

    @Override
    public int putUser(Long id, User user) {
        user.setId(id);
        return userMapper.putUser(user);
    }

    @Override
    @SuppressWarnings("all")
    public Map<String, Object> getUserList(Integer pageNum, Integer pageSize, Map<String, Object> params) {
        if (pageNum != null && pageSize != null) {
            PageHelper.startPage(pageNum, pageSize);
        }
        List<Map<String, Object>> list = userMapper.getUserList(params);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list);
        Map<String,Object> map =new HashMap();
        map.put("list",list);
        map.put("page",pageNum);
        map.put("page_size",pageSize);
        map.put("total_count",pageInfo.getTotal());
        return map;
    }

    @Override
    public Map<String, Object> getUser(Long id) {
        return userMapper.getUser(id);
    }

    @Override
    public Map<String, Object> isHasAdmin(Map<String, Object> params) {
        return userMapper.isHasAdmin(params);
    }
}
