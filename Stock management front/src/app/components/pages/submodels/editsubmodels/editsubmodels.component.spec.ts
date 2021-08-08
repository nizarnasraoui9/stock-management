import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditsubmodelsComponent } from './editsubmodels.component';

describe('EditsubmodelsComponent', () => {
  let component: EditsubmodelsComponent;
  let fixture: ComponentFixture<EditsubmodelsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditsubmodelsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditsubmodelsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
