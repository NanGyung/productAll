package com.kh.product.svc;

import com.kh.product.dao.Product;

import java.util.List;
import java.util.Optional;

public interface ProductSVC {
  /**
   * 등록
   * @param product 상품(상품아이디, 상품명, 수량, 가격)
   * @return 상품아이디
   */
  Long save(Product product);


  /**
   * 조회
   * @param pid 상품아이디
   * @return 상품
   */
  Optional<Product> findById(Long pid);


  /**
   * 수정
   * @param pid 상품아이디
   * @param product 상품
   * @return 수정된 레코드 수
   */
  int update(Long pid, Product product);


  /**
   * 삭제
   * @param pid 상품아이디
   * @return 삭제된 레코드 수
   */
  int delete(Long pid);

  /**
   * 부분삭제
   * @param pids
   * @return
   */
  int deleteParts(List<Long> pids);

  /**
   * 목록
   * @return 상품목록
   */
  List<Product> findAll();

  /**
   * 상품존재유무
   * @param pid 상품아이디
   * @return
   */
  boolean isExist(Long pid);

}
