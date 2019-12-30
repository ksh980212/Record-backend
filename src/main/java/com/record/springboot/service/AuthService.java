package com.record.springboot.service;

import com.record.springboot.domain.auth.UserRepository;
import com.record.springboot.web.dto.AuthLoginRequestDto;
import com.record.springboot.web.dto.AuthSaveRequestDto;
import java.util.Optional;
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

  @Transactional
  public Optional<Long> login(AuthLoginRequestDto requestDto){
    return userRepository.login(requestDto.getEmail(), requestDto.getPassword());
  }
}
