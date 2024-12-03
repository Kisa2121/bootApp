package web.kata.bootApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.kata.bootApp.DAO.UserDAO;
import web.kata.bootApp.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    @Transactional
    public void update(long id, String newName, String newLastName) {
        userDAO.update(id, newName, newLastName);
    }

    @Override
    @Transactional
    public void delete(long id) {
        userDAO.delete(id);
    }

    @Override
    public User get(long id) {
        return userDAO.get(id);
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }
}
