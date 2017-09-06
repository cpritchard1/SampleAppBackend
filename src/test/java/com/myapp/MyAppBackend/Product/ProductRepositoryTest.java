package com.myapp.MyAppBackend.Product;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by cpritcha on 8/12/17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"spring.jpa.hibernate.ddl-auto="})
@DataJpaTest
@Sql({"/db/all-schema.sql", "/db/all-data.sql"})
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepo productRepo;

    @Test
    public void getUserById_ShouldReturnUserObject() {
        PProduct actualProduct = productRepo.findProductById(1);
        PProduct expectedProduct = new PProduct("P001", "Product 1", 1.99);
        expectedProduct.setProductId(1);

        assertThat(actualProduct, is(equalTo(expectedProduct)));
    }

    @Test
    public void getUserByName_ShouldReturnUserObject() {
        PProduct actualProduct = productRepo.findProductByCode("P005");
        PProduct expectedProduct = new PProduct("P005", "Product 5", 5.99);
        expectedProduct.setProductId(5);

        assertThat(actualProduct, is(equalTo(expectedProduct)));
    }

}

