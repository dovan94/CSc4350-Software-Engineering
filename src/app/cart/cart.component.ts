import { Component, OnInit } from '@angular/core';
import { Book } from '../book';
import { Item } from '../item';
import { CartService } from '../cart.service';
import { TokenStorage } from '../token.storage';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
    isCollapse: boolean = true;
    toggleIcon: string = "fas fa-plus";
    bookList: any[] = [];

    cart = {
        items: new Array<Item>(),
        subtotal: 0
    };
    ordered = false;
  
    constructor(
        private cartService: CartService,
        private token: TokenStorage
    ) {}

    ngOnInit() {
        let userId = this.token.getUserId();
        this.cartService.getCartItems(userId)
            .subscribe(list => {
                this.bookList = list;
                for (var i = 0; i < list.length; i++) {
                    this.cart.items[i] = new Item();

                    this.cart.items[i].book_id = list[i].book.book_id;
                    this.cart.items[i].title = list[i].book.title;
                    this.cart.items[i].author = list[i].book.author;
                    this.cart.items[i].genre = list[i].book.genre;
                    this.cart.items[i].image = list[i].book.image;
                    this.cart.items[i].unitPrice = list[i].book.price;
                    this.cart.items[i].quantity = list[i].quantity;
                    this.cart.items[i].total = this.cart.items[i].quantity * this.cart.items[i].unitPrice;
                    this.cart.subtotal += this.cart.items[i].total;
                }
            });
    }

  toggle(): void {
        this.isCollapse = !this.isCollapse;
        if (this.isCollapse) {
            this.toggleIcon = "fas fa-plus";
        } else {
            this.toggleIcon = "fas fa-minus";
        }
    }
  
    updatePrice(index: number) {
        this.cart.items[index].total = this.cart.items[index].unitPrice * this.cart.items[index].quantity;
        let temp = 0;
        for (var i = 0; i < this.cart.items.length; i++) {
            temp += this.cart.items[i].total;
        }
        this.cart.subtotal = temp;
    }

    // Jeff
    submitOrder(): void{
      let userId: string = this.token.getUserId();

      this.cartService.submitOrder(userId).subscribe((success) => {
        console.log("Success goes here")
        this.cart.items = [];
        this.cart.subtotal = 0;
        this.ordered = true;
        this.isCollapse = true;
      });
    }

}
