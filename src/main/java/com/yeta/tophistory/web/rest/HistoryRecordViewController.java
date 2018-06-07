package com.yeta.tophistory.web.rest;

import com.yeta.tophistory.repository.ReactiveHistoryRecordRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

@Controller
public class HistoryRecordViewController {

    private ReactiveHistoryRecordRepository reactiveHistoryRecordRepository;

    public HistoryRecordViewController(ReactiveHistoryRecordRepository reactiveHistoryRecordRepository) {
        this.reactiveHistoryRecordRepository = reactiveHistoryRecordRepository;
    }

    @RequestMapping("/historyRecordsView")
    public String historyRecordsView(Model model) {
        model.addAttribute("historyRecords", new ReactiveDataDriverContextVariable(
                reactiveHistoryRecordRepository.findAll()));
        return "historyRecords";
    }
}
