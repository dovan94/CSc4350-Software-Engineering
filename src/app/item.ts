export class Item {
    book_id: string;
    title: string;
    author: string;
    genre: string;
    image: string;
    quantity: number;
    unitPrice: number;
    total: number;

    constructor() {
        this.book_id = "";
        this.title = "";
        this.author = "";
        this.genre = "";
        this.image = "";
        this.quantity = 0;
        this.unitPrice = 0;
        this.total = 0;
    }
}
