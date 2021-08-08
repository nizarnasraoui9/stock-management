import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Category } from 'src/app/model/category';
import { CategoriesService } from 'src/app/services/categories.service';
import { ImageComponent } from '../../image/image.component';

@Component({
  selector: 'app-create-category',
  templateUrl: './create-category.component.html',
  styleUrls: ['./create-category.component.css']
})
export class CreateCategoryComponent implements OnInit {

  category: Category = new Category();
  fileToUpload: File | null=null ;
  nameCategory:string="";



  constructor(
    private categoryService: CategoriesService,
    private router: Router,
    private toastr: ToastrService,
    private httpClient:HttpClient
  ) { }

  ngOnInit(): void {
  }


  createCategory(){
    this.categoryService.createcategory2(this.fileToUpload,this.nameCategory).subscribe(resp=>{
      console.log(resp);



      this.redirectToList();
      this.toastr.success("Category successfully created!")

    }, error=>{
      this.toastr.error("Error!"+ error.message)
    });
  }

  redirectToList(){
    this.router.navigate(['/listcategories'])
  }

  handleFileInput(files: FileList) {
    this.fileToUpload = files.item(0);
    console.log(this.fileToUpload);
}





  /*public selectedFile: any;
  public event1:any;
  imgURL: any;
  receivedImageData: any;
  base64Data: any;
  convertedImage: any;

  public onFileChanged(event:any) {
    console.log(event);
    this.selectedFile = event.target.files[0];













   /* onupload(formData: FormData): Observable<any> {
      return this.http.post<FormData>('/api/users/upload', formData, {
        reportProgress: true,
        observe: 'events'
      })
    }
    // Below part is used to display the selected image
   /* let reader = new FileReader();
    reader.readAsDataURL(event.target.files[0]);
    reader.onload = (event2) => {
      this.imgURL = reader.result;
  };

 }


 // This part is for uploading
 onUpload(event:any) {


  const uploadData = new FormData();
  uploadData.append('myFile', this.selectedFile, this.selectedFile.name);


  this.httpClient.post('http://localhost:8081//image/uploadMultipleFiles', uploadData)
  .subscribe(
               res => {console.log(res);
                       this.receivedImageData = res;
                       this.base64Data = this.receivedImageData.pic;
                       this.convertedImage = 'data:image/jpeg;base64,' + this.base64Data; },
               err => console.log('Error Occured duringng saving: ' + err)
            );


 }
*/

}


