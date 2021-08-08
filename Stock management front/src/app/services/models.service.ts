import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Model } from '../model/model';

@Injectable({
  providedIn: 'root'
})
export class ModelsService {

  private modelsUrl = "http://127.0.0.1:8081/models";



  constructor(private http: HttpClient) {}
  getAllModels(): Observable<Model[]> {
    //return this.http.get<Category[]>(`${this.categoriesUrl}`);
    return this.http.get<Model[]>(this.modelsUrl+"/list");
  }

  createModel(model: Model): Observable<Model>{
    return this.http.post<Model>(this.modelsUrl+"/new", model);
  }

  deleteModel(id: number): Observable<Model>{
    return this.http.delete<Model>(`${this.modelsUrl}/model/${id}`);
  }

  editModel(id: number, model: Model): Observable<any>{
    return this.http.put(`${this.modelsUrl}/model/${id}`, model);
  }


  findByTitle(title: any): Observable<Model[]> {
    return this.http.get<Model[]>(`${this.modelsUrl}/list?title=${title}`);
  }

  findModelById(id: number): Observable<Model>{
    return this.http.get<Model>(`${this.modelsUrl}/model/${id}`);
  }

  
}

