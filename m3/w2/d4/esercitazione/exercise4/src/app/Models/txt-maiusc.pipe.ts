import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'txtMaiusc'
})
export class TxtMaiuscPipe implements PipeTransform {

  transform(value: any): string {
    return value.toUpperCase();
  }

}
