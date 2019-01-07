package com.saman.hexad;

import com.saman.hexad.business.dto.OrderDto;
import com.saman.hexad.business.dto.PackDto;
import com.saman.hexad.business.service.impl.OrderItemService;
import com.saman.hexad.business.service.impl.OrderService;
import com.saman.hexad.model.Order;
import com.saman.hexad.model.OrderItem;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

/**
 * Unit test for Models.
 *
 * @author Saman Alishiri, samanalishiri@gmail.com
 * @since 2019-01-05
 *
 */
@RunWith(JUnit4.class)
public class OrderTest extends AbstractTest {

    @Test
    public void minimalNumberOfPacksTest() {
        Order order = Order.newBuilder()
                .item(OrderItem.newBuilder()
                        .product(vegemiteScroll)
                        .quantity(10)
                        .build())
                .item(OrderItem.newBuilder()
                        .product(blueberryMuffin)
                        .quantity(14)
                        .build())
                .item(OrderItem.newBuilder()
                        .product(croissant)
                        .quantity(13)
                        .build())
                .build();

        OrderDto dto = OrderService.INSTANCE.calculate(order);
        Assert.assertNotNull(dto);

        LOGGER.info("\ninput:\n" + order + "\n" + "output:\n" + dto);
    }

    @Test
    public void doNotSupportPrePackTest() {
        Order order = Order.newBuilder()
                .item(OrderItem.newBuilder()
                        .product(vegemiteScroll)
                        .quantity(7)
                        .build())
                .build();

        OrderDto dto = OrderService.INSTANCE.calculate(order);
        Assert.assertNotNull(dto);
    }

    @Test
    public void createCroissantItemOrderItemTest() {
        OrderItem croissantItem = OrderItem.newBuilder()
                .product(croissant)
                .quantity(13)
                .build();

        List<PackDto> packs = OrderItemService.INSTANCE.findMinimalNumberOfPacks(croissantItem);
        Assert.assertNotNull(packs);
    }

    @Test
    public void createBlueberryMuffinItemOrderItemTest() {
        OrderItem blueberryMuffinItem = OrderItem.newBuilder()
                .product(blueberryMuffin)
                .quantity(14)
                .build();

        List<PackDto> packs = OrderItemService.INSTANCE.findMinimalNumberOfPacks(blueberryMuffinItem);
        Assert.assertNotNull(packs);
    }

    @Test
    public void createVegemiteScrollItemItemOrderItemTest() {
        OrderItem vegemiteScrollItem = OrderItem.newBuilder()
                .product(vegemiteScroll)
                .quantity(10)
                .build();

        List<PackDto> packs = OrderItemService.INSTANCE.findMinimalNumberOfPacks(vegemiteScrollItem);
        Assert.assertNotNull(packs);
    }


}
