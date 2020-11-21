package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    private static Session session;
    private static Transaction tx;

    public UserDaoHibernateImpl() {
        session = Util.getSessionFactory().openSession();
    }

    @Override
    public void createUsersTable() {
        String query = "create table UsersTable(id int auto_increment primary key, name varchar(30), lastName varchar(30), age int(8))";
        try {
            tx = session.beginTransaction();
            Query query1 = session.createSQLQuery(query);
            query1.executeUpdate();
            tx.commit();
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        String drop = "drop table UsersTable";
        try {
            tx = session.beginTransaction();
            Query query = session.createSQLQuery(drop);
            query.executeUpdate();
            tx.commit();
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
//        String sqlSave = "INSERT into UsersTable(name, lastName, age) values ('" + name + "', '" + lastName + "', " + age + ")";
        try {
            tx = session.beginTransaction();
//            Query query1 = session.createSQLQuery(sqlSave);
//            query1.executeUpdate();
            User user = new User();
            user.setName(name);
            user.setLastName(lastName);
            user.setAge(age);
            session.save(user);
            tx.commit();
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        try {
            tx = session.beginTransaction();
            User user = (User) session.load(User.class, id);
            session.delete(user);
            tx.commit();
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try {
            tx = session.beginTransaction();
            String query = "select p from " + User.class.getSimpleName() + " p";
            list = (List<User>) session.createQuery(query).list();
            System.out.println(list);
            tx.commit();
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void cleanUsersTable() {
        String q = "DELETE FROM UsersTable";
        try {
            tx = session.beginTransaction();
            Query query = session.createSQLQuery(q);
            query.executeUpdate();
            tx.commit();
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
}
