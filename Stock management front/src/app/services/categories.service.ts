import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from '../model/category';

@Injectable({
  providedIn: 'root'
})
export class CategoriesService {

  private categoriesUrl = "http://127.0.0.1:8081/categories";

  constructor(private http: HttpClient) { }

  /*getAllCategories(params: any): Observable<Category[]> {
    //return this.http.get<Category[]>(`${this.categoriesUrl}`);
    return this.http.get<Category[]>(this.categoriesUrl, { params });
  }*/

  getAllCategories(): Observable<Category[]> {
    //return this.http.get<Category[]>(`${this.categoriesUrl}`);
    return this.http.get<Category[]>(this.categoriesUrl+"/list");
  }

  createCategory(category: Category): Observable<Category>{
    return this.http.post<Category>(this.categoriesUrl+"/new", category);
  }

//category with image
  createcategory2(file:any,nameCategory:string){
    let header=new HttpHeaders({'Content-type':'multipart/form-data','boundary' : '-----xxxx'});

    let formData:FormData = new FormData();
    formData.append('photo', file);
    formData.append('title', nameCategory);


    return this.http.post(this.categoriesUrl+"/new",formData);
  }
  deleteCategory(id: number): Observable<Category>{
    return this.http.delete<Category>(`${this.categoriesUrl}/categorie/${id}`);
  }

  editCategory(id: number, category: Category): Observable<any>{
    return this.http.put(`${this.categoriesUrl}/categorie/${id}`, category);
  }


  findByTitle(title: any): Observable<Category[]> {
    return this.http.get<Category[]>(`${this.categoriesUrl}/list?title=${title}`);
  }

  findCategoryById(id: number): Observable<Category>{
    return this.http.get<Category>(`${this.categoriesUrl}/categorie/${id}`);
  }


}
