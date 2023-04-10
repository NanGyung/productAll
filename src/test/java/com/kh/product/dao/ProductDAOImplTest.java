package com.kh.product.dao;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@Slf4j
@SpringBootTest
public class ProductDAOImplTest {
  @Autowired
  ProductDAO productDAO;

//  등록
  @Test
  @DisplayName("상품등록")
  void save(){
    Product product = new Product();
    product.setPname("딸기");
    product.setQuantity(10L);
    product.setPrice(30000L);
    Long pid = productDAO.save(product);
    log.info("pid={}",pid);
    Assertions.assertThat(pid).isGreaterThan(0L);
  }

//  조회
  @Test
  @DisplayName("상품조회")
  void findById(){
    Long pid = 62L;
    Optional<Product> product = productDAO.findById(pid);
    Product findedProduct = product.orElseThrow();
    log.info("product={}",product);
    Assertions.assertThat(findedProduct.getPname()).isEqualTo("딸기");
    Assertions.assertThat(findedProduct.getQuantity()).isEqualTo(10L);
    Assertions.assertThat(findedProduct.getPrice()).isEqualTo(30000L);
  }

  //수정
  @Test
  @DisplayName("상품수정")
  void update() {
    Long pid = 62L;
    Product product = new Product();

    product.setPname("딸기_수정");
    product.setQuantity(20L);
    product.setPrice(20000L);
    int updatedRowCount = productDAO.update(pid, product);
    Optional<Product> findedProduct = productDAO.findById(pid);

    log.info("product={}",product);

    Assertions.assertThat(updatedRowCount).isEqualTo(1);
    Assertions.assertThat(findedProduct.get().getPname()).isEqualTo(product.getPname());
    Assertions.assertThat(findedProduct.get().getQuantity()).isEqualTo(product.getQuantity());
    Assertions.assertThat(findedProduct.get().getPrice()).isEqualTo(product.getPrice());
  }

  // 삭제
  @Test
  @DisplayName("상품삭제")
  void delete(){
    Long pid = 45L;
    int columnOfCnt = productDAO.delete(pid);
    Assertions.assertThat(columnOfCnt).isEqualTo(1);
  }

  // 목록
  @Test
  @DisplayName("상품목록")
  void findAll(){
    List<Product> list = productDAO.findAll();
    log.info("list={}",list);
    Assertions.assertThat(list.size()).isGreaterThan(0);
  }

}
