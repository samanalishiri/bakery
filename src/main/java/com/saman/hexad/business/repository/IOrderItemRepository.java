package com.saman.hexad.business.repository;

import com.saman.hexad.model.OrderItem;

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 * @since 2019-01-07
 */
public interface IOrderItemRepository extends CrudRepository<Integer, OrderItem>, ReadOnlyRepository<Integer, OrderItem> {
}
