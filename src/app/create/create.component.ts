import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from '../user.service';
import { User } from '../user';

import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
    selector: 'app-create',
    templateUrl: './create.component.html',
    styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
    newUser: User;
    username_err: string;
    isExist: boolean = false;
    success: boolean = false;

    signUpForm: FormGroup;


    constructor(private userService: UserService) {
        this.newUser = new User("", "", "", "", "");
    }

    ngOnInit() {
    }

    onSubmit(f: NgForm) {
        this.userService.isExist(f.value.username)
            .subscribe(exist => {
                this.isExist = exist;
                if (!this.isExist) {
                    this.userService.signup(this.newUser)
                        .subscribe(result => {
                            if (result == "Saved") {
                                this.success = true;
                                f.resetForm();
                            }
                        });
                }
            });
    }

}
