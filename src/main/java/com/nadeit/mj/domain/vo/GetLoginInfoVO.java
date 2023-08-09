package com.nadeit.mj.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class GetLoginInfoVO {

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "角色")
    private List<String> role;
    

}
