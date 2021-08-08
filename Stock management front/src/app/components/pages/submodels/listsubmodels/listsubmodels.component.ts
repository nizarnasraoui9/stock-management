import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Submodel } from 'src/app/model/submodel';
import { SubmodelsService } from 'src/app/services/submodels.service';

@Component({
  selector: 'app-listsubmodels',
  templateUrl: './listsubmodels.component.html',
  styleUrls: ['./listsubmodels.component.css']
})
export class ListsubmodelsComponent implements OnInit {

  subModels: Submodel[] = [];
  currentSubModel?: Submodel;
  page: number = 1;
  totalItems!: number;
  name = '';

  constructor(
    private submodelsService: SubmodelsService,
    private toastr: ToastrService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getSubModels();
  }

  getSubModels() {
    this.submodelsService.getAllSubModels().subscribe(data => {
      if (data != null) {
        this.subModels = data;
        this.totalItems = data.length;
      }
    }, error => {
      console.log(error)
    });
  }

  deleteSubModel(id: number) {
    this.submodelsService.deleteSubModel(id).subscribe(data => {
      this.toastr.warning("Submodel succesfully deleted!")
      this.getSubModels()
      this.router.navigate(['/listsubmodels'])
    }, error => {
      console.log(error);
    })
  }

  searchTitle(): void {
    if (this.name != "") {
      this.currentSubModel = undefined;
      this.submodelsService.findByTitle(this.name).subscribe(data => {
        this.subModels = data;
        this.totalItems = data.length;
        console.log(data);
      },
        error => {
          console.log(error)
        });
    } else {
      this.getSubModels();
    }

  }

  updateSubModel(id: number) {
    this.router.navigate(['editsubmodel', id]);
  }

}



