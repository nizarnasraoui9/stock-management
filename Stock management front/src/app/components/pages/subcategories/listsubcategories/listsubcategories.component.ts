import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { SubCategory } from 'src/app/model/sub-category';
import { SucategoriesService } from 'src/app/services/sucategories-service.service';

@Component({
  selector: 'app-listsubcategories',
  templateUrl: './listsubcategories.component.html',
  styleUrls: ['./listsubcategories.component.css']
})
export class ListsubcategoriesComponent implements OnInit {

  subcategories: SubCategory[] = [];
  currentSubCategory?: SubCategory;
  page: number = 1;
  totalItems!: number;
  title = '';

  constructor(
    private subcategoryService: SucategoriesService,
    private toastr: ToastrService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getSubCategories();
  }

  getSubCategories() {
    this.subcategoryService.getAllSubCategories().subscribe(data => {
      if (data != null) {
        this.subcategories = data;
        this.totalItems = data.length;
      }
    }, error => {
      console.log(error)
    });
  }

  deleteSubCategory(id: number) {
    this.subcategoryService.deleteSubCategory(id).subscribe(data => {
      this.toastr.warning("Subcategory succesfully deleted!")
      this.getSubCategories()
      this.router.navigate(['/listsubcategories'])
    }, error => {
      console.log(error);
    })
  }

  searchTitle(): void {
    if (this.title != "") {
      this.currentSubCategory = undefined;
      this.subcategoryService.findByTitle(this.title).subscribe(data => {
        this.subcategories = data;
        this.totalItems = data.length;
        console.log(data);
      },
        error => {
          console.log(error)
        });
    } else {
      this.getSubCategories();
    }

  }

  updateCategory(id: number) {
    this.router.navigate(['editsubcategory', id]);
  }

}
