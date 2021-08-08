import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Brand } from 'src/app/model/brand';
import { BrandService } from 'src/app/services/brand.service';

@Component({
  selector: 'app-create-brand',
  templateUrl: './create-brand.component.html',
  styleUrls: ['./create-brand.component.css']
})
export class CreateBrandComponent implements OnInit {

  brand: Brand = new Brand();
  fileToUpload: File | null=null ;
  name:string=""
  

  constructor(
    private brandService: BrandService,
    private router: Router,
    private toastr: ToastrService
  ) { }
  ngOnInit(): void {
  }

  createBrand(){
    this.brandService.createcategory2(this.fileToUpload,this.name).subscribe(resp=>{
      console.log(resp);
      this.redirectToList();
      this.toastr.success("Brand successfully created!")

    }, error=>{
      this.toastr.error("Error!"+ error.message)
    });
  }

  redirectToList(){
    this.router.navigate(['/listbrands'])
  }
  handleFileInput(files: FileList) {
    this.fileToUpload = files.item(0);
    console.log(this.fileToUpload);
}


}

