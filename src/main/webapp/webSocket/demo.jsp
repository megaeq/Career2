<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
var  wsServer = 'ws://localhost:8480/career2/websocket'; 
var  websocket = new WebSocket(wsServer); 
websocket.onopen = function (evt) { onOpen(evt) }; 
websocket.onclose = function (evt) { onClose(evt) }; 
websocket.onmessage = function (evt) { onMessage(evt) }; 
websocket.onerror = function (evt) { onError(evt) }; 
function onOpen(evt) { 
console.log("Connected to WebSocket server."); 
} 
function onClose(evt) { 
console.log("Disconnected"); 
} 
function onMessage(evt) { 
console.log('Retrieved data from server: ' + evt.data); 
} 
function onError(evt) { 
console.log('Error occured: ' + evt.data); 
}
</script>
</head>
<body>

</body>
</html>