package xyz.redworkout.service;

/**
 * Created by Eugenij Kizim on 04-Jun-17.
 */
import xyz.redworkout.model.UserRole;
import java.util.List;

public interface UserRoleService {
    UserRole findById(int id);

    UserRole findByType(String type);

    List<UserRole> findAll();
}
