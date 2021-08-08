import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { SubSubCategory } from 'src/app/model/sub-sub-category';
import { SubsubcategoriesService } from 'src/app/services/subsubcategories.service';

@Component({
  selector: 'app-editsubsubcategories',
  templateUrl: './editsubsubcategories.component.html',
  styleUrls: ['./editsubsubcategories.component.css']
})
export class EditsubsubcategoriesComponent implements OnInit {

  id!: number;
  subsubcategory: SubSubCategory = new SubSubCategory();

  constructor(
    private subsubcategoryService: SubsubcategoriesService,
    private route: ActivatedRoute,
    private router: Router,
     private toastr: ToastrService
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.subsubcategoryService.findSubSubCategoryById(this.id).subscribe(data=>{
      this.subsubcategory = data;
    });
  }

  editSubSubCategory(){
    this.subsubcategoryService.editSubSubCategory(this.id, this.subsubcategory).subscribe(data => {
      this.redirectToList();
      this.toastr.success("SubSubcategory successfully updated!")
    })
  }

  redirectToList(){
    this.router.navigate(['/listsubsubcategories']);
  }

}
