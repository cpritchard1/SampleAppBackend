package com.myapp.MyAppBackend.User;

import com.myapp.MyAppBackend.infrastructure.converter.DomainToEntityConverter;

/**
 * Created by cpritcha on 9/5/17.
 */
public class UserToPUserConverter extends DomainToEntityConverter<User, PUser>{

    UserToPUserConverter(User domain) { super(domain); }

    @Override
    public PUser convertSingleDomainObject(User domainObj) {
        return new PUser(
                domainObj.getUserName(),
                domainObj.getGender(),
                domainObj.getPassword()
        );
    }
}
