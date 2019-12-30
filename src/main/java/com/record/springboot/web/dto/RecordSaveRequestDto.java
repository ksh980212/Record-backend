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

  @Builder
  public RecordSaveRequestDto(String title, String content){
    this.title = title;
    this.content = content;
  }

  public Record toEntity(){
    return Record.builder()
        .title(title)
        .content(content)
        .build();
  }
}
