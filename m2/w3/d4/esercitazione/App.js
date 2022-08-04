let titoloPagina = 'Luca è sparito';

let contatti = 'Ci serve il numero di un familiare, non si trova più';

let siamo = 'Siamo un gruppo che si perde ad andare al cesso!';

const express = require('express');
const path = require('path');

const app = express();

app.engine('html', require('ejs').renderFile);
app.set('view engine', 'html');

app.get('/', (req, res) => {
    res.render(path.join(__dirname + '/index.html'), { titolo: titoloPagina })
});

app.get('/page/2', (req, res) => {
    res.render(path.join(__dirname + '/contatti.html'), { contatti: contatti });
});

app.get('/page/3', (req, res) => {
    res.render(path.join(__dirname + '/chi-siamo.html'), { siamo: siamo });
});

app.use((req,res) => {
    res.render(path.join(__dirname + '/not-found'))
})

app.listen(3000, () => console.log("Server attivo all'indirizzo http://127.0.0.1:3000"))
