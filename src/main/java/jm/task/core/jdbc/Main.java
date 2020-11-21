package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        //  UserService userService = new UserServiceImpl();
        UserDaoHibernateImpl hibernate = new UserDaoHibernateImpl();
        hibernate.dropUsersTable();
        hibernate.createUsersTable();
        hibernate.saveUser("Hibernate", "Stop this, man", (byte) 77);
        hibernate.getAllUsers();
        hibernate.cleanUsersTable();
        hibernate.saveUser("Hibernate", "1", (byte) 77);
        hibernate.saveUser("IsEmpty?", "2", (byte) 77);
        hibernate.saveUser("Hibernate", "3", (byte) 77);
        hibernate.removeUserById(3);



//        userService.cleanUsersTable();
//        userService.dropUsersTable();
//        userService.createUsersTable();
//        userService.saveUser("testName1", "testLastName99", (byte) 100);
//        userService.removeUserById(2);
//        userService.getAllUsers();
        System.exit(0);

    }
}
