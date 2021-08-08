import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Model } from 'src/app/model/model';
import { ModelsService } from 'src/app/services/models.service';

@Component({
  selector: 'app-editmodel',
  templateUrl: './editmodel.component.html',
  styleUrls: ['./editmodel.component.css']
})
export class EditmodelComponent implements OnInit {
  id!: number;
  model: Model = new Model();

  constructor(private modelsService: ModelsService,
    private route: ActivatedRoute,
    private router: Router,
     private toastr: ToastrService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.modelsService.findModelById(this.id).subscribe(data=>{
      this.model = data;
    });
  }

  editModel(){
    this.modelsService.editModel(this.id, this.model).subscribe(data => {
      this.redirectToList();
      this.toastr.success("Model successfully updated!")
    })
  }

  redirectToList(){
    this.router.navigate(['/listmodels']);
  }

}

