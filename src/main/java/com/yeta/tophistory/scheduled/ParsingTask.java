package com.yeta.tophistory.scheduled;

import com.yeta.tophistory.parser.RottenTomatoesParser;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ParsingTask {

    @PostConstruct
    public void onStartup() {
        parse();
    }

    @Scheduled(cron="0 0 0 * * ?")
    public void scheduledParse() {
        parse();
    }

    private void parse() {
        RottenTomatoesParser parser = new RottenTomatoesParser();
        parser.execute();
    }
}
