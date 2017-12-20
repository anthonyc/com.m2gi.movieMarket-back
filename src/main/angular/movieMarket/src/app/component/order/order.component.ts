import { Address } from './../../model/address';
import { CreditCard } from './../../model/creditCard';
import { AuthenticateService } from './../../service/authenticate.service';
import { Component, OnInit } from '@angular/core';
import { UserService } from '../../service/user.service';
import { FormBuilder, FormGroup, Validators, AbstractControl } from '@angular/forms';
import { FormsHelperService } from '../../service/forms-helper.service';
import { User } from '../../model/user';
import { Gender } from '../../model/person';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
    user: User = new User();
    deliveryAddress: Address;
    creditCard: CreditCard = new CreditCard();
    userForm: FormGroup;
    info = null;
    error = null;
    finished = false;
    isLogged = false;

    showAddressDanger = '';
    showAddressDone = '';


    public steps: Map<string, string>;


    constructor (private userService: UserService,
                public authenticateService: AuthenticateService,
                private formBuilder: FormBuilder,
                public formsHelper: FormsHelperService
            ) {

        this.createForm();
        this.steps = new Map<string, string>();
        this.steps.set('start', 'show');
        this.steps.set('connect', '');
        this.steps.set('createAccount1', '');
        this.steps.set('createAccount2', '');
        this.steps.set('address', '');
        this.steps.set('payment', '');
        this.steps.set('address_connected', '');
    }

    createForm() {
        this.userForm = this.formBuilder.group({
            'gender': ['', Validators.required ],
            'lastname': ['', Validators.required ],
            'firstname': ['', Validators.required ],
            'username': ['', Validators.required ],
            'birthday': ['', Validators.required ],
            'cardNumber': ['', Validators.required ], // TODO: make a real validator
            'expirationMonth': ['', Validators.required ],
            'expirationYear': ['', Validators.required ],
            'code': ['', Validators.required ],
            'email': ['', Validators.email ],
            'passwords': this.formBuilder.group({
            'password': [''],
            'confirmPassword': ['']
            }, {validator: this.passwordConfirming})
        });

        this.user.gender = Gender.MR;
        }

    passwordConfirming(control: AbstractControl) {
        if ((control.get('password').value !== control.get('confirmPassword').value) ||
            control.get('password').value.length < 6 && control.get('confirmPassword').value.length < 6) {
            return { passwordConfirming: true };
        }
        return null;
    }

    ngOnInit() {
        if (this.authenticateService.isLogged()) {
            this.userService.find(this.authenticateService.get().id, this.authenticateService.get().token).subscribe(
                value => this.user,
                error => this.error,
                () => {
                    this.isLogged = true;
                    console.log(this.user);
                    this.showStartConnected(null);
                }
            );
        }
    }

    private setStep(stepName: string) {
        for (const key of Array.from(this.steps.keys())) {
            this.steps.set(key, '');
        }
        this.steps.set(stepName, 'show');
    }

    showStart(event) {
        this.setStep('start');
    }

    showStartConnected(event) {
        this.setStep('address_connected');
    }

    showCreateAccount1(event) {
        this.setStep('createAccount1');
    }

    showCreateAccount2(event) {
        let keepGoing = true;

        const toCheck = ['gender', 'lastname', 'firstname', 'birthday'];
        toCheck.forEach(s => {
            const control = this.userForm.get(s);
            if (control.pristine || control.invalid) {
                keepGoing = false;
                control.markAsTouched({ onlySelf: true });
                control.markAsDirty({ onlySelf: true });
            }
        });

        if (keepGoing) {
            this.setStep('createAccount2');
        }
    }

    showAddress(event) {
        let keepGoing = true;

        const toCheck = ['username', 'email', 'passwords'];
        toCheck.forEach(s => {
            const control = this.userForm.get(s);
            if (control.pristine || control.invalid) {
                keepGoing = false;
                control.markAsTouched({ onlySelf: true });
                control.markAsDirty({ onlySelf: true });
            }
        });

        if (keepGoing) {
            this.setStep('address');
        }
    }

    showPaymentFromCreateAddress(event) {
        if (this.deliveryAddress) {
            this.showAddressDanger = '';
            this.showAddressDone = '';
            this.setStep('payment');
            return;
        }
        this.showAddressDanger = 'show';
    }

    showBeforePayment(event) {
        if (this.isLogged) {
            this.showStartConnected(event);
        } else {
            this.setStep('address');
        }
    }

    create() {
        console.log(this.user);
        console.log(this.deliveryAddress);
        console.log(this.creditCard);

    }

    setAddress(event: Address) {
        console.log(event);
        this.deliveryAddress = event;
        this.showAddressDone = 'show';
    }

}
