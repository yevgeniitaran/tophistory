package com.yeta.tophistory.scheduled;

import com.yeta.tophistory.domain.HistoryRecord;
import com.yeta.tophistory.parser.RottenTomatoesParser;
import com.yeta.tophistory.repository.ReactiveHistoryRecordRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ParsingTask {

    private ReactiveHistoryRecordRepository reactiveHistoryRecordRepository;

    public ParsingTask(ReactiveHistoryRecordRepository reactiveHistoryRecordRepository) {
        this.reactiveHistoryRecordRepository = reactiveHistoryRecordRepository;
    }

//    @PostConstruct
//    public void onStartup() {
//        parse();
//    }

    @Scheduled(cron="0 0 0 * * ?")
    public void scheduledParse() {
        parse();
    }

    private void parse() {
        RottenTomatoesParser parser = new RottenTomatoesParser();
        HistoryRecord record = parser.execute();
        reactiveHistoryRecordRepository.save(record).subscribe();
    }
}
