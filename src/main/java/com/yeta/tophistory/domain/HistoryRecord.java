package com.yeta.tophistory.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Document
@Getter @Setter
@ToString
public class HistoryRecord {

    @Id
    private String id;
    private String topName;
    private LocalDate date;
    private List<HistoryPosition> historyPositions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HistoryRecord)) return false;
        HistoryRecord that = (HistoryRecord) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
