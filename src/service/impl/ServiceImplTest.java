package service.impl;

import dao.Dao;
import dao.impl.DaoImpl;
import domain.Admin;
import domain.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceImplTest {

    @Test
    public void findAllUsers() {
        Dao dao = new DaoImpl();
        for (User user:dao.findAllUsers()
             ) {
            System.out.println(user);
        }
    }

    @Test
    public void login() {
        Dao dao = new DaoImpl();
        for (Admin admin:dao.findAllAdmins()
             ) {
            System.out.println(admin);
        }
    }
}