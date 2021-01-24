package com.suy.controller;

import com.google.gson.Gson;
import com.suy.pojo.User;
import com.suy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class MainController {

    UserService userService;
    Gson gson;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setGson(Gson gson) {
        this.gson = gson;
    }

    @RequestMapping("/login")
    public String login(String name, String passwd, HttpSession session) {
        User user = userService.login(name, passwd);
        if (user == null) {
            return "错误的用户名或密码";
        }
        session.setAttribute("curUser", user);
        return "欢迎 %s".formatted(user.getUser());
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        User user = (User) session.getAttribute("curUser");
        if (user == null) {
            return "当前没有登录的用户";
        }
        session.removeAttribute("curUser");
        return "退出登录成功";
    }

    @RequestMapping("/get/self")
    public String getSelf(HttpSession session) {
        User user = (User) session.getAttribute("curUser");
        if (user == null) {
            return "当前没有登录的用户";
        }
        return gson.toJson(user);
    }

    @RequestMapping("/get/users")
    public String getUsers(HttpSession session) {
        User user = (User) session.getAttribute("curUser");
        if (user == null) {
            return "当前没有登录的用户";
        }
        List<User> users = userService.getUsers();
        return gson.toJson(users);
    }

    @RequestMapping("insert/user")
    public String insertUser(User user, HttpSession session) {
        User curUser = (User) session.getAttribute("curUser");
        if (curUser == null) {
            return "当前没有登录的用户";
        }
        if (user == null) {
            return "未指定添加的用户";
        }
        return switch (userService.insertUser(curUser, user)) {
            case 1 -> "成功添加用户%s".formatted(user.getUser());
            case 0 -> "添加用户失败！";
            case -2 -> "没有添加用户的权限";
            default -> "服务器错误";
        };
    }

    @RequestMapping("/delete/user/{id:\\d+}")
    public String deleteUser(@PathVariable("id") int id, HttpSession session) {
        User curUser = (User) session.getAttribute("curUser");
        if (curUser == null) {
            return "当前没有登录的用户";
        }
        return switch (userService.deleteUserById(curUser, id)) {
            case 1 -> "成功删除id为%d的用户".formatted(id);
            case 0 -> "删除用户失败！";
            case -1 -> "目标用户不存在";
            case -2 -> "没有删除用户的权限";
            default -> "服务器错误";
        };
    }

    @RequestMapping("/update/user")
    public String updateUser(User user, HttpSession session) {
        User curUser = (User) session.getAttribute("curUser");
        if (curUser == null) {
            return "当前没有登录的用户";
        }
        if (user == null) {
            return "未指定修改的用户";
        }
        return switch (userService.updateUser(curUser, user)) {
            case 1 -> "成功更改id为%s的用户".formatted(user.getId());
            case 0 -> "更改用户失败！";
            case -1 -> "目标用户不存在";
            case -2 -> "没有更改用户的权限";
            case -3 -> "未指定修改的用户";
            case -4 -> "未指定任何更改项";
            default -> "服务器错误";
        };
    }

}
