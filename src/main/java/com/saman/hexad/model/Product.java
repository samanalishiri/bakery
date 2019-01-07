package com.saman.hexad.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.saman.hexad.model.Sequence.PRODUCT_ID_GENERATOR;

/**
 * Product model store products, e.g., Croissant.
 * Product model is immutable.
 *
 * @author Saman Alishiri, samanalishiri@gmail.com
 * @since 2019-01-05
 */
public final class Product extends AbstractModel<Integer> {

    private final String name;

    private final String code;

    private final BigDecimal price;

    private final List<ProductPack> productPacks;

    private Product(ProductBuilder builder) {
        super(builder);
        if (Objects.isNull(builder.id)) {
            this.id = PRODUCT_ID_GENERATOR.getAndIncrement();
        }
        this.name = builder.name;
        this.code = builder.code;
        this.price = builder.price;
        this.productPacks = builder.productPacks;
    }

    public static ProductBuilder newBuilder() {
        return new ProductBuilder();
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }


    /**
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * @return
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @return
     */
    public List<ProductPack> getProductPacks() {
        return productPacks;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(String.format("%1$s ", getName()))
                .append(String.format("%1$s ", getCode()))
                .append(Arrays.toString(getProductPacks().toArray()))
                .toString();
    }

    public static final class ProductBuilder extends Builder<Integer, ProductBuilder> {

        private String name;
        private String code;
        private BigDecimal price;
        private List<ProductPack> productPacks = new ArrayList<>();

        public ProductBuilder() {
            super();
        }

        /**
         * @param val
         * @return
         */
        public ProductBuilder name(String val) {
            name = val;
            return this;
        }

        /**
         * @param val
         * @return
         */
        public ProductBuilder code(String val) {
            code = val;
            return this;
        }

        /**
         * @param val
         * @return
         */
        public ProductBuilder price(BigDecimal val) {
            price = val;
            return this;
        }

        /**
         * @param val
         * @return
         */
        public ProductBuilder productPacks(List<ProductPack> val) {
            productPacks = val;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
