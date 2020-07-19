package jp.co.kelly.biz.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Entry {
  private List<Detail> detail;

  public List<ReturnHistory> flatHistory() {
    if (Objects.isNull(detail)){
      return List.of();
    }
    return detail.stream()
        .map(Detail::getReturnHistory)
        .filter(Objects::nonNull)
        .flatMap(Collection::stream)
        .collect(Collectors.toList());
  }
}
