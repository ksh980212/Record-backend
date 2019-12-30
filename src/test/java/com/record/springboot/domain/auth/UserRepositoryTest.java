package com.record.springboot.domain.auth;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.Test;
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

    userRepository.save(User.builder()
        .email(email)
        .password(password)
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
  public void 잘못된_이메일_형식이_들어오면_에러발생한다(){
    //given
    String email="         ";
    String password="test";

    userRepository.save(User.builder()
        .email(email)
        .password(password)
        .build()
    );

    //when


  }
}
