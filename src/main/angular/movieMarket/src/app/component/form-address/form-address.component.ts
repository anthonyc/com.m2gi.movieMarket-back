import { Component, Input, OnInit } from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Address} from "../../model/address";
import {FormsHelperService} from "../../service/forms-helper.service";
import {AddressService} from "../../service/address.service";
import {User} from "../../model/user";

@Component({
  selector: 'app-form-address',
  templateUrl: './form-address.component.html',
  styleUrls: ['./form-address.component.css']
})
export class FormAddressComponent implements OnInit {
  @Input() address: Address;
  @Input() user: User;
  addressForm: FormGroup;
  info = null;
  error = null;
  finished = false;

  constructor(private formBuilder: FormBuilder,
        public formsHelper: FormsHelperService,
        private addressService: AddressService) {
    if (!(this.address instanceof Address)) {
      this.address = new Address()
    }

    this.addressForm = this.formBuilder.group({
      'streetNumber': ['', Validators.required],
      'street': ['', Validators.required],
      'additionalInformation': [''],
      'zipCode': ['', Validators.pattern('[0-9]{5}')],
      'city': ['', Validators.required]
    });
  }

  ngOnInit() {
  }

  create() {
    if (this.addressForm.valid) {
      this.addressService.add(this.address, String(this.user.id), this.user.jwtToken).subscribe(
        data => {
          this.info = "Utilisateur créé";
        },
        err => {
          this.error = "Une erreur serveur est survenue. Veuillez réessayer dans quelques instants";

          if (err.status === 400) {
            this.error = "Veuillez remplir tous les champs obligatoires du formulaire";
          }
        },
      () => this.finished = true
      );

      location.reload();
    } else {
      Object.keys(this.addressForm.controls).forEach(field => {
        const control = this.addressForm.get(field);
        if (control.pristine) {
          control.markAsTouched({ onlySelf: true });
          control.markAsDirty({ onlySelf: true });
        }
      });
    }
  }

}
