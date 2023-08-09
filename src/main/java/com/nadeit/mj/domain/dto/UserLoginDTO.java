package com.nadeit.mj.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class UserLoginDTO {
    @Schema(description = "用户名")
    @NotEmpty(message = "用户名不能为空")
    @Size(min = 2, max = 20, message = "用户名长度为2-20")
    private String username;
    @Schema(description = "密码")
    @NotEmpty(message = "密码不能为空")
    @Size(min = 6, max = 20, message = "密码长度为6-20")
    private String password;
}
