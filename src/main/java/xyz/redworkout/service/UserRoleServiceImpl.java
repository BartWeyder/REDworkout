package xyz.redworkout.service;

import xyz.redworkout.model.UserRole;
import xyz.redworkout.dao.UserRoleDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * Created by Eugenij Kizim on 04-Jun-17.
 */

@Service("userProfileService")
@Transactional
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleDao dao;

    @Override
    public UserRole findById(int id) {
        return dao.findById(id);
    }

    @Override
    public UserRole findByType(String type) {
        return dao.findByType(type);
    }

    @Override
    public List<UserRole> findAll() {
        return dao.findAll();
    }
}
