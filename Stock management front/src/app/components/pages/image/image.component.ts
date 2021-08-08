import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ImageService } from 'src/app/services/image.service';

@Component({
  selector: 'app-image',
  templateUrl: './image.component.html',
  styleUrls: ['./image.component.css']
})
export class ImageComponent implements OnInit {


  /*isImageLoading: boolean | undefined;


  constructor(
    private imageService:ImageService,
    private toastr: ToastrService,
    private router: Router,
    ) { }
*/
  ngOnInit(): void {
  }
/*


  imageToShow: any;

  createImageFromBlob(image: Blob) {
     let reader = new FileReader();
     reader.addEventListener("load", () => {
        this.imageToShow = reader.result;
     }, false);

     if (image) {
        reader.readAsDataURL(image);
     }
  }

  getImageFromService() {


    this.imageService.getImage("imageUrl").subscribe(data => {
      this.createImageFromBlob(data);
      this.isImageLoading = false;

    }, error => {
      this.isImageLoading = false;
      console.log(error);
    });
}
 imageUrl(imageUrl: any) {
  throw new Error('Function not implemented.');
}*/

}

