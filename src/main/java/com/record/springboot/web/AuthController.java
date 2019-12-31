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

  // 전체적으로 테스트 코드 짜야됨
  @PostMapping("/auth/v1/signUp")
  public Long signUp(@RequestBody AuthSaveRequestDto requestDto){
    validateEmailAreadyExists(requestDto);
    // 암호화 작업 요구
    return authService.signUp(requestDto);
  }

  @PostMapping("/auth/v1/login")
  public Long login(@RequestBody AuthLoginRequestDto requestDto)  {
    // 암호화 작업 요구 + JWT 토큰 이용해보기
    return authService.login(requestDto).get();
  }

  private void validateEmailAreadyExists(AuthSaveRequestDto requestDto){
    if(authService.findByEmail(requestDto).isPresent()){
      throw new IllegalArgumentException("already exists");
    }
  }
}
