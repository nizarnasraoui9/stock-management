import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditsubsubcategoriesComponent } from './editsubsubcategories.component';

describe('EditsubsubcategoriesComponent', () => {
  let component: EditsubsubcategoriesComponent;
  let fixture: ComponentFixture<EditsubsubcategoriesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditsubsubcategoriesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditsubsubcategoriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
