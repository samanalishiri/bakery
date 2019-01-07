package com.saman.hexad.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static com.saman.hexad.model.Sequence.ORDER_ID_GENERATOR;

/**
 * Order store customer order.
 * Order is immutable.
 *
 * @author Saman Alishiri, samanalishiri@gmail.com
 * @since 2019-01-05
 */

public final class Order extends AbstractModel<Integer> {

    private final Set<OrderItem> items;

    public Order(OrderBuilder builder) {
        super();
        if (Objects.isNull(builder.id)) {
            this.id = ORDER_ID_GENERATOR.getAndIncrement();
        }
        this.items = builder.items;
    }

    /**
     * @return
     */
    public static OrderBuilder newBuilder() {
        return new OrderBuilder();
    }

    /**
     * @return
     */
    public Set<OrderItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return String.join("\n", items.stream().map(OrderItem::toString).collect(Collectors.toList()));
    }

    public static final class OrderBuilder extends Builder<Integer, OrderBuilder> {

        private Set<OrderItem> items = new HashSet<>();

        public OrderBuilder() {
        }

        /**
         * @param val
         * @return
         */
        public OrderBuilder items(Set<OrderItem> val) {
            items = val;
            return this;
        }

        /**
         * @param val
         * @return
         */
        public OrderBuilder item(OrderItem val) {
            items.add(val);
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
