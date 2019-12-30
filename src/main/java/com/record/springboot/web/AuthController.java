package com.record.springboot.web;

import com.record.springboot.service.AuthService;
import com.record.springboot.web.dto.AuthLoginRequestDto;
import com.record.springboot.web.dto.AuthSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthController {

  private final AuthService authService;

  @PostMapping("/auth/v1/signUp")
  public Long signUp(@RequestBody AuthSaveRequestDto requestDto){
    return authService.signUp(requestDto);
  }

  @PostMapping("/auth/v1/login")
  public Long login(@RequestBody AuthLoginRequestDto requestDto)  {
    return authService.login(requestDto).get();
  }
}
