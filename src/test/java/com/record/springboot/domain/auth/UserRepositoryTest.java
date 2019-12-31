package com.record.springboot.domain.auth;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

  @Autowired
  private UserRepository userRepository;

  @Test
  public void 회원가입이_정상작동한다(){
    //given
    String email = "test@test.com";
    String password = "password";
    String role = "guest";

    userRepository.save(User.builder()
        .email(email)
        .password(password)
        .role(role)
        .build()
    );

    //when
    List<User> userList = userRepository.findAll();
    User user = userList.get(0);

    //then
    assertThat(user.getEmail()).isEqualTo(email);
    assertThat(user.getPassword()).isEqualTo(password);

  }

  @Test
  public void 이메일_정규식이_정삭작동한다(){
    //given
    String email="admin@admin";

    // when & then
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      userRepository.save(User.builder()
          .email(email)
          .password("adaf1232131d")
          .role("guest")
          .build()
      );
    });

  }

  @Test
  public void 비밀번호_정규식이_정상작동한다(){
    //given
    String password = "111111";

    // when & then
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      userRepository.save(User.builder()
          .email("admin@admin.com")
          .password(password)
          .role("guest")
          .build()
      );
    });
  }
}
