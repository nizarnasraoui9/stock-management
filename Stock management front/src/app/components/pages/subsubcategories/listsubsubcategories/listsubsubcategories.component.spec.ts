import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListsubsubcategoriesComponent } from './listsubsubcategories.component';

describe('ListsubsubcategoriesComponent', () => {
  let component: ListsubsubcategoriesComponent;
  let fixture: ComponentFixture<ListsubsubcategoriesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListsubsubcategoriesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListsubsubcategoriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
