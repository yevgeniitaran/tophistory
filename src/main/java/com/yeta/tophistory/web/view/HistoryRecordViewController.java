package com.yeta.tophistory.web.view;

import com.yeta.tophistory.repository.ReactiveHistoryRecordRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Mono;

@Controller
public class HistoryRecordViewController {

    private ReactiveHistoryRecordRepository reactiveHistoryRecordRepository;

    public HistoryRecordViewController(ReactiveHistoryRecordRepository reactiveHistoryRecordRepository) {
        this.reactiveHistoryRecordRepository = reactiveHistoryRecordRepository;
    }

    @GetMapping("/history-records")
    public void historyRecordsView(Model model) {
        model.addAttribute("historyRecords", new ReactiveDataDriverContextVariable(
                reactiveHistoryRecordRepository.findAll()));
    }

    @GetMapping("/")
    public Mono<String> redirectWithUsingRedirectPrefix() {
        return Mono.just("redirect:/history-records");
    }
}
