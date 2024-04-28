package com.mikofranco.JwtSpringSecurity.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpgradeAccountRequest {
    public String username;
    public String typeOfAcc;
}
