import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { SubCategory } from 'src/app/model/sub-category';
import { SubSubCategory } from 'src/app/model/sub-sub-category';
import { SubsubcategoriesService } from 'src/app/services/subsubcategories.service';
import { SucategoriesService } from 'src/app/services/sucategories-service.service';

@Component({
  selector: 'app-createsubsubcategories',
  templateUrl: './createsubsubcategories.component.html',
  styleUrls: ['./createsubsubcategories.component.css']
})
export class CreatesubsubcategoriesComponent implements OnInit {

  subsubcategory: SubSubCategory = new SubSubCategory();
  subcategories!: SubCategory[];
  subcategorySelected!: number;
  subcategory!: SubCategory;

  constructor(
    private SubsubCategoryService: SubsubcategoriesService,
    private subcategoriesService: SucategoriesService,
    private router: Router,
    private toastr: ToastrService
  ) { }

  ngOnInit(): void {
   this.getSubCategories();
  }


  createSubSubCategory() {

    this.subsubcategory.subCategory = this.subcategory

    console.log(this.subcategory)

    this.SubsubCategoryService.createSubSubCategory(this.subsubcategory).subscribe(data => {

      this.subsubcategory = data;

      console.log(this.subsubcategory)

      this.redirectToList();
      this.toastr.success("SubSubcategory successfully created!")
    }

    ,

    error => {
     this.toastr.error("Error!" + error.message)
    });
  }
  redirectToList() {
    this.router.navigate(['/listsubsubcategories'])
  }







  getSubCategories() {
    this.subcategoriesService.getAllSubCategories().subscribe(data => {
      this.subcategories = data;
    }, error => {
      this.toastr.error("Error!" + error.message)
    });
  }

  getSubCategorySelected(id: number) {
    console.log(id)
    this.subcategoriesService.findSubCategoryById(id).subscribe(data => {
      this.subcategory = data;
      console.log(this.subcategory);
    });
  }

}

