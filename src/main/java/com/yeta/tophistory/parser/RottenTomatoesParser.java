package com.yeta.tophistory.parser;

import com.yeta.tophistory.domain.HistoryPosition;
import com.yeta.tophistory.domain.HistoryRecord;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RottenTomatoesParser implements AbstractParser {

    public static final String ROTTEN_TOMATOES_TOP100_NAME = "rottentomatoes_top100";
    public static final String ROTTEN_TOMATOES_LINK = "https://www.rottentomatoes.com/";
    public static final String ROTTEN_TOMATOES_FIRST_TOP100_LINK = "https://www.rottentomatoes.com/top/bestofrt/";

    @Override
    public HistoryRecord execute() {
        try {
            Document rottenTomatoesTop100page = Jsoup.connect(ROTTEN_TOMATOES_FIRST_TOP100_LINK).get();
            Elements top100rows = rottenTomatoesTop100page.
                select("div.panel-body.content_body.allow-overflow>table>tbody>tr>td:not([class])>a");
            HistoryRecord historyRecord = new HistoryRecord();
            historyRecord.setTopName(ROTTEN_TOMATOES_TOP100_NAME);
            historyRecord.setDate(LocalDate.now());
            List<HistoryPosition> historyPositions = new ArrayList<>();
            for (int i = 0; i < top100rows.size(); i++) {
                HistoryPosition historyPosition = new HistoryPosition();
                Element a = top100rows.get(i);
                historyPosition.setPosition(i + 1);
                historyPosition.setName(a.text());
                historyPosition.setUrl(ROTTEN_TOMATOES_LINK + a.attr("href"));
                historyPositions.add(historyPosition);
            }
            return historyRecord;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
