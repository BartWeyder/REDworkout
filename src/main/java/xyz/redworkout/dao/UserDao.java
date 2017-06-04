package xyz.redworkout.dao;

/**
 * Created by Eugenij Kizim on 04-Jun-17.
 */
import java.util.List;

import xyz.redworkout.model.User;


public interface UserDao {

    User findById(int id);

    User findByEmail(String email);

    void save(User user);

    void deleteByEmail(String email);

    List<User> findAllUsers();
}
