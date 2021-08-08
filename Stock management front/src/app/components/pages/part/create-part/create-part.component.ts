import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Brand } from 'src/app/model/brand';
import { Engine } from 'src/app/model/engine';
import { Manufacture } from 'src/app/model/manufacture';
import { Model } from 'src/app/model/model';
import { Part } from 'src/app/model/part';
import { SubSubCategory } from 'src/app/model/sub-sub-category';
import { Submodel } from 'src/app/model/submodel';
import { BrandService } from 'src/app/services/brand.service';
import { EnginesService } from 'src/app/services/engines.service';
import { ManufacturesService } from 'src/app/services/manufactures.service';
import { ModelsService } from 'src/app/services/models.service';
import { PartService } from 'src/app/services/part.service';
import { SubmodelsService } from 'src/app/services/submodels.service';
import { SubsubcategoriesService } from 'src/app/services/subsubcategories.service';

@Component({
  selector: 'app-create-part',
  templateUrl: './create-part.component.html',
  styleUrls: ['./create-part.component.css']
})
export class CreatePartComponent implements OnInit {
  //part: Part = new Part();
  engines!:Engine[];
  brands!: Brand[];
  manufactures!:Manufacture[];
  subsubcategories!:SubSubCategory[];
 models: any[]=[];
  submodels:any[]=[];
  filteredModels:any[]=[];
  filteredSubModels:any[]=[];
   //bbrand='';
   engine:any;
buyPrice:any;
sellPrice:any;
reference:any;
photoPath:any;
  //submodels!: Submodel[];
  brandSelected: String="0";
  engineSelected: String="0";
  modelSelected: String="0";
  submodelSelected!: number;
  manufactureSelected:String="0";
  subsubcategorySelected:String="0";
  //brand?: Brand;
  model!: Model;
  submodel!: Submodel;
  subsubcategory!:SubSubCategory;
  manufacture!:Manufacture;
  fileToUpload: File | null=null ;
  files!:any;
  quantity!:any;
  referene!:any;
  name!:string;
  part!:any;
  brand!: any;
  dropdownSettings: any = {};
  ShowFilter = false;
  myForm!:FormGroup;
  selectedItems: Array<Engine> = [];
  limitSelection = false;


  constructor(
    private partService: PartService,
    private engineService: EnginesService,
    private brandsService: BrandService,
   private modelsService: ModelsService,
    private submodelsService: SubmodelsService,
    private subsubcategoryService: SubsubcategoriesService,
    private manufactureService:ManufacturesService,
    private router: Router,
    private toastr: ToastrService,
    private fb: FormBuilder

) { }

  ngOnInit(): void {
    this.getBrands();
    this.getEngines();
    this. getSubsubcategories();
    this.model



    this.dropdownSettings = {
      singleSelection: false,
      idField: 'item_id',
      textField: 'item_text',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: this.ShowFilter
  };


  this.myForm = this.fb.group({
    city: [this.selectedItems]
});
  }


  getEngines(){
    this.engineService.getAllEngines().subscribe(data => {
      this.engines = data;
    }, error => {
      this.toastr.error("Error!" + error.message)
    });
  }
  onItemSelect(item: any) {
    console.log('onItemSelect', item);
}
onSelectAll(items: any) {
    console.log('onSelectAll', items);
}
toogleShowFilter() {
    this.ShowFilter = !this.ShowFilter;
    this.dropdownSettings = Object.assign({}, this.dropdownSettings, { allowSearchFilter: this.ShowFilter });
}

handleLimitSelection() {
    if (this.limitSelection) {
        this.dropdownSettings = Object.assign({}, this.dropdownSettings, { limitSelection: 2 });
    } else {
        this.dropdownSettings = Object.assign({}, this.dropdownSettings, { limitSelection: null });
    }
}































































  getManufactures() {
    this.manufactureService.getAllManufactures().subscribe(data => {
      this.manufactures = data;
    }, error => {
      this.toastr.error("Error!" + error.message)
    });
  }
  getBrands() {
    this.brandsService.getAllBrands().subscribe(data => {
      this.brands = data;
    }, error => {
      this.toastr.error("Error!" + error.message)
    });
  }






  getManufactureSelected(id:number) {
    console.log(id)
    this.manufactureService.findManufactureById(id).subscribe(data => {
      this.manufacture = data;
      console.log(this.manufacture);
    })
  }


  getBrandSelected(id:number){
    console.log(id)
    this.brandsService.findBrandById(id).subscribe(data => {
      this.brand = data;
      console.log(this.manufacture);
    })
  }





  getSubsubcategories() {
    this.subsubcategoryService.getAllSubSubCategories().subscribe(data => {
      this.subsubcategories = data;
    }, error => {
      this.toastr.error("Error!" + error.message)
    });
  }





  getsubsubCategorySelected(id:number) {
    console.log(id)
    this.subsubcategoryService.findSubSubCategoryById(id).subscribe(data => {
      this.subsubcategory = data;
      console.log(this.subsubcategory);
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

 getEngineSelected(id:number){
  //this.engine.brand=this.brand;
  this.engine.model=this.model;
  this.engine.submodel=this.submodel;
   console.log(this.engine);
   this.engineService.createEngine(this.engine).subscribe(data=>
    {
    this.engine=data;
    console.log(this.engine);
    this.redirectToList();
    this.toastr.success("Engine successfully created!")

  },

  error => {
   this.toastr.error("Error!" + error.message)
  });

}
redirectToList() {
  this.router.navigate(['/listengines'])
}


/*createPart(){

  this.part.model=this.model;
  this.part.submodel=this.submodel;
  this.part.manufacture=this.manufacture;
  this.part.subsubcategory=this.subsubcategory;
  this.part.engine=this.engine;
     console.log(this.part);

   this.partService.createPart(this.part).subscribe(data=>
    {
    this.part=data;
    console.log(this.part);
    this.redirectToList();
    this.toastr.success("Part successfully created!")

  },

  error => {
   this.toastr.error("Error!" + error.message)
  });


}*/

createPart(){
  console.log(this.name);
  this.part = {
       "name": this.name,
      "reference": this.reference,
      "quantity": this.quantity,
      "buyPrice": this.sellPrice,
      "sellPrice": this.buyPrice,
      "photoPath":this.photoPath,
  }
  this.partService.createPart(this.part).subscribe(
    data => {
      this.toastr.success("Part successfully created!");
    },
    error => {
      this.toastr.error("Error!" + error.message)
     }
  );
    }

handleFileInput(files: FileList) {
  this.fileToUpload = files.item(0);
  console.log(this.fileToUpload);

}



}

