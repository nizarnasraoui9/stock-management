import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Engine } from 'src/app/model/engine';
import { EnginesService } from 'src/app/services/engines.service';

@Component({
  selector: 'app-listengines',
  templateUrl: './listengines.component.html',
  styleUrls: ['./listengines.component.css']
})
export class ListenginesComponent implements OnInit {

  Engines: Engine[] = [];
  currentEngine?: Engine;
  page: number = 1;
  totalItems!: number;
  name = '';

  constructor(
    private enginesService: EnginesService,
    private toastr: ToastrService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getEngines();
  }

  getEngines() {
    this.enginesService.getAllEngines().subscribe(data => {
      if(data != null){
        this.Engines = data;
        this.totalItems = data.length;
      }
    }, error => {
    });
  }

  deleteEngine(id: number) {
    this.enginesService.deleteEngine(id).subscribe(data => {
      this.toastr.warning("Engine succesfully deleted!")
      this.getEngines();
      this.router.navigate(['listengines']);

    }, error => {
      this.toastr.error("Error!")
      console.log(error)
    })
  }

  searchTitle(): void {
    if (this.name != "") {
      this.currentEngine = undefined;
      this.enginesService.findByName(this.name).subscribe(data => {
        this.Engines = data;
        this.totalItems = data.length;
        console.log(data);
      },
      error => {
        this.toastr.warning("Error!"+ error.message);
      });
    }else{
      this.getEngines();
    }

  }

  updateEngine(id: number){
    this.router.navigate(['editengine', id]);
  }








}

