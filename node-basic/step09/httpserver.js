// httpserver.js

// 1) HTTP 모듈 로딩 및 객체 준비
const http = require('http');

// 2) HTTP 서버 생성
// createServer(클라이언트에서 요청이 들어왔을 때 호출될 함수)
const server = http.createServer(function(req, resp) {
    resp.writeHead(
        '200', /* 응답 상태 코드 */ 
        { /* 응답 헤더 */
            'Content-Type':'text/plain;charset=UTF-8',
            'Access-Control-Allow-Origin': '*'
        });
    resp.write('hello!');
    
    setTimeout(function() {
        resp.end();
    }, 3000);
});

// 3) 서버 실행
// listen(포트번호[,IP 주소][,서버가 실행되었을 때 호출될 함수]);
server.listen(8888, function() {
    console.log("서버 실행 중...");
});


















