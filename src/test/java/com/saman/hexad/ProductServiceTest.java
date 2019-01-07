package com.saman.hexad;

import com.saman.hexad.business.service.IProductService;
import com.saman.hexad.business.service.impl.ProductService;
import com.saman.hexad.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Unit test for Models.
 *
 * @author Saman Alishiri, samanalishiri@gmail.com
 * @since 2019-01-07
 */
@RunWith(JUnit4.class)
public class ProductServiceTest extends AbstractTest {

    IProductService productService = ProductService.INSTANCE;

    @Before
    public void setUp() {
        Assert.assertNotNull(productService);
    }

    @Test
    public void crudProduct() {
        Integer productId = productService.save(vegemiteScroll);
        Assert.assertNotNull(productId);

        Product product;

        product = productService.find(productId);
        Assert.assertNotNull(product);
        Assert.assertEquals(product.getId(), productId);

        Product productUpdated = Product.newBuilder()
                .id(product.getId())
                .productPacks(product.getProductPacks())
                .name(product.getName())
                .price(product.getPrice())
                .code("VS5_UPDATED")
                .build();
        productService.edit(productUpdated);

        product = productService.find(productId);
        Assert.assertNotNull(product);
        Assert.assertEquals(productId, product.getId());
        Assert.assertEquals("VS5_UPDATED", product.getCode());

        productService.delete(productId);

        Product productDeleted = productService.find(productId);
        Assert.assertNull(productDeleted);
    }
}
