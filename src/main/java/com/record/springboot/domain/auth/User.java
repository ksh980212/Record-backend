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
    validateIsEmailPattern(email);
    validateIsPasswordPattern(password);
  }

  private void validateIsEmailPattern(String email){
    String regExp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

    if(!email.matches(regExp)){
      throw new IllegalArgumentException("Email Pattern Error");
    }
  }

  private void validateIsPasswordPattern(String password){
    String regExp= "^(?=.*[A-Za-z])(?=.*)[A-Za-z]{8,}$";

    if(!password.matches(regExp)){
      throw new IllegalArgumentException("Password Pattern Error");
    }
  }
}
