package com.record.springboot.web.dto;

import com.record.springboot.domain.auth.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuthSaveRequestDto {

  private String email;
  private String password;
  private String role;

  @Builder
  public AuthSaveRequestDto(String email, String password, String role){
    this.email = email;
    this.password = password;
    this.role = role;
  }

  public User toEntity(){
    return User.builder()
        .email(email)
        .password(password)
        .role(role)
        .build();
  }
}
