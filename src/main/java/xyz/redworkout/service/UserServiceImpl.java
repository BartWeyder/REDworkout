package xyz.redworkout.service;

import xyz.redworkout.model.User;

import java.util.List;

/**
 * Created by Eugenij Kizim on 04-Jun-17.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.redworkout.model.User;
import xyz.redworkout.dao.UserDao;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findById(int id) {
        return dao.findById(id);
    }

    public User findByEmail(String email) {
        User user = dao.findByEmail(email);
        return user;
    }

    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.save(user);
    }

    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends.
     */
    public void updateUser(User user) {
        User entity = dao.findById(user.getId());
        if(entity!=null){
            entity.setEmail(user.getEmail());
            if(!user.getPassword().equals(entity.getPassword())){
                entity.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            entity.setName(user.getName());
            entity.setSurname(user.getSurname());
            entity.setEmail(user.getEmail());
            entity.setUserRoles(user.getUserRoles());
        }
    }

    public void deleteUserByEmail(String email) {
        dao.deleteByEmail(email);
    }

    public List<User> findAllUsers() {
        return dao.findAllUsers();
    }

    public boolean isUserEmailUnique(Integer id, String email) {
        User user = findByEmail(email);
        return ( user == null || ((id != null) && (user.getId() == id)));
    }
}