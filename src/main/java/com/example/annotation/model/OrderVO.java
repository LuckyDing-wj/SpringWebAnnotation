package com.example.annotation.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class OrderVO {

    @NotBlank(message = "订单名称不能为空")
    private String name;

    @NotNull(message = "订单数量不能为空")
    @Range(min = 1, max = 10, message = "订单数量必须在1~10之间")
    private Integer amount;

    @NotNull(message = "用户ID不能为空")
    @Range(min = 1, message = "用户ID必须大于0")
    private Integer userId;
}
