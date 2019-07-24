import { Component, OnInit } from '@angular/core';

import { Book } from '../book/book';
import { BookServiceService } from '../book-service.service';

@Component({
  selector: 'app-booklist',
  templateUrl: './booklist.component.html',
  styleUrls: ['./booklist.component.css']
})
export class BooklistComponent implements OnInit {
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

 /*  //1. create empty books array
  public books:Book[];
  //2. create service object
  constructor(private bookService: BookServiceService) { }

  //3. 
  ngOnInit() {
    this.books=this.bookService.getBooks();
  }
*/
}
