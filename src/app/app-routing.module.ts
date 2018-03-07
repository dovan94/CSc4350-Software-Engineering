import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ContactComponent } from './contact/contact.component';
import { LoginComponent } from './login/login.component';
import { CreateComponent } from './create/create.component';
import { PaymentComponent } from './payment/payment.component';
import { FaqComponent } from './faq/faq.component';


const routes: Routes = [
    { path: 'help/contact', component: ContactComponent },
    { path: 'login', component: LoginComponent},
    { path: 'create', component: CreateComponent},
    { path: 'payment', component: PaymentComponent},
    { path: 'help/faq', component: FaqComponent}
];

@NgModule({
    imports: [ RouterModule.forRoot(routes) ],
    exports: [ RouterModule ]
})

export class AppRoutingModule { }
