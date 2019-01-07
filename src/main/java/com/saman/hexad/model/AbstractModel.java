package com.saman.hexad.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * all models has id should extends this abstract
 *
 * @author Saman Alishiri, samanalishiri@gmail.com
 * @since 2019-01-05
 *
 */

public abstract class AbstractModel<ID extends Serializable> implements Serializable {

    protected ID id;

    protected AbstractModel() {
    }

    /**
     * @param builder
     * @param <B>
     */
    protected <B extends Builder> AbstractModel(B builder) {
        this.id = (ID) builder.id;
    }

    /**
     * @return
     */
    public ID getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractModel<?> abstractModel = (AbstractModel<?>) o;
        return Objects.equals(id, abstractModel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * @param <ID>
     * @param <B>
     */
    protected static abstract class Builder<ID, B extends Builder> {

        protected ID id;

        protected Builder() {
        }

        /**
         * @param id
         * @return
         */
        public B id(ID id) {
            this.id = id;
            return (B) this;
        }

        /**
         * @param <M>
         * @return
         */
        public abstract <M extends AbstractModel> M build();
    }
}
