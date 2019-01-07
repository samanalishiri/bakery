package com.saman.hexad.model;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Sequence include Atomic class for generate id fields
 *
 * @author Saman Alishiri, samanalishiri@gmail.com
 * @since 2019-01-05
 *
 */
public final class Sequence {

    public static final AtomicInteger PRODUCT_ID_GENERATOR = new AtomicInteger(1);

    public static final AtomicInteger PACK_ID_GENERATOR = new AtomicInteger(1);

    public static final AtomicInteger PRODUCT_PACK_ID_GENERATOR = new AtomicInteger(1);

    public static final AtomicInteger ORDER_ID_GENERATOR = new AtomicInteger(1);

    public static final AtomicInteger ORDER_ITEM_ID_GENERATOR = new AtomicInteger(1);

}
