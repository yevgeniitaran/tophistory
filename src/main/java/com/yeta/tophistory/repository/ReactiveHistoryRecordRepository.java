package com.yeta.tophistory.repository;

import com.yeta.tophistory.domain.HistoryRecord;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ReactiveHistoryRecordRepository extends ReactiveCrudRepository<HistoryRecord, String> {
}
