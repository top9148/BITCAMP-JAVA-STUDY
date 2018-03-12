// httpserver2.js

const http = require('http');

const server = http.createServer(function(req, resp) {
    resp.writeHead(
        '200', 
        {
            'Content-Type':'text/html;charset=UTF-8',
            'Access-Control-Allow-Origin': '*'
        });
    
    // 클라이언트에게 HTML 조각을 전달한다.
    resp.write('<p style="background-color: gray; color: white;">');
    resp.write('자바100기');
    resp.write('</p>');
    resp.end();
});

server.listen(8888, function() {
    console.log("서버 실행 중...");
});


















