package com.record.springboot.domain.record;

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
  private String iconColor;
  // enum으로 빼면 4가지 색깔만 선택할수 있을듯

  @Builder
  public Record(String title, String content, String iconColor, Long user){
    this.title = title;
    this.content = content;
    this.iconColor = iconColor;
    this.user = user;
  }
}
