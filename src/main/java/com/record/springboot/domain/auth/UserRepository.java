package com.record.springboot.domain.auth;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository  extends JpaRepository<User, Long> {

  @Query("select u.id from User u  where u.email = :email AND u.password = :password")
  Optional<Long> login(@Param("email")String email, @Param("password") String password);
}
