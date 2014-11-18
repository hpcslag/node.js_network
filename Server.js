var net = require('net');

net.createServer(function(socket){
	console.log('Connected ' + socket.remoteAddress + ':' +socket.remtoePort);

	socket.on('data',function(data){
		console.log('DATA '+socket.remoteAddress + ":" + data);
		socket.write('You said "'+data+'"');
	});

	socket.on('close',function(data){
		console.log('CLOSED: '+socket.remoteAddress + ' ' + socket.remotePort);
	})
}).listen(8080,'127.0.0.1');