package com.saman.hexad.business.dto;


import com.saman.hexad.model.ProductPack;

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 * @since 2019-01-06
 */

public final class PackDto {

    private final int count;
    private final ProductPack pack;

    private PackDto(int count, ProductPack pack) {
        this.count = count;
        this.pack = pack;
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
    public ProductPack getPack() {
        return pack;
    }

    @Override
    public String toString() {
        return count + " * " + pack.toString();
    }
}
