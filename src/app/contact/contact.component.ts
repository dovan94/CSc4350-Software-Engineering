import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
    submitted: boolean = false;
  constructor() { }

  ngOnInit() {
  }

  submitMessage(): void {
      this.submitted = true;
  }

}
