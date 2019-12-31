package com.record.springboot.domain.record;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecordRepositoryTest {

  @Autowired
  private RecordRepository recordRepository;

  @After
  public void cleanup(){
    recordRepository.deleteAll();
  }

  @Test
  public void 레코드가_저장된다(){
    // given
    String title = "title";
    String content = "content";
    String iconColor = "primary";
    long user = 1L;

    recordRepository.save(Record.builder()
        .title(title)
        .content(content)
        .iconColor(iconColor)
        .user(user)
        .build()
    );
    List<Record> recordList = recordRepository.findAll();

    // when
    Record record = recordList.get(0);

    // then
    assertThat(record.getTitle()).isEqualTo(title);
    assertThat(record.getContent()).isEqualTo(content);
    assertThat(record.getIconColor()).isEqualTo(IconColor.PRIMARY);
    assertThat(record.getUser()).isEqualTo(user);
  }

  @Test
  public void 항목에_없는_아이콘색상이오면_PRIMARY로_대체한다() {
    //given
    String iconColor = "anything";

    recordRepository.save(Record.builder()
        .title("title")
        .content("content")
        .iconColor(iconColor)
        .user(1L)
        .build()
    );
    List<Record> recordList = recordRepository.findAll();

    //when
    Record record = recordList.get(0);

    //then
    assertThat(record.getIconColor()).isEqualTo(IconColor.PRIMARY);
  }
}
