package kirimaru.biz.mapper;

import kirimaru.biz.mapper.dto.BookDto;
import kirimaru.biz.mapper.helper.CommonSetup;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BookMapperTests extends CommonSetup {
  @Autowired
  BookMapper mapper;

  @Test
  void test_01() {

    BookDto book1 = BookDto.builder()
        .isbn("9784798126708")
        .money(1000)
        .author("kirimaru")
        .generateDate(now)
        .generateUser("kirimaru")
        .updateDate(now)
        .updateUser("kirimaru")
        .build();
//    insertBooks(book1);
    mapper.insert(book1);


    List<BookDto> actual = mapper.findAll();
    assertThat(actual).isEqualTo(List.of(book1));
  }

}
