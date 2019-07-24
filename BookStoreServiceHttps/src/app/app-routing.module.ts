import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { BooklistComponent } from './booklist/booklist.component';
import { BookComponent } from './book/book.component';

const routes: Routes = [
  { path: 'Home', component: HomeComponent },
  { path: 'BookList', component: BooklistComponent },
  { path: 'Book', component: BookComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
