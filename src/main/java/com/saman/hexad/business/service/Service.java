package com.saman.hexad.business.service;

import com.saman.hexad.model.AbstractModel;

import java.io.Serializable;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 * @since 2019-01-06
 */
public interface Service<ID extends Serializable, M extends AbstractModel<ID>> {
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

    /**
     * @return
     */
    Stream<Map.Entry<ID, M>> findAll();
}
