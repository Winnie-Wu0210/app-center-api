package com.nadeit.mj.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginVO {

    // token
    @Schema(description = "token")
    private String token;
}
