package xyz.redworkout.dao;

/**
 * Created by Eugenij Kizim on 04-Jun-17.
 */
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import xyz.redworkout.model.UserRole;

@Repository("userProfileDao")
public class UserRoleDaoImpl extends  AbstractDao<Integer, UserRole>implements UserRoleDao {
    @Override
    public List<UserRole> findAll() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("type"));
        return (List<UserRole>)crit.list();
    }

    @Override
    public UserRole findByType(String type) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("type", type));
        return (UserRole) crit.uniqueResult();
    }

    @Override
    public UserRole findById(int id) {
        return getByKey(id);
    }
}
