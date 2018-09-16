angular.module("tophistoryApp")
    .component("historyRecord", {
        templateUrl: '/components/history-records-list/history-record/history-record.html',
        bindings: {
            historyRecord: "="
        }
    });