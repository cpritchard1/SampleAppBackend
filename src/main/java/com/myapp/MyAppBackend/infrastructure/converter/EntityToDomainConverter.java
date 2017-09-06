package com.myapp.MyAppBackend.infrastructure.converter;

/**
 * Base class for entity -> value converters - objects that convert entity objects to value objects.
 *
 * <p>The class is generified - E is the entity object class and V is the value object class.
 */
public class EntityToDomainConverter<E, D> {

    protected E entity;

    public EntityToDomainConverter(E entity) {
        this.entity = entity;
    }

    public D toDomainObject() {
        return convertSingleEntityObject(entity);
    }

    protected D convertSingleEntityObject(E entity) {
        throw new UnsupportedOperationException(
                "convertSingleEntityObject should be implemented in a subclass.");
    }
}
