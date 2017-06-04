package xyz.redworkout.dao;

/**
 * Created by Eugenij Kizim on 04-Jun-17.
 */

import xyz.redworkout.model.UserRole;

import java.util.List;

public interface UserRoleDao {

    List <UserRole> findAll();

    UserRole findByType(String type);

    UserRole findById(int id);
}
