import { Component, Input } from '@angular/core';
import { AbstractControlDirective, AbstractControl } from '@angular/forms';

@Component({
  selector: 'show-errors',
  templateUrl: './show-errors.component.html',
  styleUrls: ['./show-errors.component.css']
})
export class ShowErrorsComponent {

  private static readonly errorMessages = {
    'required': () => 'Ce champ est obligatoire',
    'minlength': (params) => 'Le nombre de caractères minimum est  ' + params.requiredLength,
    'maxlength': (params) => 'Le nombre de caractères maximum est ' + params.requiredLength,
    'pattern': (params) => 'Veuillez entrer un code postal valide',
    'years': (params) => params.message,
    'countryCity': (params) => params.message,
    'uniqueName': (params) => params.message,
    'telephoneNumbers': (params) => params.message,
    'telephoneNumber': (params) => params.message,
    'email': () => 'Veuillez entrer un email valide',
    'passwordConfirming': () => 'Les mots de passe doivent être identiques et comportés au moins 6 caractères',
    'zipControl': () => 'Le code postal n\'est pas valide'
  };

  @Input()
  private control: AbstractControlDirective | AbstractControl;

  shouldShowErrors(): boolean {
    return this.control &&
      this.control.errors &&
      this.control.dirty &&
      this.control.touched;
  }

  listOfErrors(): string[] {
    return Object.keys(this.control.errors)
      .map(field => this.getMessage(field, this.control.errors[field]));
  }

  private getMessage(type: string, params: any) {
    return ShowErrorsComponent.errorMessages[type](params);
  }
}
