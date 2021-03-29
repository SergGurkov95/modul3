package dao;

import model.Follovers;
import model.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateSessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ConnectionDaoClass {
    private SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();


    public void create(Follovers follovers) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(follovers);
            session.getTransaction().commit();
        }
    }


    public Object update(Object model) {
        return null;
    }


    public Object findById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Post.class, id);
        }
    }


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


    public void deleteById(Follovers follovers) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.save(follovers);
            session.getTransaction().commit();
        }
    }
}
