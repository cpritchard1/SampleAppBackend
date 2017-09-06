package com.myapp.MyAppBackend.Product;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by cpritcha on 6/2/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(
        controllers = ProductController.class
)

@AutoConfigureMockMvc(secure = false)
public class ProductControllerTest {

//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private ProductService productService;
//
//    @Before
//    public void setUp() {
//        PProduct mockProduct1 = new PProduct("P001", "Product 1", 2.99);
//        PProduct mockProduct2 = new PProduct("P002", "Product 2", 3.99);
//        PProduct mockProduct3 = new PProduct("P003", "Product 3", 4.99);
//
//        given(productService.performProductLookup(null, null, null))
//                .willReturn(Arrays.asList(mockProduct1, mockProduct2, mockProduct3));
//
//        given(productService.performProductLookup("P001", null, null))
//                .willReturn(Arrays.asList(mockProduct1));
//
//        given(productService.performCreateProduct(Mockito.anyString(), Mockito.anyString(), Mockito.anyDouble()))
//                .willReturn(mockProduct1);
//
//        given(productService.performUpdateProduct(Mockito.anyInt(), Mockito.anyString(), Mockito.anyString(), Mockito.anyDouble()))
//                .willReturn(mockProduct1);
//
//        given(productService.performDeleteProduct(Mockito.anyInt()))
//                .willReturn(new String("Product Successfully Deleted"));
//    }
//
//    @Test
//    public void getAllProducts_ShouldReturnProductList() throws Exception {
//        mvc.perform(get("/product/findProducts"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.success", is(true)))
//                .andExpect(jsonPath("$.msg", hasSize(0)))
//                .andExpect(jsonPath("$.data", hasSize(3)))
//                .andExpect(jsonPath("$.data[0].productCode", is("P001")))
//                .andExpect(jsonPath("$.data[1].productCode", is("P002")))
//                .andExpect(jsonPath("$.data[2].productCode", is("P003")));
//    }
//
//    @Test
//    public void getOneProduct_ShouldReturnOneProduct() throws Exception {
//        mvc.perform(get("/product/findProducts?code=P001"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.success", is(true)))
//                .andExpect(jsonPath("$.msg", hasSize(0)))
//                .andExpect(jsonPath("$.data", hasSize(1)))
//                .andExpect(jsonPath("$.data[0].productCode", is("P001")));
//    }
//
//    @Test
//    public void createProduct_ShouldReturnProduct() throws Exception {
//        mvc.perform(post("/product/createProduct?code=P001&name=Product 1&price=2.99"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.success", is(true)))
//                .andExpect(jsonPath("$.msg", hasSize(1)))
//                .andExpect(jsonPath("$.msg[0].message", is("Product Successfully Created")))
//                .andExpect(jsonPath("$.data.productCode", is("P001")));
//    }
//
//    @Test
//    public void updateProduct_ShouldReturnProduct() throws Exception{
//
//    }

}

