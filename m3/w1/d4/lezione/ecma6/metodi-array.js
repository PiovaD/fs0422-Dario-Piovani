"use strict";
let prodotti = [
    {
        tipo: 'Maglietta',
        prezzo: 35,
        varianti: [
            {
                taglia: 'xs',
                colore: 'giallo',
                q: 3,
                disponile: true
            },
            {
                taglia: 'xs',
                colore: 'Rosse',
                q: 0,
                disponile: true
            },
            {
                taglia: 'M',
                colore: 'giallo fosforo',
                q: 100,
                disponile: true
            }
        ]
    },
    {
        tipo: 'canottiera',
        prezzo: 25,
        varianti: [
            {
                taglia: 'xs',
                colore: 'giallo',
                q: 15,
                disponile: true
            },
            {
                taglia: 'M',
                colore: 'giallo fosforo',
                q: 100,
                disponile: true
            }
        ]
    }
];
let taglie = prodotti.map(p => p.varianti);
console.log(taglie);
let prodottiModificati = prodotti.map(p => {
    p.varianti = p.varianti.map(v => {
        if (v.q == 0) {
            v.disponile = false;
        }
        return v;
    });
    return p;
});
console.log(prodotti);
let taglieDisponibili = prodottiModificati[0].varianti.filter(v => v.disponile);
console.log(taglieDisponibili);
let jeans = prodottiModificati.find(p => p.tipo == 'jeans');
console.log(jeans);
