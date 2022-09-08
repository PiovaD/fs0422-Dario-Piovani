import { Directive, ElementRef, HostListener, Input, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appColora]'
})
export class ColoraDirective {

  constructor(
    private ref: ElementRef, //tag a cui si applica la direttiva
    private renderer : Renderer2
    ) { }

    @Input() color!:string //attiva un attributo
    @Input('appColora') fsize!:string

    @HostListener('click') onclick(){
      this.color = 'blue'
      this.renderer.setStyle(this.ref.nativeElement, 'backgroundColor', this.color)
    }

    @HostListener('mouseenter') onMouseEnter(){
      this.color = 'purple'
      this.renderer.setStyle(this.ref.nativeElement, 'backgroundColor', this.color)
    }

    @HostListener('mouseleave') onMouseLeave(){
      this.color = 'yellow'
      this.renderer.setStyle(this.ref.nativeElement, 'backgroundColor', this.color)
    }

  ngOnInit() {

    //this.ref.nativeElement.style.backgroundColor = 'red'

    this.renderer.setStyle(this.ref.nativeElement, 'backgroundColor', this.color)

    this.renderer.setStyle(this.ref.nativeElement, 'font-size', this.fsize)

  }

}
