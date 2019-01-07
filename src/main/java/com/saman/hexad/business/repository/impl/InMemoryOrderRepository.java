package com.saman.hexad.business.repository.impl;

import com.saman.hexad.business.repository.AbstractRepository;
import com.saman.hexad.business.repository.IOrderRepository;
import com.saman.hexad.model.Order;

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 * @since 2019-01-05
 */
public class InMemoryOrderRepository extends AbstractRepository<Integer, Order> implements IOrderRepository {
    public static final InMemoryOrderRepository INSTANCE = new InMemoryOrderRepository();
}
