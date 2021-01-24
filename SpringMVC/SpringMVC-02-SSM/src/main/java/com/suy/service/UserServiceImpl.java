package com.suy.service;

import com.suy.dao.UserMapper;
import com.suy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper mapper;

    @Autowired
    public void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<User> getUsers() {
        return mapper.getUsers();
    }

    @Override
    public User getUserById(int id) {
        return mapper.getUserById(id);
    }

    @Override
    public List<User> getUsersByName(String name) {
        return mapper.getUsersByName(name);
    }

    @Override
    public List<User> getUsersByPrivilege(int privilege) {
        if (privilege < 1 || privilege > 3) {
            return new ArrayList<>();
        }
        return mapper.getUsersByPrivilege(privilege);
    }

    @Override
    public User login(String name, String passwd) {
        if (name == null || passwd == null) {
            return null;
        }
        return mapper.getUserByNameAndPasswd(name, passwd);
    }

    /**
     * 插入新用户：
     * 1. 如果当前用户的等级高于新用户的等级，则可以插入此用户
     * 2. 否则不可以插入新用户
     *
     * @return 返回1代表修改成功，返回0代表添加失败，返回-2代表无添加的权限，返回-255代表服务器错误
     */
    @Override
    @Transactional
    public int insertUser(User curUser, User newUser) {
        if (curUser == null || newUser == null) {
            return -256;
        }

        int curPrivilege = curUser.getPrivilege();
        int newPrivilege = newUser.getPrivilege();

        if (curPrivilege < 1 || curPrivilege > 3) {
            return -256;
        }
        if (newPrivilege > curPrivilege && newPrivilege <= 3) {
            return mapper.insertUser(newUser);
        }

        return -2;
    }

    /**
     * 删除用户：
     * 1. 如果当前用户的等级高于目标用户的等级，可以删除此用户
     * 2. 如果目标用户就是当前用户，可以删除当前用户，删除之后将会退出登录
     * 3. 如果目标用户的等级高于或等于当前用户的等级且不是当前用户，不可以删除此用户
     * 4. 超级管理员(等级为1)不可以被删除
     *
     * @return 返回1代表删除成功，返回0代表删除失败，返回-1代表目标用户不存在，返回-2代表无删除的权限，
     * 返回-255代表服务器错误
     */
    @Override
    @Transactional
    public int deleteUserById(User curUser, int id) {
        if (curUser == null) {
            return -256;
        }

        User targetUser;
        int curUserPrivilege = curUser.getPrivilege();
        int targetUserPrivilege;

        if (curUserPrivilege < 1 || curUserPrivilege > 3) {
            return -256;
        }
        if ((targetUser = mapper.getUserById(id)) == null) {
            return -1;
        }
        targetUserPrivilege = targetUser.getPrivilege();
        if (id == curUser.getId() || (targetUserPrivilege > curUserPrivilege && targetUserPrivilege <= 3)) {
            if (targetUserPrivilege != 1) {
                return mapper.deleteUserById(id);
            }
        }

        return -2;
    }

    /**
     * 更新用户：
     * 1. 如果当前用户的等级高于目标用户的等级，则可以更改其属性和等级，但是修改的等级不可以高于或等于当前用户的等级
     * 2. 如果目标用户就是当前用户，则可以修改其属性和等级，但是修改的等级不可以高于当前用户的等级，修改后将会重新登录
     * 3. 如果目标用户的等级高于或等于当前用户的等级且不是当前用户，不可以修改其属性和等级
     *
     * @return 返回1代表修改成功，返回0代表修改失败，返回-1代表目标用户不存在，返回-2代表无修改的权限，
     * 返回-3代表未指定修改的用户，返回-4代表未指定任何更改项，返回-255代表服务器错误
     */
    @Override
    @Transactional
    public int updateUser(User curUser, User user) {
        if (curUser == null || user == null) {
            return -256;
        }

        Integer targetUserId, targetUserNewPrivilege;
        User targetUser;
        int curUserPrivilege = curUser.getPrivilege();
        int targetUserOldPrivilege;

        if (curUserPrivilege < 1 || curUserPrivilege > 3) {
            return -256;
        }
        if ((targetUserId = user.getId()) == null) {
            return -3;
        }
        if (user.getUser() == null && user.getPasswd() == null && user.getPrivilege() == null) {
            return -4;
        }
        if ((targetUser = mapper.getUserById(targetUserId)) == null) {
            return -1;
        }
        targetUserOldPrivilege = targetUser.getPrivilege();
        if (targetUserId.equals(curUser.getId())) {
            if ((targetUserNewPrivilege = user.getPrivilege()) != null) {
                if (targetUserNewPrivilege >= curUserPrivilege && targetUserNewPrivilege <= 3) {
                    return mapper.updateUser(user);
                } else {
                    return -2;
                }
            } else {
                return mapper.updateUser(user);
            }
        } else if (targetUserOldPrivilege > curUserPrivilege && targetUserOldPrivilege <= 3) {
            if ((targetUserNewPrivilege = user.getPrivilege()) != null) {
                if (targetUserNewPrivilege > curUserPrivilege && targetUserNewPrivilege <= 3) {
                    return mapper.updateUser(user);
                } else {
                    return -2;
                }
            } else {
                return mapper.updateUser(user);
            }
        }

        return -2;
    }
}
