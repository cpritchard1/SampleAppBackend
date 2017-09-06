package com.myapp.MyAppBackend.infrastructure.converter;

/**
 * Base class for domain -> entity converters - objects that convert domain objects to entity objects.
 *
 * <p>The class is generified - E is the entity object class and D is the domain object class.
 */
public abstract class DomainToEntityConverter<D, E> {

    private E entityObject;

    public DomainToEntityConverter(D domainObject) {
        this.entityObject = convertSingleDomainObject(domainObject);
    }

    protected E convertSingleDomainObject(D domainObject) {
        throw new UnsupportedOperationException(
                "convertSingleDomainObject should be implemented in a subclass.");
    }

    public E toEntityObject() {
        return entityObject;
    }
}
