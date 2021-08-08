import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatesubsubcategoriesComponent } from './createsubsubcategories.component';

describe('CreatesubsubcategoriesComponent', () => {
  let component: CreatesubsubcategoriesComponent;
  let fixture: ComponentFixture<CreatesubsubcategoriesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreatesubsubcategoriesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreatesubsubcategoriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
