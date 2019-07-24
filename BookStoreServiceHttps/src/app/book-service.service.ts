import { Injectable } from '@angular/core';

import { Book } from './book/Book';
import { Observable } from 'rxjs'
import { HttpClient } from '@angular/common/http';
import { componentHostSyntheticProperty } from '@angular/core/src/render3';

@Injectable({
  providedIn: 'root'
})
export class BookServiceService {

  constructor(private _httpService: HttpClient) { }
  getBooks(): Observable<any>{
   // return this._httpService.get("http://localhost:3000/books")
   return this._httpService.get("http://localhost:8080/SpringHibernateCRUD/api/Book")
  }
  // create array
  // public books:Book[]=[
  //   {"id":1,"title":"java","author":"Martin","price":100},
  //   {"id":2,"title":"javascript","author":"May","price":200},
  //   {"id":3,"title":"jquery","author":"Henry","price":300}
  // ];

  // // return array
  // getBooks():Book[]{
  //   return this.books;
  // }
  addBook(book: Book){
    let body = JSON.parse(JSON.stringify(book));
    
    if(book.id){
      console.log("Entered for updates");
      return this._httpService.put("http://localhost:8080/SpringHibernateCRUD/api/Book", body);

    }else{
    return this._httpService.post("http://localhost:8080/SpringHibernateCRUD/api/Book", body);
    }
  }

  deleteBook(bookId: number){
    return this._httpService.delete("http://localhost:8080/SpringHibernateCRUD/api/Book/" + bookId);
  }

  getBookByID(bookId: number): Observable<any>{
    return this._httpService.get("http://localhost:8080/SpringHibernateCRUD/api/Book/" + bookId);
  }

}

