package com.saman.hexad.business.repository.impl;

import com.saman.hexad.business.repository.AbstractRepository;
import com.saman.hexad.business.repository.IOrderItemRepository;
import com.saman.hexad.model.OrderItem;

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 * @since 2019-01-05
 */
public class InMemoryOrderItemRepository extends AbstractRepository<Integer, OrderItem> implements IOrderItemRepository {
    public static final InMemoryOrderItemRepository INSTANCE = new InMemoryOrderItemRepository();
}
