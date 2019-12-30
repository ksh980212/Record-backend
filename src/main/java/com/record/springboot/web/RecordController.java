package com.record.springboot.web;

import com.record.springboot.domain.record.Record;
import com.record.springboot.service.RecordService;
import com.record.springboot.web.dto.RecordLoadResponseDto;
import com.record.springboot.web.dto.RecordSaveRequestDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RecordController {

  private final RecordService recordService;

  @PostMapping("/api/v1/record")
  public Long save(@RequestBody RecordSaveRequestDto requestDto){
    return recordService.save(requestDto);
  }

  @GetMapping("/api/v1/record")
  public List<Record> findAll(Sort sort){
    return recordService.findAll(sort);
  }
}
