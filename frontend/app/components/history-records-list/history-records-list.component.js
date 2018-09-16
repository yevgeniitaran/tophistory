function HistoryRecordsListController($http) {
    var ctrl = this;

    ctrl.method = 'GET';
    ctrl.url = '/api/history-records';

    $http.get(ctrl.url)
        .then(function (response) {
            ctrl.historyRecordsList = response.data;
        });
}

angular.module("tophistoryApp")
    .component("historyRecordsList", {
        templateUrl: '/components/history-records-list/history-records-list.html',
        controller: HistoryRecordsListController
    });