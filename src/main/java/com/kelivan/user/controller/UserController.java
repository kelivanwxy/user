package com.kelivan.user.controller;


import com.kelivan.user.model.User;
import com.kelivan.user.service.UserService;
import com.kelivan.user.utils.Msg;
import com.kelivan.user.utils.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * development分支
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;


    @RequestMapping(value = "/users",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Msg postUser(@RequestBody User user){
        userService.postUser(user);
        return ResultUtil.success(user);
    }

    @RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE)
    public Msg deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResultUtil.success(id);
    }

    @RequestMapping(value = "/usersBatch/{ids}",method = RequestMethod.DELETE)
    public Msg deleteUserBatch(@PathVariable Long[] ids){
        userService.deleteUserBatch(ids);
        return ResultUtil.success();
    }

    @RequestMapping(value = "/users/{id}",method = RequestMethod.PUT,produces ="application/json;charset=UTF-8")
    public Msg putUser(@PathVariable Long id,@RequestBody User user){
        userService.putUser(id,user);
        return ResultUtil.success();
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Msg getUserList (@RequestParam(value = "pageNum", required = false,defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize", required = false,defaultValue = "5") Integer pageSize,
                            @RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "ip", required = false) String ip){

        Map<String, Object> params = new HashMap();
        if (name != null) {
            params.put("name", "%" + name + "%");
        }
        if (ip != null) {
            params.put("ip", "%" + ip + "%");
        }

        return ResultUtil.success(userService.getUserList(pageNum,pageSize,params));
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Msg getUser (@PathVariable Long id){

        Map<String, Object> map = userService.getUser(id);

        return ResultUtil.success(map);
    }
}
