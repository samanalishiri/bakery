package com.saman.hexad.model;


import java.util.Objects;

import static com.saman.hexad.model.Sequence.PACK_ID_GENERATOR;

/**
 * Package model store quantity of package.
 * Package model is immutable
 *
 * @author Saman Alishiri, samanalishiri@gmail.com
 * @since 2019-01-05
 *
 */
public final class Pack extends AbstractModel<Integer> {

    private final Integer quantity;

    private Pack(PackageBuilder builder) {
        super(builder);
        if (Objects.isNull(builder.id)) {
            this.id = PACK_ID_GENERATOR.getAndIncrement();
        }
        this.quantity = builder.quantity;
    }

    /**
     * @return
     */
    public static PackageBuilder newBuilder() {
        return new PackageBuilder();
    }

    /**
     * @return
     */
    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.valueOf(getQuantity());
    }

    public static final class PackageBuilder extends Builder<Integer, PackageBuilder> {

        private Integer quantity;

        public PackageBuilder() {
        }

        /**
         * @param val
         * @return
         */
        public PackageBuilder quantity(Integer val) {
            quantity = val;
            return this;
        }

        public Pack build() {
            return new Pack(this);
        }
    }
}
