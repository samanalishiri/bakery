package com.saman.hexad.business.service.helper;

import java.math.BigDecimal;

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 * @since 2019-01-06
 */

public final class BigDecimalHelper {

    private BigDecimal number;

    private BigDecimalHelper(BigDecimal number) {
        this.number = number;
    }

    /**
     * @param number
     * @return
     */
    public static BigDecimalHelper of(BigDecimal number){
        return new BigDecimalHelper(number);
    }

    /**
     * @param number
     * @return
     */
    public boolean isLessThanOrEquals(BigDecimal number){
        return this.number.compareTo(number) < 1;
    }
}
