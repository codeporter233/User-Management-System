package dao.impl;


import dao.Dao;
import domain.Admin;
import domain.User;
import org.junit.Test;

import java.util.List;

public class DaoImplTest {

    private Dao dao = new DaoImpl();
    @Test
    public void testUsers() {
        List<User> users = dao.findAllUsers();
        for (User user:users
             ) {
            System.out.println(user);
        }
    }
    @Test
    public void testAdmins() {
        List<Admin> admins = dao.findAllAdmins();
        for (Admin admin:admins
        ) {
            System.out.println(admin);
        }
    }

    @Test
    public void testAdd() {
        User user = new User("白居易","110@163.com","110","男",18,"江苏");
        dao.addUser(user);
    }

    @Test
    public void testDel() {
        dao.delUser(10);
    }

    @Test
    public void testFind() {
        User user = dao.findUserById(2);
        System.out.println(user);
    }

//    @Test
//    public void testTotalCount() {
//        System.out.println(dao.findTotalCount());
//    }
//
//    @Test
//    public void testFindByPage() {
//        List<User> users = dao.findByPage(0,5);
//
//        for (User user:users
//             ) {
//            System.out.println(user);
//
//        }
//    }
}