package web.kata.bootApp.DAO;

import org.springframework.stereotype.Repository;
import web.kata.bootApp.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(long id, String newName, String newLastName) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            user.setName(newName);
            user.setLastName(newLastName);
            entityManager.merge(user);
        }
    }

    @Override
    public void delete(long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public User get(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }
}
