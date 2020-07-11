var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "800",
        "ok": "800",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "182",
        "ok": "182",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1605",
        "ok": "1605",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "988",
        "ok": "988",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "414",
        "ok": "414",
        "ko": "-"
    },
    "percentiles1": {
        "total": "1047",
        "ok": "1047",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1380",
        "ok": "1380",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1544",
        "ok": "1544",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1586",
        "ok": "1586",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 285,
    "percentage": 36
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 194,
    "percentage": 24
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 321,
    "percentage": 40
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "400",
        "ok": "400",
        "ko": "-"
    }
},
contents: {
"req_video-player-re-ce524": {
        type: "REQUEST",
        name: "video_player_request",
path: "video_player_request",
pathFormatted: "req_video-player-re-ce524",
stats: {
    "name": "video_player_request",
    "numberOfRequests": {
        "total": "800",
        "ok": "800",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "182",
        "ok": "182",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1605",
        "ok": "1605",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "988",
        "ok": "988",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "414",
        "ok": "414",
        "ko": "-"
    },
    "percentiles1": {
        "total": "1047",
        "ok": "1047",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1380",
        "ok": "1380",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1544",
        "ok": "1544",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1586",
        "ok": "1586",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 285,
    "percentage": 36
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 194,
    "percentage": 24
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 321,
    "percentage": 40
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "400",
        "ok": "400",
        "ko": "-"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
