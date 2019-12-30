package com.record.springboot.web.dto;

import com.record.springboot.domain.record.Record;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RecordSaveRequestDto {

  private String title;
  private String content;
  private String iconColor;
  private Long user;

  @Builder
  public RecordSaveRequestDto(String title, String content, String iconColor, Long user){
    this.title = title;
    this.content = content;
    this.iconColor = iconColor;
    this.user = user;
  }

  public Record toEntity(){
    return Record.builder()
        .title(title)
        .content(content)
        .iconColor(iconColor)
        .user(user)
        .build();
  }
}
