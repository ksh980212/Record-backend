package com.record.springboot.service;

import com.record.springboot.domain.auth.UserRepository;
import com.record.springboot.web.dto.AuthSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AuthService {

  private final UserRepository userRepository;

  @Transactional
  public Long signUp(AuthSaveRequestDto requestDto){
    return userRepository.save(requestDto.toEntity()).getId();
  }
}
