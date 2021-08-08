import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Submodel } from '../model/submodel';

@Injectable({
  providedIn: 'root'
})
export class SubmodelsService {

  private submodelsUrl = "http://127.0.0.1:8081/submodels";


  constructor(private http: HttpClient) {}
  getAllSubModels(): Observable<Submodel[]> {
    //return this.http.get<Category[]>(`${this.categoriesUrl}`);
    return this.http.get<Submodel[]>(this.submodelsUrl+"/list");
  }

  createSubModel(submodel: Submodel): Observable<Submodel>{
    return this.http.post<Submodel>(this.submodelsUrl+"/new", submodel);
  }

  deleteSubModel(id: number): Observable<Submodel>{
    return this.http.delete<Submodel>(`${this.submodelsUrl}/submodel/${id}`);
  }

  editSubModel(id: number, submodel: Submodel): Observable<any>{
    return this.http.put(`${this.submodelsUrl}/submodel/${id}`, submodel);
  }


  findByTitle(title: any): Observable<Submodel[]> {
    return this.http.get<Submodel[]>(`${this.submodelsUrl}/list?title=${title}`);
  }

  findSubModelById(id: number): Observable<Submodel>{
    return this.http.get<Submodel>(`${this.submodelsUrl}/submodel/${id}`);
  }


}

