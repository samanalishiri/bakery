package com.saman.hexad.model;


import java.util.Objects;

import static com.saman.hexad.model.Sequence.ORDER_ITEM_ID_GENERATOR;

/**
 * OrderItem store order item.
 * OrderItem is mutable
 *
 * @author Saman Alishiri, samanalishiri@gmail.com
 * @since 2019-01-05
 */

public final class OrderItem extends AbstractModel<Integer> {

    private final Product product;

    private int quantity = 0;

    private OrderItem(OrderItemBuilder builder) {
        super();
        if (Objects.isNull(builder.id)) {
            this.id = ORDER_ITEM_ID_GENERATOR.getAndIncrement();
        }
        this.product = builder.product;
        this.quantity = builder.quantity;
    }

    /**
     * @return
     */
    public static OrderItemBuilder newBuilder() {
        return new OrderItemBuilder();
    }

    /**
     * @return
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @param quantity
     */
    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(quantity).append(" ")
                .append(product.getCode()).append(" ")
                .toString();
    }

    public static final class OrderItemBuilder extends Builder<Integer, OrderItemBuilder> {
        private Product product;
        private Integer quantity;

        public OrderItemBuilder() {
        }

        /**
         * @param val
         * @return
         */
        public OrderItemBuilder quantity(Integer val) {
            quantity = val;
            return this;
        }

        /**
         * @param val
         * @return
         */
        public OrderItemBuilder product(Product val) {
            product = val;
            return this;
        }

        public OrderItem build() {
            return new OrderItem(this);
        }
    }
}
