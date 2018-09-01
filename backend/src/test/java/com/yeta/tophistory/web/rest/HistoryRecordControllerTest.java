package com.yeta.tophistory.web.rest;

import com.yeta.tophistory.domain.HistoryPosition;
import com.yeta.tophistory.domain.HistoryRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HistoryRecordControllerTest {

    private LocalDate ANY_DATE = LocalDate.now();
    private int ANY_POSITION = 1;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void createFindAll_ViaRestUsage_Complete() {
        HistoryRecord historyRecord = new HistoryRecord();
        historyRecord.setTopName("ANY_NAME");
        historyRecord.setDate(ANY_DATE);
        HistoryPosition position = new HistoryPosition();
        position.setName("ANY_POSITION_NAME");
        position.setUrl("ANY_URL");
        position.setPosition(ANY_POSITION);
        historyRecord.setHistoryPositions(Collections.singletonList(position));
        webTestClient.post().uri("/api/history-record")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(historyRecord), HistoryRecord.class)
                .exchange()
                .expectStatus().isOk()
                .expectHeader()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBody(HistoryRecord.class);
        webTestClient.get().uri("/api/history-records")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBodyList(HistoryRecord.class)
                .consumeWith(list -> {
                    assertEquals(historyRecord.getDate(), list.getResponseBody().get(0).getDate());
                    assertEquals(historyRecord.getHistoryPositions().get(0), list.getResponseBody().get(0).getHistoryPositions().get(0));
                });
    }
}