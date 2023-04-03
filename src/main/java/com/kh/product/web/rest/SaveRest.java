package com.kh.product.web.rest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SaveRest {
  @NotBlank
  private String pname;
  @NotNull
  private Long quantity;
  @NotNull
  private Long price;
}