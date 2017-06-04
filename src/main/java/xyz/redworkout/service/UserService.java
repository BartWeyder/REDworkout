package xyz.redworkout.service;

/**
 * Created by Eugenij Kizim on 04-Jun-17.
 */
import java.util.List;

import xyz.redworkout.model.User;


public interface UserService {

    User findById(int id);

    User findByEmail(String email);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserByEmail(String email);

    List<User> findAllUsers();

    boolean isUserEmailUnique(Integer id, String email);

}