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
public abstract class AbstractService<ID extends Serializable, M extends AbstractModel<ID>, S extends CrudRepository<ID, M> & ReadOnlyRepository<ID, M>>
        implements Service<ID, M> {

    protected final S service;

    protected AbstractService(S service) {
        this.service = service;
    }

    @Override
    public ID save(M m) {
        return service.save(m);
    }

    @Override
    public void edit(M m) {
        service.edit(m);
    }

    @Override
    public M find(ID id) {
        return service.find(id);
    }

    @Override
    public void delete(ID id) {
        service.delete(id);
    }

    @Override
    public Stream<Map.Entry<ID, M>> findAll() {
        return service.findAll();
    }
}
