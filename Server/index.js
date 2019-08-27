var express = require("express");
var app = express();
var server = require("http").createServer(app);
var io = require("socket.io").listen(server);
var fs = require("fs");
server.listen(process.env.PORT || 3000);

// app.get("/", function(req, res){
// 	res.sendFile(__dirname + "/index.html");	
// });

console.log("Running");

var arrUser = [];
var exits = true;

io.sockets.on('connection', function(socket) {

    console.log("Co nguoi connect ne");

    //  socket.on('client-send-data', function (data) {
    //  	console.log("Server nhan"+data);
    // // emit toi tat ca moi nguoi
    // io.sockets.emit('server-send-data', { noidung: data });

    // // emit tới máy nguoi vừa gửi
    // socket.emit('serverguitinnhan', { noidung: data });
    //  });

    socket.on('client-register-user', function(data) {
        if (arrUser.indexOf(data) == -1) {
            //Ko ton tai user -> dc dang ky
            arrUser.push(data);
            exits = false;

            //gan dinh danh may gui chat
            socket.un = data;
            //gui danh sach user ve cac may
            io.sockets.emit('server-send-user', { danhsach: arrUser });

            console.log("Server nhan" + data);
        } else {
            exits = true;
            console.log("Server ko nhan vi trung" + data);
        }
        socket.emit('server-send-result', { result: exits });
    });

    socket.on('client-send-chat', function(noiDung) {
        io.sockets.emit('server-send-chat', { chatContent: socket.un + ":" + noiDung });
    });
});