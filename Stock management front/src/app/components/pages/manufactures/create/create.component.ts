import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Manufacture } from 'src/app/model/manufacture';
import { ManufacturesService } from 'src/app/services/manufactures.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  manufacture: Manufacture = new Manufacture();
  fileToUpload: File | null=null ;
  name=""

  constructor(private manufacturesService: ManufacturesService,
    private router: Router,
    private toastr: ToastrService) {

  }

  ngOnInit(): void {
  }

  createManufacture(){
    this.manufacturesService.createManufacture2(this.fileToUpload,this.name).subscribe(resp=>{
      console.log(resp);
      this.redirectToList();
      this.toastr.success("Manufacture successfully created!")

    }, error=>{
      this.toastr.error("Error!"+ error.message)
    });
  }

  redirectToList(){
    this.router.navigate(['/listmanufactures'])
  }






  handleFileInput(files: FileList) {
    this.fileToUpload = files.item(0);
    console.log(this.fileToUpload);
}




}
