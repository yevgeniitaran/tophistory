import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HistoryRecordService {

  constructor(private http: HttpClient) {
  }

  getHistoryRecordsObservable(): Observable<any> {
    const apiUrl = environment.apiUrl;
    return this.http.get(apiUrl + '/api/history-records');
  }
}
