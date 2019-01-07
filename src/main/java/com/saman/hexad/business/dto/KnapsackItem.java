package com.saman.hexad.business.dto;

import java.math.BigDecimal;

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 * @since 2019-01-05
 */

public interface KnapsackItem {

    /**
     * @return
     */
    int getWeight();

    /**
     * @return
     */
    BigDecimal getValue();
}
