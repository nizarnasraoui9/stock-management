import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Manufacture } from 'src/app/model/manufacture';
import { ManufacturesService } from 'src/app/services/manufactures.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  manufacture!:Manufacture;
  Manufactures: Manufacture[] = [];
  currentManufacture?: Manufacture;
  page: number = 1;
  totalItems!: number;
  name = '';
  //host=window.location.origin;
  host="http://127.0.0.1";



  constructor(
    private manufacturesService: ManufacturesService,
    private toastr: ToastrService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getManufactures();
  }

  getManufactures() {
    this.manufacturesService.getAllManufactures().subscribe(data => {
      if(data != null){
        this.Manufactures = data;
        this.totalItems = data.length;
        this.Manufactures.forEach(manufacture=>{
          manufacture.photoPath=this.host+manufacture.photoPath;
        });
        this.Manufactures.forEach(element=>{
          console.log(element);



        });
      }
    }, error => {
    });
  }

  deleteManufacture(id: number) {
    this.manufacturesService.deleteManufacture(id).subscribe(data => {
      this.toastr.warning("Manufacture succesfully deleted!")
      this.getManufactures();
      this.router.navigate(['listmanufactures']);

    }, error => {
      this.toastr.error("Error!")
      console.log(error)
    })
  }

  searchTitle(): void {
    if (this.name != "") {
      this.currentManufacture = undefined;
      this.manufacturesService.findByName(this.name).subscribe(data => {
        this.Manufactures = data;
        this.totalItems = data.length;
        console.log(data);
      },
      error => {
        this.toastr.warning("Error!"+ error.message);
      });
    }else{
      this.getManufactures();
    }

  }

  updateManufacture(id: number){
    this.router.navigate(['editmanufacture', id]);
  }








}



