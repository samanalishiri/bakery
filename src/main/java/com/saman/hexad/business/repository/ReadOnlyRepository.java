package com.saman.hexad.business.repository;

import com.saman.hexad.model.AbstractModel;

import java.io.Serializable;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 * @since 2019-01-05
 */
public interface ReadOnlyRepository<ID extends Serializable, M extends AbstractModel<ID>> {

    /**
     * @return
     */
    Stream<Map.Entry<ID, M>> findAll();
}
