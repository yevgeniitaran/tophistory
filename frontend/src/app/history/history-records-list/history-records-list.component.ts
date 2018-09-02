import {Component, OnInit} from '@angular/core';
import {HistoryRecord} from '../history-record.model';
import {HistoryRecordService} from '../history-record.service';

@Component({
  selector: 'app-history-records-list',
  templateUrl: './history-records-list.component.html',
  styleUrls: ['./history-records-list.component.css']
})
export class HistoryRecordsListComponent implements OnInit {

  historyRecords: HistoryRecord[] = [];

  constructor(private historyRecordService: HistoryRecordService) {
  }

  ngOnInit() {
    this.historyRecordService.getHistoryRecordsObservable().subscribe((data: HistoryRecord[]) => {
      this.historyRecords = data;
    });
  }
}


