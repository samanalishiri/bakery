package com.saman.hexad.business.repository.impl;

import com.saman.hexad.business.repository.AbstractRepository;
import com.saman.hexad.business.repository.IProductRepository;
import com.saman.hexad.model.Product;

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 * @since 2019-01-05
 */
public class InMemoryProductRepository extends AbstractRepository<Integer, Product> implements IProductRepository {
    public static final InMemoryProductRepository INSTANCE = new InMemoryProductRepository();
}
