import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule }   from '@angular/forms';

import { BookService } from './book.service';
import { UserService } from './user.service';
import { CartService } from './cart.service';
import { AuthService } from './auth.service';
import { TokenStorage } from './token.storage';
import { Interceptor } from './interceptor';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ContactComponent } from './contact/contact.component';
import { LoginComponent } from './login/login.component';
import { FaqComponent } from './faq/faq.component';
import { CreateComponent } from './create/create.component';
import { PaymentComponent } from './payment/payment.component';
import { BooksComponent } from './books/books.component';
import { BookDetailComponent } from './book-detail/book-detail.component';
import { AdminSearchComponent } from './admin-search/admin-search.component';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { CartComponent } from './cart/cart.component';
import { BookSearchComponent } from './book-search/book-search.component';


@NgModule({
    declarations: [
        AppComponent,
        NavbarComponent,
        ContactComponent,
        LoginComponent,
        FaqComponent,
        CreateComponent,
        PaymentComponent,
        BooksComponent,
        BookDetailComponent,
        AdminSearchComponent,
        AdminPageComponent,
        CartComponent,
        BookSearchComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule,
        ReactiveFormsModule
    ],
    providers: [
        BookService,
        UserService,
        CartService,
        AuthService,
        TokenStorage,
        {
            provide: HTTP_INTERCEPTORS,
            useClass: Interceptor,
            multi: true
        }
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }
