<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Game page</title>
	<script src="//cdn.jsdelivr.net/sockjs/0.3.4/sockjs.min.js"></script>
	<script>
		var ws=new WebSocket("ws://localhost:8080/chessgame/game");
		ws.onopen=function(message){
			var id_player=1;
			ws.send("REG"+id_player);
		};
		ws.onclose=function(message){
			ws.close();
		}
		
		var socket = new SockJS('/hello');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function(frame) {
            setConnected(true);
            console.log('Connected: ' + frame);
            stompClient.subscribe('/data/contents', function(greeting){
                showGreeting(JSON.parse(greeting.body).content);
            });
        });
        stompClient.send("/chessgame/chat", {}, JSON.stringify({ 'id': "1" }));
	</script>
</head>
<body>

</body>
</html>