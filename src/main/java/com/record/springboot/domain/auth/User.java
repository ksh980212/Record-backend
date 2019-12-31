package com.record.springboot.domain.auth;

import com.record.springboot.domain.BaseTimeEntity;
import java.util.regex.Pattern;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 50, nullable = false, unique = true)
  private String email;

  @Column(length= 100, nullable = false)
  private String password;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Role role;

  @Builder
  public User(String email, String password, String role){
    validateUserInput(email, password);
    //이메일 & 비밀번호 정규식으로 확인

    this.email = email;
    this.password = password;
    this.role = Role.of(role);
  }

  private void validateUserInput(String email, String password){
    validateIsEmailPattern(email);
    validateIsPasswordPattern(password);
  }

  private void validateIsEmailPattern(String email){
    String regExp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

    if(! email.matches(regExp)){
      throw new IllegalArgumentException("Email Pattern Error");
    }
  }

  private void validateIsPasswordPattern(String password){
    String pwPattern = "^[A-Za-z[0-9]]{8,}$";

    if(! password.matches(pwPattern)){
      throw new IllegalArgumentException("Password Pattern Error");
    }
  }
}
