package com.saman.hexad.model;


import com.saman.hexad.business.dto.KnapsackItem;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Objects;

import static com.saman.hexad.model.Sequence.PRODUCT_PACK_ID_GENERATOR;

/**
 * ProductPack model store price per package.
 * ProductPack model is immutable
 *
 * @author Saman Alishiri, samanalishiri@gmail.com
 * @since 2019-01-05
 */
public final class ProductPack extends AbstractModel<Integer> implements KnapsackItem, Comparable<ProductPack> {

    private final BigDecimal price;

    private final Pack pack;

    private ProductPack(PackageBuilder builder) {
        super(builder);
        if (Objects.isNull(builder.id)) {
            this.id = PRODUCT_PACK_ID_GENERATOR.getAndIncrement();
        }
        this.price = builder.price;
        this.pack = builder.pack;
    }

    public static PackageBuilder newBuilder() {
        return new PackageBuilder();
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
    public Pack getPack() {
        return pack;
    }

    @Override
    public int getWeight() {
        return getPack().getQuantity().intValue();
    }

    @Override
    public BigDecimal getValue() {
        return getPrice();
    }

    @Override
    public int compareTo(ProductPack other) {

        if (this.getWeight() > other.getWeight()) {
            return -1;

        } else if (this.getWeight() < other.getWeight()) {
            return 1;

        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return getPack() + " @ " + NumberFormat.getCurrencyInstance().format(getPrice());
    }

    public static final class PackageBuilder extends Builder<Integer, PackageBuilder> {

        private BigDecimal price;
        private Pack pack;

        public PackageBuilder() {
        }

        /**
         * @param val
         * @return
         */
        public PackageBuilder price(BigDecimal val) {
            price = val;
            return this;
        }

        /**
         * @param val
         * @return
         */
        public PackageBuilder pack(Pack val) {
            pack = val;
            return this;
        }

        public ProductPack build() {
            return new ProductPack(this);
        }
    }
}
