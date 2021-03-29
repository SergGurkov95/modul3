package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateSessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDaoClass implements Dao{
    private SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();

    @Override
    public Object create(Object model) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(model);
            session.getTransaction().commit();
        }
        return null;
    }

    @Override
    public Object update(Object model) {
        return null;
    }

    @Override
    public User findById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(User.class, id);
        }
    }

    @Override
    public List findAll() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<User> query = builder.createQuery(User.class);
            Root<User> root = query.from(User.class);
            List<User> categoryList = session.createQuery(query).getResultList();
            session.getTransaction().commit();
            return categoryList;
        }
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
