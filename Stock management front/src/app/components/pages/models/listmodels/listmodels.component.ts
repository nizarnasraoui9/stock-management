import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Model } from 'src/app/model/model';
import { ModelsService } from 'src/app/services/models.service';

@Component({
  selector: 'app-listmodels',
  templateUrl: './listmodels.component.html',
  styleUrls: ['./listmodels.component.css']
})
export class ListmodelsComponent implements OnInit {

  Models: Model[] = [];
  currentModel?: Model;
  page: number = 1;
  totalItems!: number;
  name = '';

  constructor(
    private modelsService: ModelsService,
    private toastr: ToastrService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getModels();
  }

  getModels() {
    this.modelsService.getAllModels().subscribe(data => {
      if(data != null){
        this.Models = data;
        this.totalItems = data.length;
      }
    }, error => {
    });
  }

  deleteModel(id: number) {
    this.modelsService.deleteModel(id).subscribe(data => {
      this.toastr.warning("Model succesfully deleted!")
      this.getModels();
      this.router.navigate(['listmodels']);

    }, error => {
      this.toastr.error("Error!")
      console.log(error)
    })
  }

  searchTitle(): void {
    if (this.name != "") {
      this.currentModel = undefined;
      this.modelsService.findByTitle(this.name).subscribe(data => {
        this.Models = data;
        this.totalItems = data.length;
        console.log(data);
      },
      error => {
        this.toastr.warning("Error!"+ error.message);
      });
    }else{
      this.getModels();
    }

  }

  updateModel(id: number){
    this.router.navigate(['editmodel', id]);
  }








}

