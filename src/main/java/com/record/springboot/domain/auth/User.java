package com.record.springboot.domain.auth;

import com.record.springboot.domain.BaseTimeEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
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

  @Builder
  public User(String email, String password){
    validateUserInput(email, password);
    this.email = email;
    this.password = password;
  }

  private void validateUserInput(String email, String password){
    if(email.trim() == "" || email == "undefined"){
      throw new IllegalArgumentException("Email Input Error");
    }

    if(password.trim() == "" || password == "undefined"){
      throw new IllegalArgumentException("Password Input Error");
    }
  }
}
