package com.yeta.tophistory.web.rest;

import com.yeta.tophistory.domain.HistoryRecord;
import com.yeta.tophistory.repository.ReactiveHistoryRecordRepository;
import com.yeta.tophistory.scheduled.ParsingTask;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;

@RestController
@CrossOrigin(origins = "http://localhost:8000")
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
        return reactiveHistoryRecordRepository.findAll()
                .sort(Comparator.comparing(HistoryRecord::getDate).reversed());
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
