import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Brand } from 'src/app/model/brand';
import { Engine } from 'src/app/model/engine';
import { BrandService } from 'src/app/services/brand.service';
import { EnginesService } from 'src/app/services/engines.service';

@Component({
  selector: 'app-editengines',
  templateUrl: './editengines.component.html',
  styleUrls: ['./editengines.component.css']
})
export class EditenginesComponent implements OnInit {

  id!: number;
  engine: Engine = new Engine();


  brand!:Brand;
  brands!: Brand[];
  brandSelected!:number;





  constructor(


    private brandsService: BrandService,

    private enginesService: EnginesService,
    private route: ActivatedRoute,
    private router: Router,
     private toastr: ToastrService
  ) { }

  ngOnInit(): void {
    this.getBrands();

    this.id = this.route.snapshot.params['id'];
    this.enginesService.findEngineById(this.id).subscribe(data=>{
      this.engine = data;
    });
  }

  editEngine(){

    this.engine.brand = this.brand

    console.log(this.engine)

    this.enginesService.createEngine(this.engine).subscribe(data => {

      this.engine = data;

      console.log(this.engine)

    //this.subcategoryService.editSubCategory(this.id, this.subcategory).subscribe(data => {
      this.redirectToList();
      this.toastr.success("Engine successfully updated!")
    })
  }

  redirectToList(){
    this.router.navigate(['/listengines']);
  }















  getBrandChanged(id: number) {
    console.log(id)
    this.brandsService.findBrandById(id).subscribe(data => {
      this.brand = data;
      console.log(this.brand);
    });
  }

  getBrands() {
    this.brandsService.getAllBrands().subscribe(data => {
      this.brands = data;
    }, error => {
      this.toastr.error("Error!" + error.message)
    });
}
}
