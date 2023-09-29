package vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.db.ConnectDB;

import java.util.List;
import java.util.Optional;



public class CRUDRepository<T> {
    private SessionFactory sessionFactory;
    private final Class<T> entityClass;
   protected Logger logger;
    public CRUDRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
        sessionFactory = ConnectDB.getInstance().getSessionFactory();
    }

    public T findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(entityClass, id);
        }
    }
    public Optional<T> findById(long id){
        try(Session session=sessionFactory.openSession()){
            return Optional.ofNullable(session.find(entityClass,id));
        }
    }

    public boolean insert(T entity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error(e.getMessage());
            return false;
        }
    }

    public boolean update(T entity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error(e.getMessage());
            return false;
        }
    }

    public boolean delete(Long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            T entity = session.find(entityClass, id);
            if (entity != null) {
                session.remove(entity);
                transaction.commit();
                return true;
            } else {
                transaction.rollback();
                return false;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error(e.getMessage());
            return false;
        }
    }
    //Lấy danh sách
 public List<T> getAll(){
        try(Session session=sessionFactory.openSession()){
            return session.createQuery("from "+entityClass.getSimpleName(),entityClass).getResultList();
        }
    }


}
