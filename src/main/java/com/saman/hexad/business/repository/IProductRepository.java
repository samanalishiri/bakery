package com.saman.hexad.business.repository;

import com.saman.hexad.model.Product;

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 * @since 2019-01-07
 */
public interface IProductRepository extends CrudRepository<Integer, Product>, ReadOnlyRepository<Integer, Product> {
}
