package com.saman.hexad;

import com.saman.hexad.model.Pack;
import com.saman.hexad.model.Product;
import com.saman.hexad.model.ProductPack;

import java.math.BigDecimal;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.saman.hexad.model.Sequence.PRODUCT_ID_GENERATOR;

public class AbstractTest {

    public static final Logger LOGGER = Logger.getLogger("LOGGER");

    public static final Product vegemiteScroll = Product.newBuilder()
            .id(PRODUCT_ID_GENERATOR.getAndIncrement())
            .name("Vegemite Scroll")
            .code("VS5")
            .price(BigDecimal.valueOf(2.33))
            .productPacks(Stream.of(
                    ProductPack.newBuilder()
                            .pack(Pack.newBuilder().quantity(3).build())
                            .price(BigDecimal.valueOf(6.99))
                            .build(),
                    ProductPack.newBuilder()
                            .pack(Pack.newBuilder().quantity(5).build())
                            .price(BigDecimal.valueOf(8.99))
                            .build()
            ).collect(Collectors.toList()))
            .build();

    public static final Product blueberryMuffin = Product.newBuilder()
            .id(PRODUCT_ID_GENERATOR.getAndIncrement())
            .name("Blueberry Muffin")
            .code("MB11")
            .price(BigDecimal.valueOf(4.50))
            .productPacks(Stream.of(
                    ProductPack.newBuilder()
                            .pack(Pack.newBuilder().quantity(2).build())
                            .price(BigDecimal.valueOf(9.95))
                            .build(),
                    ProductPack.newBuilder()
                            .pack(Pack.newBuilder().quantity(5).build())
                            .price(BigDecimal.valueOf(16.95))
                            .build(),
                    ProductPack.newBuilder()
                            .pack(Pack.newBuilder().quantity(8).build())
                            .price(BigDecimal.valueOf(24.95))
                            .build()
            ).collect(Collectors.toList()))
            .build();

    public static final Product croissant = Product.newBuilder()
            .id(PRODUCT_ID_GENERATOR.getAndIncrement())
            .name("Croissant")
            .code("CF")
            .price(BigDecimal.valueOf(2.00))
            .productPacks(Stream.of(
                    ProductPack.newBuilder()
                            .pack(Pack.newBuilder().quantity(3).build())
                            .price(BigDecimal.valueOf(5.95))
                            .build(),
                    ProductPack.newBuilder()
                            .pack(Pack.newBuilder().quantity(5).build())
                            .price(BigDecimal.valueOf(9.95))
                            .build(),
                    ProductPack.newBuilder()
                            .pack(Pack.newBuilder().quantity(9).build())
                            .price(BigDecimal.valueOf(16.99))
                            .build()
            ).collect(Collectors.toList()))
            .build();
}
