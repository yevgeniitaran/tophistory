package com.yeta.tophistory.web.rest;

import com.yeta.tophistory.domain.HistoryRecord;
import com.yeta.tophistory.repository.ReactiveHistoryRecordRepository;
import com.yeta.tophistory.scheduled.ParsingTask;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class HistoryRecordController {

    private ReactiveHistoryRecordRepository reactiveHistoryRecordRepository;
    private ParsingTask parsingTask;

    public HistoryRecordController(ReactiveHistoryRecordRepository reactiveHistoryRecordRepository, ParsingTask parsingTask) {
        this.reactiveHistoryRecordRepository = reactiveHistoryRecordRepository;
        this.parsingTask = parsingTask;
    }

    @GetMapping("/history-records")
    public Flux<HistoryRecord> findAll() {
        return reactiveHistoryRecordRepository.findAll();
    }

    @PostMapping("/history-record")
    public Mono<HistoryRecord> createHistoryRecord(@RequestBody HistoryRecord historyRecord) {
        return reactiveHistoryRecordRepository.save(historyRecord);
    }

    //TODO: Remove
    @GetMapping("/run-history-parser")
    public void runHistoryParser() {
        parsingTask.parse();
    }
}
