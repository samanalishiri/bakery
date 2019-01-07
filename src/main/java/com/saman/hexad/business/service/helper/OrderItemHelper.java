package com.saman.hexad.business.service.helper;

import com.saman.hexad.business.dto.PackDto;
import com.saman.hexad.model.OrderItem;
import com.saman.hexad.model.Pack;
import com.saman.hexad.model.ProductPack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.saman.hexad.business.dto.PackDto.create;
import static com.saman.hexad.business.service.helper.PackHelper.calculateTotalPrice;
import static com.saman.hexad.business.service.helper.PackHelper.totalCount;

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 * @since 2019-01-07
 */

public class OrderItemHelper {

    /**
     * @param item
     * @return
     */
    public List<PackDto> findMinimalNumberOfPacks(OrderItem item) {

        List<List<PackDto>> answers = findAllAnswers(item);

        if (answers.isEmpty()) {
            return createDefaultAnswer(item);
        }

        return findBestAnswer(answers);
    }


    /**
     * @param item
     * @return
     */
    private List<List<PackDto>> findAllAnswers(OrderItem item) {

        List<ProductPack> packs = item.getProduct().getProductPacks();
        packs.sort(ProductPack::compareTo);

        List<List<PackDto>> answers = new ArrayList<>();

        for (int i = 1; i < (1 << packs.size()); i++) {
            int quantity = item.getQuantity();
            List<PackDto> answer = new ArrayList<>();
            for (int j = 0; j < packs.size(); j++) {
                if ((i & (1 << j)) > 0) {

                    int weight = packs.get(j).getWeight();
                    int count = quantity >= weight ? quantity / weight : 0;
                    answer.add(create(count, packs.get(j)));

                    if (quantity % weight == 0) {
                        answers.add(answer);
                    }
                    quantity = quantity % weight;
                }
            }
        }

        return answers;
    }

    /**
     * @param answers
     * @return
     */
    private List<PackDto> findBestAnswer(List<List<PackDto>> answers) {
        List<PackDto> result = answers.get(0);

        for (List<PackDto> answer : answers) {
            if (totalCount(answer) < totalCount(result)
                    && BigDecimalHelper.of(calculateTotalPrice(answer)).isLessThanOrEquals(calculateTotalPrice(result))) {
                result = answer;
            }
        }
        return result;
    }

    /**
     * @param item
     * @return
     */
    private List<PackDto> createDefaultAnswer(OrderItem item) {
        return Arrays.asList(create(item.getQuantity(), ProductPack.newBuilder()
                .pack(Pack.newBuilder().quantity(1).build())
                .price(item.getProduct().getPrice())
                .build()));
    }
}
