import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from '../model/category';
import { SubCategory } from '../model/sub-category';

@Injectable({
  providedIn: 'root'
})
export class SucategoriesService {

  private subcategoriesUrl = "http://127.0.0.1:8081/subcategories";

  constructor(private http: HttpClient) { }

  getAllSubCategories(): Observable<SubCategory[]> {
    //return this.http.get<Category[]>(`${this.categoriesUrl}`);
    return this.http.get<SubCategory[]>(this.subcategoriesUrl+"/list");
  }

  createSubCategory(subCategory: SubCategory): Observable<SubCategory>{
    return this.http.post<SubCategory>(`${this.subcategoriesUrl}/new`, subCategory);
  }

  deleteSubCategory(id: number): Observable<SubCategory>{
    return this.http.delete<SubCategory>(`${this.subcategoriesUrl}/subcategorie/${id}`);
  }

  editSubCategory(id: number, subCategory: SubCategory): Observable<any>{
    return this.http.put(`${this.subcategoriesUrl}/subcategorie/${id}`, subCategory);
  }


  findByTitle(title: any): Observable<SubCategory[]> {
    return this.http.get<SubCategory[]>(`${this.subcategoriesUrl}/list?title=${title}`);
  }

  findSubCategoryById(id: number): Observable<SubCategory>{
    return this.http.get<SubCategory>(`${this.subcategoriesUrl}/subcategorie/${id}`);
  }


}
