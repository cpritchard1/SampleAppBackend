package com.myapp.MyAppBackend.User;

import com.myapp.MyAppBackend.infrastructure.converter.EntityToDomainConverter;

/**
 * Created by cpritcha on 9/5/17.
 */

public class PUserToUserConverter extends EntityToDomainConverter<PUser, User> {

    PUserToUserConverter(PUser entity) { super(entity); }

    @Override
    protected User convertSingleEntityObject(PUser entity) {
        return new User(
                entity.getUserId(),
                entity.getUserName(),
                entity.getGender(),
                entity.getPassword()
        );
    }
}
