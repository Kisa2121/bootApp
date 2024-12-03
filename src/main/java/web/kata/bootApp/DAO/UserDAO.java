package web.kata.bootApp.DAO;

import web.kata.bootApp.model.User;

import java.util.List;

public interface UserDAO {
    void add(User user);

    void update(long id, String newName, String newLastName);

    void delete(long id);

    User get(long id);

    List<User> getAll();
}
