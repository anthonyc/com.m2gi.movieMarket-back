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
    userForm: FormGroup;
    info = null;
    error = null;
    finished = false;


    public steps: Map<string, string>;


    constructor (private userService: UserService,
                private formBuilder: FormBuilder,
                public formsHelper: FormsHelperService) {

        this.createForm();
        this.steps = new Map<string, string>();
        this.steps.set('start', 'show');
        this.steps.set('connect', '');
        this.steps.set('createAccount1', '');
        this.steps.set('createAccount2', '');
        this.steps.set('address', '');
        this.steps.set('payment', '');
    }

    createForm() {
        this.userForm = this.formBuilder.group({
            'gender': ['', Validators.required ],
            'lastname': ['', Validators.required ],
            'firstname': ['', Validators.required ],
            'username': ['', Validators.required ],
            'birthday': ['', Validators.required ],
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
    }

    private clearSteps() {
        for (const key of Array.from(this.steps.keys())) {
            this.steps.set(key, '');
        }
    }

    showStart(event) {
        this.clearSteps();
        this.steps.set('start', 'show');
    }

    showCreateAccount1(event) {
        this.clearSteps();
        this.steps.set('createAccount1', 'show');
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
            this.clearSteps();
            this.steps.set('createAccount2', 'show');
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
            this.clearSteps();
            this.steps.set('address', 'show');
        }
    }

    create() {
        console.log('creating ~~~~~~');
    }

    showPayment(event) {
        console.log(event + 'payment');
    }

    showBeforeAddress(event) {
        this.showCreateAccount2(event);
    }

}
