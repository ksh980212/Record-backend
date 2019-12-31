package com.record.springboot.domain.record;

import com.record.springboot.domain.BaseTimeEntity;
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
public class Record extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  //fk 설정 해야댐
  private Long user;

  @Column(length = 50, nullable = false)
  private String title;

  @Column(length = 200, nullable = false)
  private String content;

  @Column(length= 20, nullable = false)
  @Enumerated(EnumType.STRING)
  private IconColor iconColor;

  @Builder
  public Record(String title, String content, String iconColor, Long user){
    this.title = title;
    this.content = content;
    this.iconColor = IconColor.of(iconColor);
    this.user = user;
  }
}
