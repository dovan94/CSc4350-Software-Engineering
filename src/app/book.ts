export class Book {
    book_id: string;
    title: string;
    author: string;
    description: string;
    isbn: string;
    genre: string;
    price: number;
    image: string;
    stock: number;

    constructor(title, author, description, genre, image) {
    }

    public setId(id: string): void {
        this.book_id = id;
    }
}
