package com.record.springboot.service;

import com.record.springboot.domain.record.Record;
import com.record.springboot.domain.record.RecordRepository;
import com.record.springboot.web.dto.RecordSaveRequestDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class RecordService {

  private final RecordRepository recordRepository;

  @Transactional
  public Long save(RecordSaveRequestDto requestDto){
    return recordRepository.save(requestDto.toEntity()).getId();
  }

  @Transactional
  public List<Record> findAll(Sort sort){
    return recordRepository.findAll(sort);
  }

  @Transactional
  public void deleteById(Long id){
    recordRepository.deleteById(id);
  }
}
