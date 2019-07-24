import { Component, OnInit } from '@angular/core';
import { BookServiceService } from '../book-service.service';
import { Book } from './book';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
  books:Book[];
  statusMessage: string
  book = new Book();

  constructor(private _bookService:BookServiceService) { }
  ngOnInit() {
    this.getBooks();
  }

  getBooks():void
  {
    console.log("Got a book");
    this._bookService.getBooks()
    .subscribe((bookData) => this.books = bookData,
                                (error) => {console.log(error);
                                this.statusMessage = "Problem with service"
                                }
    );
  }

  addBook():void{
    this._bookService.addBook(this.book)
    .subscribe((response)=>{console.log(response);
    },
    (error)=>{
      console.log(error);
      this.statusMessage = "Problem with service. Please try again later!";
    });

  }
  deleteBook(id:number)
  {
    this._bookService.deleteBook(id)
    .subscribe(
      (response) => {console.log(response);
                    this.getBooks();},
                    (error) =>{
                      console.log(error); 
                      this.statusMessage = "Problem with service"
                    }
    )
  }

  getBook(bookId: number){
    this._bookService.getBookByID(bookId)
    .subscribe(
      (bookData) => {this.book = (bookData);
                    this.getBooks();}),
                    (error) =>{
                      console.log(error); 
                      this.statusMessage = "Problem with service"
                    }
  }

}
