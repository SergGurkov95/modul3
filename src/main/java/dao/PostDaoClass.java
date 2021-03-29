package dao;

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateSessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class PostDaoClass implements Dao{
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
    public Post findById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Post.class, id);
        }
    }

    @Override
    public List findAll() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Post> query = builder.createQuery(Post.class);
            Root<Post> root = query.from(Post.class);
            List<Post> categoryList = session.createQuery(query).getResultList();
            session.getTransaction().commit();
            return categoryList;
        }
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
