import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Model } from 'src/app/model/model';
import { Submodel } from 'src/app/model/submodel';
import { ModelsService } from 'src/app/services/models.service';
import { SubmodelsService } from 'src/app/services/submodels.service';

@Component({
  selector: 'app-createsubmodels',
  templateUrl: './createsubmodels.component.html',
  styleUrls: ['./createsubmodels.component.css']
})
export class CreatesubmodelsComponent implements OnInit {

  submodel: Submodel = new Submodel();
  models!: Model[];
  modelSelected!: number;
  model!: Model;

  constructor(
    private submodelsService: SubmodelsService,
    private modelsService: ModelsService,
    private router: Router,
    private toastr: ToastrService
  ) { }

  ngOnInit(): void {
    this.getModels();
  }


  createSubModel() {

    this.submodel.model = this.model

    console.log(this.submodel)

    this.submodelsService.createSubModel(this.submodel).subscribe(data => {

      this.submodel = data;

      console.log(this.submodel)

      this.redirectToList();
      this.toastr.success("Submodel successfully created!")
    },

    error => {
     this.toastr.error("Error!" + error.message)
    });

  }
  redirectToList() {
    this.router.navigate(['/listsubmodels'])
  }

  getModels() {
    this.modelsService.getAllModels().subscribe(data => {
      this.models = data;
    }, error => {
      this.toastr.error("Error!" + error.message)
    });
  }

  getModelSelected(id: number) {
    console.log(id)
    this.modelsService.findModelById(id).subscribe(data => {
      this.model = data;
      console.log(this.model);
    });
  }

}






