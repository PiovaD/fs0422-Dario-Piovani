import { Component, OnInit } from '@angular/core';
import { filter, map, Observable, Subscription } from 'rxjs';

@Component({
  selector: 'app-interval2',
  templateUrl: './interval2.component.html',
  styleUrls: ['./interval2.component.scss']
})
export class Interval2Component implements OnInit {

  constructor() { }

  sub!: Subscription;

  ngOnInit(): void {

    let customInterval = new Observable(obs => {
      let c: number = 0;

      setInterval(() => {
        obs.next(c); // next lancia il dato
        c++;
        if(c>10){
          obs.error('Numero troppo grande')// unsubscribe automatico
        }

        if(c==10){
          obs.complete()
        }

      }, 1000)
    })

    this.sub = customInterval
      .pipe(
        filter(n => (<number>n) > 2),
        map(n => `siamo al numero ${n}`)
      )
      .subscribe({
        next:n => console.log(n),
        error:error => console.log(error),
        complete: () => console.log('completato')

        })//faccio partire l'observable

  }

  ngOnDestroy(): void {
    this.sub.unsubscribe()
  }

}
