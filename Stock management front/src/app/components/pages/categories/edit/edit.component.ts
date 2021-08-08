import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Category } from 'src/app/model/category';
import { CategoriesService } from 'src/app/services/categories.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  id!: number;
  category: Category = new Category();

  constructor(
    private categoryService: CategoriesService,
    private route: ActivatedRoute,
    private router: Router,
     private toastr: ToastrService
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.categoryService.findCategoryById(this.id).subscribe(data=>{
      this.category = data;
    });
  }

  editCategory(){
    this.categoryService.editCategory(this.id, this.category).subscribe(data => {
      this.redirectToList();
      this.toastr.success("Category successfully updated!")
    })
  }

  redirectToList(){
    this.router.navigate(['/listcategories']);
  }

}
