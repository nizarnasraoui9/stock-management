import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Category } from 'src/app/model/category';
import { SubCategory } from 'src/app/model/sub-category';
import { CategoriesService } from 'src/app/services/categories.service';
import { SucategoriesService } from 'src/app/services/sucategories-service.service';

@Component({
  selector: 'app-editsubcategory',
  templateUrl: './editsubcategory.component.html',
  styleUrls: ['./editsubcategory.component.css']
})
export class EditsubcategoryComponent implements OnInit {

  id!: number;
  subcategory: SubCategory = new SubCategory();


  category!:Category;
  categories!: Category[];
  categorySelected!:number;





  constructor(


    private categoriesService: CategoriesService,

    private subcategoryService: SucategoriesService,
    private route: ActivatedRoute,
    private router: Router,
     private toastr: ToastrService
  ) { }

  ngOnInit(): void {
    this.getCategories();

    this.id = this.route.snapshot.params['id'];
    this.subcategoryService.findSubCategoryById(this.id).subscribe(data=>{
      this.subcategory = data;
    });
  }

  editSubCategory(){

    this.subcategory.category = this.category

    console.log(this.subcategory)

    this.subcategoryService.createSubCategory(this.subcategory).subscribe(data => {

      this.subcategory = data;

      console.log(this.subcategory)

    //this.subcategoryService.editSubCategory(this.id, this.subcategory).subscribe(data => {
      this.redirectToList();
      this.toastr.success("Subcategory successfully updated!")
    })
  }

  redirectToList(){
    this.router.navigate(['/listsubcategories']);
  }















  getCategoryChanged(id: number) {
    console.log(id)
    this.categoriesService.findCategoryById(id).subscribe(data => {
      this.category = data;
      console.log(this.category);
    });
  }

  getCategories() {
    this.categoriesService.getAllCategories().subscribe(data => {
      this.categories = data;
    }, error => {
      this.toastr.error("Error!" + error.message)
    });
}
}
