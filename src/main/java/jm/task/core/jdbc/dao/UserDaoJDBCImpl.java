package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    private static Connection connection;

    public UserDaoJDBCImpl() {
        try {
            connection = Util.getConnection();
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            System.out.println("Connection failed...");
            e.printStackTrace();
        }
    }

    public void createUsersTable() {
        String query = "create table UsersTable(id int auto_increment primary key, name varchar(30), lastName varchar(30), age int(8))";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String sqlDrop = "drop table UsersTable";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlDrop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sqlSave = " INSERT UsersTable(name, lastName, age) VALUES ('" + name + "', '" + lastName + "', " + age + ")";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlSave);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String sqlRemove = "DELETE FROM UsersTable where id = " + id;

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlRemove);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<User>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from UsersTable");
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                list.add(user);
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void cleanUsersTable() {
        String sqlDelete = "DELETE FROM userstable";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlDelete);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
