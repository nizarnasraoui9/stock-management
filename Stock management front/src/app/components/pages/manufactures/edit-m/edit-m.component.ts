import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Manufacture } from 'src/app/model/manufacture';
import { ManufacturesService } from 'src/app/services/manufactures.service';

@Component({
  selector: 'app-edit-m',
  templateUrl: './edit-m.component.html',
  styleUrls: ['./edit-m.component.css']
})
export class EditMComponent implements OnInit {

  id!: number;
  manufacture: Manufacture = new Manufacture();


  constructor(
     private manufactureService: ManufacturesService,
    private route: ActivatedRoute,
    private router: Router,
     private toastr: ToastrService) { }

  ngOnInit(): void {

      this.id = this.route.snapshot.params['id'];
      this.manufactureService.findManufactureById(this.id).subscribe(data=>{
        this.manufacture = data;
      });
  }

  editManufacture(){
    this.manufactureService.editManufacture(this.id, this.manufacture).subscribe(data => {
      this.redirectToList();
      this.toastr.success("Manufacture successfully updated!")
    })
  }

  redirectToList(){
    this.router.navigate(['/listmanufactures']);
  }


}
