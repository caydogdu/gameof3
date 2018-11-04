var stompClient = null;
var gameId = null;
var gameName = null;
var playerId = null;

function setConnected(connected) {
    if (connected) {
        $("#conversation").show();
    } else {
        $("#conversation").hide();
    }
    $("#messages").html("");
}

$.getJSON("/game", function(data) {
console.log("gameId"+data.id)
    gameId = data.id;
    gameName = data.name;
});

var socket = new SockJS('/gameof3-websocket');
stompClient = Stomp.over(socket);
stompClient.connect({}, function(frame) {
    setConnected(true);
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/messages/' + gameId, function(message) {
        showMessages(JSON.parse(message.body).content);
        if (playerId == null) {
            playerId = JSON.parse(message.body).playerId;
            var playerName = JSON.parse(message.body).playerName;
            console.log('Player ' + playerId + ' is ready');
            $("#wellcomeMessage").html("Wellcome " + playerName + " to " + gameName);
        }
    });
    stompClient.send("/app/join", {}, JSON.stringify({
        'gameId' : gameId
    }));
});

function start() {
    stompClient.send("/app/start", {}, JSON.stringify({
        'gameId' : gameId,
        'playerId' : playerId
    }));
}

function play() {
    console.log('Player ' + playerId + ' has send adjustment');
    stompClient.send("/app/play", {}, JSON.stringify({
        'gameId' : gameId,
        'playerId' : playerId,
        'adjustment' : $("#adjustment").val()
    }));
}

function showMessages(message) {
    $("#messages").append("<tr><td>" + message + "</td></tr>");
}

$(function() {
    $("form").on('submit', function(e) {
        e.preventDefault();
    });
    $("#start").click(function() {
        start();
    });
    $("#play").click(function() {
        play();
    });
});
