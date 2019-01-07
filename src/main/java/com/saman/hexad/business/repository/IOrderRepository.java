package com.saman.hexad.business.repository;

import com.saman.hexad.model.Order;

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 * @since 2019-01-07
 */
public interface IOrderRepository extends CrudRepository<Integer, Order>, ReadOnlyRepository<Integer, Order> {
}
