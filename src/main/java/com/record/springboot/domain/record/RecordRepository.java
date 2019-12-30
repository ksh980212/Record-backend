package com.record.springboot.domain.record;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RecordRepository extends JpaRepository<Record, Long> {

  @Query("select r from Record r where r.user = :user")
  List<Record> findAll(Sort sort, @Param("user") Long user);
}
