import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
    isCollapse: boolean = true;
    toggleIcon: string = "fas fa-plus";

    constructor() { }

    ngOnInit() {
    }

    toggle(): void {
        this.isCollapse = !this.isCollapse;
        if (this.isCollapse) {
            this.toggleIcon = "fas fa-plus";
        } else {
            this.toggleIcon = "fas fa-minus"
        }
    }

}
