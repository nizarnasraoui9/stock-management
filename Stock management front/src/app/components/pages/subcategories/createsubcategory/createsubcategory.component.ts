import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Category } from 'src/app/model/category';
import { SubCategory } from 'src/app/model/sub-category';
import { CategoriesService } from 'src/app/services/categories.service';
import { SucategoriesService } from 'src/app/services/sucategories-service.service';

@Component({
  selector: 'app-createsubcategory',
  templateUrl: './createsubcategory.component.html',
  styleUrls: ['./createsubcategory.component.css']
})
export class CreatesubcategoryComponent implements OnInit {

  subcategory: SubCategory = new SubCategory();
  categories!: Category[];
  categorySelected!: number;
  category!: Category;

  constructor(
    private subCategoryService: SucategoriesService,
    private categoriesService: CategoriesService,
    private router: Router,
    private toastr: ToastrService
  ) { }

  ngOnInit(): void {
    this.getCategories();
  }


  createSubCategory() {

    this.subcategory.category = this.category

    console.log(this.subcategory)

    this.subCategoryService.createSubCategory(this.subcategory).subscribe(data => {

      this.subcategory = data;

      console.log(this.subcategory)

      this.redirectToList();
      this.toastr.success("Subcategory successfully created!")
    },

    error => {
     this.toastr.error("Error!" + error.message)
    });

  }
  redirectToList() {
    this.router.navigate(['/listsubcategories'])
  }

  getCategories() {
    this.categoriesService.getAllCategories().subscribe(data => {
      this.categories = data;
    }, error => {
      this.toastr.error("Error!" + error.message)
    });
  }

  getCategorySelected(id: number) {
    console.log(id)
    this.categoriesService.findCategoryById(id).subscribe(data => {
      this.category = data;
      console.log(this.category);
    });
  }

}
