package com.record.springboot.web.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RecordLoadResponseDto {

  private final Long id;
  private final String title;
  private final String content;
  private final LocalDateTime modifiedDate;
}
