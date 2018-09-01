import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HistoryRecord} from '../history-record.model';

@Component({
  selector: 'app-history-records-list',
  templateUrl: './history-records-list.component.html',
  styleUrls: ['./history-records-list.component.css']
})
export class HistoryRecordsListComponent implements OnInit {

  historyRecords: HistoryRecord[] = [];

  constructor(private http: HttpClient) {
  }

  ngOnInit() {
    this.http.get('http://localhost:8080/api/history-records').subscribe((data: HistoryRecord[]) => {
      this.historyRecords = data;
    });
  }

}
