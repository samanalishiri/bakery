package com.saman.hexad.business.service;

import com.saman.hexad.business.repository.CrudRepository;
import com.saman.hexad.business.repository.ReadOnlyRepository;
import com.saman.hexad.model.AbstractModel;

import java.io.Serializable;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 * @since 2019-01-06
 */
public abstract class AbstractService<ID extends Serializable, M extends AbstractModel<ID>, R extends CrudRepository<ID, M> & ReadOnlyRepository<ID, M>>
        implements Service<ID, M> {

    protected final R repository;

    protected AbstractService(R repository) {
        this.repository = repository;
    }

    @Override
    public ID save(M m) {
        return repository.save(m);
    }

    @Override
    public void edit(M m) {
        repository.edit(m);
    }

    @Override
    public M find(ID id) {
        return repository.find(id);
    }

    @Override
    public void delete(ID id) {
        repository.delete(id);
    }

    @Override
    public Stream<Map.Entry<ID, M>> findAll() {
        return repository.findAll();
    }
}
