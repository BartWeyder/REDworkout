package xyz.redworkout.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import org.springframework.stereotype.Component;
import xyz.redworkout.model.UserRole;
import xyz.redworkout.service.UserRoleService;

/**
 * Created by Eugenij Kizim on 04-Jun-17.
 */
@Component
public class RoleToUserRoleConverter implements Converter<Object, UserRole> {
    static final Logger logger = LoggerFactory.getLogger(RoleToUserRoleConverter.class);

    @Autowired
    UserRoleService userRoleService;

    /**
     * Gets UserProfile by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public UserRole convert(Object element) {
        Integer id = Integer.parseInt((String)element);
        UserRole profile= userRoleService.findById(id);
        logger.info("Profile : {}",profile);
        return profile;
    }
}
