import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Brand } from 'src/app/model/brand';
import { Model } from 'src/app/model/model';
import { BrandService } from 'src/app/services/brand.service';
import { ModelsService } from 'src/app/services/models.service';

@Component({
  selector: 'app-createmodel',
  templateUrl: './createmodel.component.html',
  styleUrls: ['./createmodel.component.css']
})
export class CreatemodelComponent implements OnInit {

  model: Model= new Model();
  brands!: Brand[];
  brandSelected!: number;
  brand!: Brand;

  constructor(
    private modelService: ModelsService,
    private brandService: BrandService,
    private router: Router,
    private toastr: ToastrService
  ) { }

  ngOnInit(): void {
    this.getBrands();
  }


  createModel() {
//this.brand.models=this.brand
    this.model.brand = this.brand
    //this.model=this.model;

    console.log(this.model)

    this.modelService.createModel(this.model).subscribe(data => {

      this.model = data;

      console.log(this.model)

      this.redirectToList();
      this.toastr.success("Model successfully created!")
    },

    error => {
     this.toastr.error("Error!" + error.message)
    });

  }
  redirectToList() {
    this.router.navigate(['/listmodels'])
  }

  getBrands() {
    this.brandService.getAllBrands().subscribe(data => {
      this.brands = data;
    }, error => {
      this.toastr.error("Error!" + error.message)
    });
  }

  getBrandSelected(id: number) {
    console.log(id)
    this.brandService.findBrandById(id).subscribe(data => {
      this.brand = data;
      console.log(this.brand);
    });
  }

}
