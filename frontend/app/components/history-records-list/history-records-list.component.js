angular.module("healthyGulpAngularApp")
.component("historyRecordsList", {
    templateUrl: '/components/history-records-list/history-records-list.html',
    bindings: {
        records: "="
    }
});