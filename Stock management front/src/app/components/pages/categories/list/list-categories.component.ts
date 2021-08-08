import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Category } from 'src/app/model/category';
import { CategoriesService } from 'src/app/services/categories.service';

@Component({
  selector: 'app-list-categories',
  templateUrl: './list-categories.component.html',
  styleUrls: ['./list-categories.component.css']
})
export class ListCategoriesComponent implements OnInit {

  categories: Category[] = [];
  currentCategory?: Category;
  page: number = 1;
  totalItems!: number;
  title = '';
  //host=window.location.origin;
  host="http://127.0.0.1";


  constructor(
    private categoryService: CategoriesService,
    private toastr: ToastrService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getCategories();
  }

  getCategories() {
    this.categoryService.getAllCategories().subscribe(data => {
      if(data != null){
        this.categories = data;
        //console.log(data);

        this.totalItems = data.length;
        this.categories.forEach(category=>{
          category.photoPath=this.host+category.photoPath;
        });
        this.categories.forEach(element=>{
          console.log(element);

        });
      }
     
    }, error => {
    });
  }


  deleteCategory(id: number) {
    this.categoryService.deleteCategory(id).subscribe(data => {
      this.toastr.warning("Category succesfully deleted!")
      this.getCategories();
      this.router.navigate(['listcategories']);

    }, error => {
      this.toastr.error("Error!")
      console.log(error)
    })
  }

  searchTitle(): void {
    if (this.title != "") {
      this.currentCategory = undefined;
      this.categoryService.findByTitle(this.title).subscribe(data => {
        this.categories = data;
        this.totalItems = data.length;
        console.log(data);
      },
      error => {
        this.toastr.warning("Error!"+ error.message);
      });
    }else{
      this.getCategories();
    }

  }

  updateCategory(id: number){
    this.router.navigate(['editcategory', id]);
  }








}
