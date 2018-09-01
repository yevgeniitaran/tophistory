import {Component, Input, OnInit} from '@angular/core';
import {HistoryRecord} from '../../history-record.model';

@Component({
  selector: 'app-history-record',
  templateUrl: './history-record.component.html',
  styleUrls: ['./history-record.component.css']
})
export class HistoryRecordComponent implements OnInit {
  @Input() historyRecord: HistoryRecord;

  constructor() { }

  ngOnInit() {

  }

}
