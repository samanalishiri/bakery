package com.saman.hexad.business.service.helper;

import com.saman.hexad.business.dto.PackDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 * @since 2019-01-06
 */

public class PackHelper {

    /**
     * @param models
     * @return
     */
    public static BigDecimal calculateTotalPrice(List<PackDto> models) {
        BigDecimal temp = BigDecimal.valueOf(0);
        List<BigDecimal> collect = models.stream()
                .map(packDto -> packDto.getPack().getPrice().multiply(BigDecimal.valueOf(packDto.getCount())))
                .collect(Collectors.toList());

        for (BigDecimal n : collect) {
            temp = temp.add(n);
        }
        return temp;
    }

    /**
     * @param models
     * @return
     */
    public static int totalCount(List<PackDto> models) {
        return models.stream().mapToInt(PackDto::getCount).sum();
    }

}
