
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Brand } from 'src/app/model/brand';
import { Engine } from 'src/app/model/engine';
import { Model } from 'src/app/model/model';
import { Submodel } from 'src/app/model/submodel';
import { BrandService } from 'src/app/services/brand.service';
import { EnginesService } from 'src/app/services/engines.service';
import { ModelsService } from 'src/app/services/models.service';
import { SubmodelsService } from 'src/app/services/submodels.service';
import {FormControl} from '@angular/forms';
@Component({
  selector: 'app-createengine',
  templateUrl: './createengine.component.html',
  styleUrls: ['./createengine.component.css']
})
export class CreateengineComponent implements OnInit {


  engine: Engine = new Engine();

  brands!: Brand[];
  models: any[]=[];
  submodels:any[]=[];
  filteredModels:any[]=[];
  filteredSubModels:any[]=[];
   bbrand='';

  //submodels!: Submodel[];
  brandSelected: String="0";
  modelSelected: String="0";
  submodelSelected!: number;
  brand!: Brand;
  model!: Model;
  year!:String;
  submodel!: Submodel;



  constructor(
    private engineService: EnginesService,
    private brandsService: BrandService,
    private modelsService: ModelsService,
    private submodelsService: SubmodelsService,
    private router: Router,
    private toastr: ToastrService,



  ) { }

  ngOnInit(): void {
    this.getBrands();
    //this.getModels();
    //this.getSubModels();


  }



  getBrands() {
    this.brandsService.getAllBrands().subscribe(data => {
      this.brands = data;
    }, error => {
      this.toastr.error("Error!" + error.message)
    });
  }




  getBrandSelected(id:number) {
    console.log(id)
    this.brandsService.findBrandById(id).subscribe(data => {
      this.brand = data;
      console.log(this.brand);
      this.modelsService.getAllModels().subscribe(data => {
        this.models = data;
        this.filteredModels=(this.brand)?
        this.models.filter(m=>m.brand?.id===this.brand.id):this.models;
    })
    })

  }


  getModelSelected(id:number) {
    console.log(id)
    this.modelsService.findModelById(id).subscribe(data => {
      this.model = data;
      console.log(this.model);
      this.submodelsService.getAllSubModels().subscribe(data => {
        this.submodels = data;
        this.filteredSubModels=(this.model)?
        this.submodels.filter(m=>m.model?.id===this.model.id):this.submodels;
    })
    })

  }

  getsubModelSelected(id:number)
{
  console.log(id)
  this.submodelsService.findSubModelById(id).subscribe(data=> {
    this.submodel=data;
    console.log(this.submodel);
  })
}

 createEngine(){
  this.engineService.hello().subscribe((res)=>{
    console.log(res);
  });
  this.engine.brand=this.brand;
  this.engine.model=this.model;
  this.engine.submodel=this.submodel;
  this.engineService.hello().subscribe((res)=>{
    console.log(res);
  })
  
  
  /*console.log(this.engine);
   this.engineService.createEngine2(this.engine,this.engine.year).subscribe(data=>
    {
    this.engine=data;
    console.log(this.engine);
    this.redirectToList();
    this.toastr.success("Engine successfully created!")

  },

  error => {
   this.toastr.error("Error!" + error.message)
  });*/

}
redirectToList() {
  this.router.navigate(['/listengines'])
}


}






