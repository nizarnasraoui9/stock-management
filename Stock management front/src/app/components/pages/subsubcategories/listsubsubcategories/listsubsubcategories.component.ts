import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { SubSubCategory } from 'src/app/model/sub-sub-category';
import { SubsubcategoriesService } from 'src/app/services/subsubcategories.service';

@Component({
  selector: 'app-listsubsubcategories',
  templateUrl: './listsubsubcategories.component.html',
  styleUrls: ['./listsubsubcategories.component.css']
})
export class ListsubsubcategoriesComponent implements OnInit {

  subsubcategories: SubSubCategory[] = [];
  currentSubSubCategory?: SubSubCategory;
  page: number = 1;
  totalItems!: number;
  title= ''

  constructor(
    private subsubcategoryService: SubsubcategoriesService,
    private toastr: ToastrService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getSubSubCategories();
  }

  getSubSubCategories() {
    this.subsubcategoryService.getAllSubSubCategories().subscribe(data => {
      if (data != null) {
        this.subsubcategories = data;
        this.totalItems = data.length;
      }
    }, error => {
      console.log(error)
    });
  }

  deleteSubSubCategory(id: number) {
    this.subsubcategoryService.deleteSubSubCategory(id).subscribe(data => {
      this.toastr.warning("Subsubacategory succesfully deleted!")
      this.getSubSubCategories()
      this.router.navigate(['/listsubsubcategories'])
    }, error => {
      console.log(error);
    })
  }

  searchTitle(): void {
    if (this.title != "") {
      this.currentSubSubCategory = undefined;
      this.subsubcategoryService.findByTitle(this.title).subscribe(data => {
        this.subsubcategories = data;
        this.totalItems = data.length;
        console.log(data);
      },
        error => {
          console.log(error)
        });
    } else {
      this.getSubSubCategories();
    }

  }

  updateSubSubCategory(id: number) {
    this.router.navigate(['editsubsubcategory', id]);
  }

}

