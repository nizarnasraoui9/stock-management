import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Brand } from 'src/app/model/brand';
import { BrandService } from 'src/app/services/brand.service';

@Component({
  selector: 'app-list-brands',
  templateUrl: './list-brands.component.html',
  styleUrls: ['./list-brands.component.css']
})
export class ListBrandsComponent implements OnInit {

  brands: Brand[] = [];
  currentBrand?: Brand;
  page: number = 1;
  totalItems!: number;
  name = '';
  //host=window.location.origin;
  host="http://127.0.0.1";


  constructor(
    private brandService: BrandService,
    private toastr: ToastrService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getBrands();
  }

  getBrands() {
    this.brandService.getAllBrands().subscribe(data => {
      if(data != null){
        this.brands = data;
        this.totalItems = data.length;
        this.brands.forEach(brand=>{
          brand.photoPath=this.host+brand.photoPath;


          });
          this.brands.forEach(element=>{
            console.log(element);
          });
        }

      }, error => {
    });
  }

  deleteBrand(id: number) {
    this.brandService.deleteBrand(id).subscribe(data => {
      this.toastr.warning("Brand succesfully deleted!")
      this.getBrands();
      this.router.navigate(['listbrands']);

    }, error => {
      this.toastr.error("Error!")
      console.log(error)
    })
  }

  searchTitle(): void {
    if (this.name != "") {
      this.currentBrand = undefined;
      this.brandService.findByName(this.name).subscribe(data => {
        this.brands = data;
        this.totalItems = data.length;
        console.log(data);
      },
      error => {
        this.toastr.warning("Error!"+ error.message);
      });
    }else{
      this.getBrands();
    }

  }

  updateBrand(id: number){
    this.router.navigate(['editbrand', id]);
  }








}
