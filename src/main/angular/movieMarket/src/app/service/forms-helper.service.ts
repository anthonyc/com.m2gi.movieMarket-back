import { Injectable } from '@angular/core';
import {AbstractControl, AbstractControlDirective} from "@angular/forms";

@Injectable()
export class FormsHelperService {

  constructor() { }


  isFieldValid(control: AbstractControlDirective | AbstractControl): boolean {
    return control.valid && control.dirty;
  }

  isFieldInvalid(control: AbstractControlDirective | AbstractControl): boolean {
    return control.errors &&
      control.dirty &&
      control.touched;
  }

  displayFieldCss(control: AbstractControlDirective | AbstractControl) {

    if (this.isFieldInvalid(control)) {
      return 'is-invalid';
    }

    if (this.isFieldValid(control)) {
      return  'is-valid';
    }

    return '';
  }
}
