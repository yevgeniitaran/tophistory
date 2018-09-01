import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {HttpClientModule} from '@angular/common/http';
import {HistoryRecordsListComponent} from './history/history-records-list/history-records-list.component';
import {HistoryRecordComponent} from './history/history-records-list/history-record/history-record.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HistoryRecordsListComponent,
    HistoryRecordComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
