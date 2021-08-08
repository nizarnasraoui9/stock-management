import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Brand } from '../model/brand';
import { Engine } from '../model/engine';
import { Manufacture } from '../model/manufacture';
import { Part } from '../model/part';
import { SubSubCategory } from '../model/sub-sub-category';

@Injectable({
  providedIn: 'root'
})
export class PartService {
  private partsUrl = "http://127.0.0.1:8081/parts";

  constructor(private http: HttpClient) { }

  getAllParts(): Observable<Part[]> {
    return this.http.get<Part[]>(this.partsUrl+"/list");
  }


  //category with image
createPart2(file:any,name:string,quantity:string,manufacture:Manufacture,engines:[Engine],brands:[Brand]){
  let header=new HttpHeaders({'Content-type':'multipart/form-data','boundary' : '-----xxxx'});


  let formData:FormData = new FormData();
  formData.append('photo', file);
  formData.append('name', name);
  formData.append('quantity',quantity);
  formData.append('manufacture',manufacture.name)
  formData.append('engine',Engine.name)
  formData.append('subsubcateg',SubSubCategory.name)
  formData.append('brands',Brand.name)



  return this.http.post(this.partsUrl+"/new",formData);
}
  createPart(part: Part): Observable<Part>{
    return this.http.post<Part>(this.partsUrl+"/new", part);
  }

  deletePart(id: number): Observable<Part>{
    return this.http.delete<Part>(`${this.partsUrl}/part/${id}`);
  }

  editPart(id: number, part: Part): Observable<any>{
    return this.http.put(`${this.partsUrl}/part/${id}`, part);
  }


  findByTitle(title: any): Observable<Part[]> {
    return this.http.get<Part[]>(`${this.partsUrl}/list?title=${title}`);
  }

  findPartById(id: number): Observable<Part>{
    return this.http.get<Part>(`${this.partsUrl}/part/${id}`);
  }

}
