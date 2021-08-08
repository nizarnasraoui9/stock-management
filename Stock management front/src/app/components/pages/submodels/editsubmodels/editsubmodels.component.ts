import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Submodel } from 'src/app/model/submodel';
import { SubmodelsService } from 'src/app/services/submodels.service';

@Component({
  selector: 'app-editsubmodels',
  templateUrl: './editsubmodels.component.html',
  styleUrls: ['./editsubmodels.component.css']
})
export class EditsubmodelsComponent implements OnInit {

  id!: number;
  submodel: Submodel = new Submodel();

  constructor(
    private submodelsService: SubmodelsService,
    private route: ActivatedRoute,
    private router: Router,
     private toastr: ToastrService
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.submodelsService.findSubModelById(this.id).subscribe(data=>{
      this.submodel = data;
    });
  }

  editSubModel(){
    this.submodelsService.editSubModel(this.id, this.submodel).subscribe(data => {
      this.redirectToList();
      this.toastr.success("Submodel successfully updated!")
    })
  }

  redirectToList(){
    this.router.navigate(['/listsubmodels']);
  }

}

