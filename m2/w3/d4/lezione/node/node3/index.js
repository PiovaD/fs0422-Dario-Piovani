var http = require('http')

let server = http.createServer((req, res)=>{

    res.writeHead(200,{'content-type': 'text/plain'})

    res.end('Hello world')

})

server.listen(81,'127.0.0.1');

console.log("Server attivo all'indirizzo http://127.0.0.1:81")