import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SubSubCategory } from '../model/sub-sub-category';

@Injectable({
  providedIn: 'root'
})
export class SubsubcategoriesService {
  private subsubcategoriesUrl = "http://127.0.0.1:8081/subsubcategories";

  constructor(private http: HttpClient) { }
  getAllSubSubCategories(): Observable<SubSubCategory[]> {
    //return this.http.get<Category[]>(`${this.categoriesUrl}`);
    return this.http.get<SubSubCategory[]>(this.subsubcategoriesUrl+"/list");
  }
  createSubSubCategory(subsubCategory: SubSubCategory): Observable<SubSubCategory>{
    return this.http.post<SubSubCategory>(`${this.subsubcategoriesUrl}/new`, subsubCategory);
  }
  deleteSubSubCategory(id: number): Observable<SubSubCategory>{
    return this.http.delete<SubSubCategory>(`${this.subsubcategoriesUrl}/subsubcategorie/${id}`);
  }
  editSubSubCategory(id: number, subsubCategory: SubSubCategory): Observable<any>{
    return this.http.put(`${this.subsubcategoriesUrl}/subsubcategorie/${id}`, subsubCategory);
  }

  findByTitle(title: any): Observable<SubSubCategory[]> {
    return this.http.get<SubSubCategory[]>(`${this.subsubcategoriesUrl}/list?title=${title}`);
  }

  findSubSubCategoryById(id: number): Observable<SubSubCategory>{
    return this.http.get<SubSubCategory>(`${this.subsubcategoriesUrl}/subsubcategorie/${id}`);
  }

}
