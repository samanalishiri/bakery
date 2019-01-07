package com.saman.hexad.business.service.impl;

import com.saman.hexad.business.repository.impl.InMemoryProductRepository;
import com.saman.hexad.business.service.AbstractService;
import com.saman.hexad.business.service.IProductService;
import com.saman.hexad.model.Product;

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 * @since 2019-01-06
 */
public class ProductService extends AbstractService<Integer, Product, InMemoryProductRepository> implements IProductService {

    public static final ProductService INSTANCE = new ProductService();

    protected ProductService() {
        super(InMemoryProductRepository.INSTANCE);
    }

}
