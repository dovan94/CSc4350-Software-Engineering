import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { BooksComponent } from './books/books.component';
import { BookDetailComponent } from './book-detail/book-detail.component';
import { ContactComponent } from './contact/contact.component';
import { LoginComponent } from './login/login.component';
import { CreateComponent } from './create/create.component';
import { PaymentComponent } from './payment/payment.component';
import { FaqComponent } from './faq/faq.component';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { CartComponent } from './cart/cart.component';


const routes: Routes = [
    { path: '', redirectTo: '/books', pathMatch: 'full' },
    { path: 'books', component: BooksComponent },
    { path: 'book/:id', component: BookDetailComponent },
    { path: 'help/contact', component: ContactComponent },
    { path: 'login', component: LoginComponent},
    { path: 'create', component: CreateComponent},
    { path: 'payment', component: PaymentComponent},
    { path: 'help/faq', component: FaqComponent},
    { path: 'admin', component: AdminPageComponent },
    { path: 'cart', component: CartComponent}
];

@NgModule({
    imports: [ RouterModule.forRoot(routes) ],
    exports: [ RouterModule ]
})

export class AppRoutingModule { }
