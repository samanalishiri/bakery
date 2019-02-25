package com.saman.hexad.business.dto;


import com.saman.hexad.model.ProductPack;

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 * @since 2019-01-06
 */

public final class PackDto {

    private final int count;
    private final ProductPack productPack;

    private PackDto(int count, ProductPack productPack) {
        this.count = count;
        this.productPack = productPack;
    }

    /**
     * @param count
     * @param pack
     * @return
     */
    public static PackDto create(int count, ProductPack pack) {
        return new PackDto(count, pack);
    }

    /**
     * @return
     */
    public int getCount() {
        return count;
    }

    /**
     * @return
     */
    public ProductPack getProductPack() {
        return productPack;
    }

    @Override
    public String toString() {
        return count + " * " + productPack.toString();
    }
}
