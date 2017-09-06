package com.myapp.MyAppBackend.infrastructure.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Base class for entity -> value list converters - objects that convert a list of entity objects to
 * a list of domain objects.
 *
 * <p>The class is generified - E is the entity object class and V is the value object class.
 */
public class EntityToDomainListConverter<E, D> {

    private List<E> entityList;

    public EntityToDomainListConverter(List<E> entityList) {
        this.entityList = Objects.requireNonNull(entityList);
    }

    public List<D> toDomainObjects() {
        final List<D> domainList = new ArrayList<>();

        if (!entityList.isEmpty()) {
            entityList.forEach((E e) -> domainList.add(convertSingleEntityObject(e)));
        }

        return domainList;
    }

    protected D convertSingleEntityObject(E entity) {
        throw new UnsupportedOperationException(
                "convertSingleEntityObject should be implemented in a subclass.");
    }
}
