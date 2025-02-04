package kirimaru.biz.mapper.helper;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import kirimaru.biz.domain.constant.CodeConstant;
import kirimaru.biz.domain.book.Book;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@MybatisTest
public class CommonSetup {
  @Autowired
  JdbcTemplate jdbcTemplate;

  @Autowired
  DataSource dataSource;

  SimpleJdbcInsert simpleJdbcInsert;

  public static LocalDateTime now = LocalDateTime.of(2021, 10, 1, 2, 3);


  protected void insertBooks(Book... records) {
    this.simpleJdbcInsert =
        new SimpleJdbcInsert(dataSource)
            .withTableName(CodeConstant.DbTable.BOOK.getTable())
    ;
    for (var record : records) {
      this.simpleJdbcInsert.execute(toMap(record));
    }

  }

  public Map<String, Object> toMap(Serializable entity) {
    HashMap<String, Object> rtn = new HashMap<>();
    var source = new CustomBeanPropertySqlParameterSource(entity);

    for (String readablePropertyName : source.getReadablePropertyNames()) {
      // クラス名は不要
      if (List.of("class", "blank", "bytes", "empty").contains(readablePropertyName)) {
        continue;
      }

      var snakeName = new PropertyNamingStrategy.SnakeCaseStrategy().translate(readablePropertyName);
      Object object = source.getValue(readablePropertyName);

      if (object instanceof Serializable) {
        var primaryKeyMap = toMap((Serializable) object);
        rtn.putAll(primaryKeyMap);
      }

      rtn.put(snakeName, object);
    }

    return rtn;
  }

}
