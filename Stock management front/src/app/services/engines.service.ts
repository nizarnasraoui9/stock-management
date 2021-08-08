import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Engine } from '../model/engine';

@Injectable({
  providedIn: 'root'
})
export class EnginesService {

  private enginesUrl = "http://127.0.0.1:8081/engines";


  constructor(private http: HttpClient) {}
  getAllEngines(): Observable<Engine[]> {
    //return this.http.get<Category[]>(`${this.categoriesUrl}`);
    return this.http.get<Engine[]>(this.enginesUrl+"/list");
  }

  createEngine(engine: Engine): Observable<Engine>{
    return this.http.post<Engine>(this.enginesUrl+"/new", engine);
  }
  createEngine2(engine: Engine,year:String): Observable<any>{
    console.log("http://localhost:8081/brand_engine/add/"+engine.brand.name+"/"+year, engine);
    return this.http.post<any>("http://localhost:8081/brand_engine/add/"+engine.brand.name+"/"+year, engine);
  }
  hello():Observable<number>{
    return this.http.get<number>("http://127.0.0.1:8081/categories/test");
  }

  deleteEngine(id: number): Observable<Engine>{
    return this.http.delete<Engine>(`${this.enginesUrl}/engine/${id}`);
  }

  editEngine(id: number, engine: Engine): Observable<any>{
    return this.http.put(`${this.enginesUrl}/engine/${id}`, engine);
  }


  findByName(name: any): Observable<Engine[]> {
    return this.http.get<Engine[]>(`${this.enginesUrl}/list?name=${name}`);
  }

  findEngineById(id: number): Observable<Engine>{
    return this.http.get<Engine>(`${this.enginesUrl}/engine/${id}`);
  }


}

