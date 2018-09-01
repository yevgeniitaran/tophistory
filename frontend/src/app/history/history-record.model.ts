import {HistoryPosition} from './history-position.model';

export class HistoryRecord {
  public id: string;
  public topName: string;
  public date: Date;
  public historyPositions: HistoryPosition[];

}
