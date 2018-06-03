package com.yeta.tophistory.repository;

import com.yeta.tophistory.domain.HistoryPosition;
import com.yeta.tophistory.domain.HistoryRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReactiveHistoryRecordRepositoryTest {

    @Autowired
    ReactiveHistoryRecordRepository reactiveHistoryRecordRepository;

    @Test
    public void insertAndFind_NormallyAddedRecord_Successful() {
        HistoryRecord historyRecord = new HistoryRecord();
        HistoryPosition historyPosition = new HistoryPosition();
        historyPosition.setPosition(1);
        historyPosition.setName("Test");
        historyPosition.setUrl("url");
        historyRecord.setDate(LocalDate.now());
        historyRecord.setTopName("TestTop");
        historyRecord.setHistoryPositions(Collections.singletonList(historyPosition));
        historyRecord = reactiveHistoryRecordRepository.save(historyRecord).block();
        Flux<HistoryRecord> findAllResult = reactiveHistoryRecordRepository.findAll();
        StepVerifier.create(findAllResult)
                .expectNext(historyRecord)
                .expectComplete()
                .verify();
    }
}