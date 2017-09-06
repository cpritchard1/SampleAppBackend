package com.myapp.MyAppBackend.infrastructure.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Base class for value -> entity converters - objects that convert a list of domain object to a
 * list of entity object.
 *
 * <p>The class is generified - E is the entity object class and D is the domain object class.
 */
public abstract class DomainToEntityListConverter<D, E> {

    private List<D> domainObjectList;

    public DomainToEntityListConverter(List<D> domainObjectList) {
        this.domainObjectList = Objects.requireNonNull(domainObjectList);
    }

    public List<E> toEntityObjects() {
        final List<E> entityList = new ArrayList<>();

        if (!domainObjectList.isEmpty()) {
            domainObjectList.forEach((D d) -> entityList.add(convertSingleDomainObject(d)));
        }

        return entityList;
    }

    protected E convertSingleDomainObject(D domain) {
        throw new UnsupportedOperationException(
                "convertSingleDomainObject should be implemented in a subclass.");
    }
}
