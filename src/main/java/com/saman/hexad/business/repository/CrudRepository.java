package com.saman.hexad.business.repository;

import com.saman.hexad.model.AbstractModel;

import java.io.Serializable;

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 * @since 2019-01-05
 */

public interface CrudRepository<ID extends Serializable, M extends AbstractModel<ID>> {

    /**
     * @param m
     * @return
     */
    ID save(M m);

    /**
     * @param m
     */
    void edit(M m);

    /**
     * @param id
     * @return
     */
    M find(ID id);

    /**
     * @param id
     */
    void delete(ID id);
}
