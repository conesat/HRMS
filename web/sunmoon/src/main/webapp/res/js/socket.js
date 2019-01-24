var wsUri = "ws://10.66.66.131/websocket/socketServer.do";


function init() {
	console.log("初始化");
	testWebSocket();
}

function testWebSocket() {
	websocket = new WebSocket(wsUri);
	websocket.onopen = function(evt) {
		onOpen(evt)
	};
	websocket.onclose = function(evt) {
		onClose(evt)
	};
	websocket.onmessage = function(evt) {
		onMessage(evt)
	};
	websocket.onerror = function(evt) {
		onError(evt)
	};
}

function onOpen(evt) {
	console.log("CONNECTED");
	doSend("WebSocket rocks");
}

function onClose(evt) {
	console.log("DISCONNECTED");
}

function onMessage(evt) {
	getMsg();
}

function onError(evt) {
}

function doSend(message) {
	console.log("SENT: " + message);
	websocket.send(message);
}


window.addEventListener("load", init, false);