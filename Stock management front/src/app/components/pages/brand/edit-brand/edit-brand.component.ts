import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Brand } from 'src/app/model/brand';
import { BrandService } from 'src/app/services/brand.service';

@Component({
  selector: 'app-edit-brand',
  templateUrl: './edit-brand.component.html',
  styleUrls: ['./edit-brand.component.css']
})
export class EditBrandComponent implements OnInit {


  id!: number;
  brand: Brand = new Brand();

  constructor(
    private brandService: BrandService,
    private route: ActivatedRoute,
    private router: Router,
     private toastr: ToastrService
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.brandService.findBrandById(this.id).subscribe(data=>{
      this.brand = data;
    });
  }

  editBrand(){
    this.brandService.editBrand(this.id, this.brand).subscribe(data => {
      this.redirectToList();
      this.toastr.success("Brand successfully updated!")
    })
  }

  redirectToList(){
    this.router.navigate(['/listbrands']);
  }

}
