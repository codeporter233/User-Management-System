package service;

import domain.PageBean;
import domain.User;

import java.util.List;
import java.util.Map;

public interface Service {
    public List<User> findAllUsers();

    /*
     * 返回1登录成功
     * 返回0密码或用户名错误
     * 返回-1没有这个用户*/
    public int login(String name, String password);

    public void addUser(User user);

    public void delUser(int id);

    public User findUserById(int id);

    void updateUser(User user);

    public void delUsers(String[] ids);

    PageBean findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
//    PageBean findUserByPage(String currentPage, String rows);
}
