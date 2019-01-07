package com.saman.hexad.business.repository;


import com.saman.hexad.model.AbstractModel;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 * @since 2019-01-05
 */

public abstract class AbstractRepository<ID extends Serializable, M extends AbstractModel<ID>> implements CrudRepository<ID, M>, ReadOnlyRepository<ID, M> {

    private final Map<ID, M> storage = new HashMap<>();

    @Override
    public ID save(M product) {
        storage.put(product.getId(), product);
        return product.getId();
    }

    @Override
    public void edit(M product) {
        storage.replace(product.getId(), product);
    }

    @Override
    public M find(ID id) {
        return storage.get(id);
    }

    @Override
    public void delete(ID id) {
        storage.remove(id);
    }

    @Override
    public Stream<Map.Entry<ID, M>> findAll() {
        return storage.entrySet().stream();
    }
}
