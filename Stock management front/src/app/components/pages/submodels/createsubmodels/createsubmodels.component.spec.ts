import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatesubmodelsComponent } from './createsubmodels.component';

describe('CreatesubmodelsComponent', () => {
  let component: CreatesubmodelsComponent;
  let fixture: ComponentFixture<CreatesubmodelsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreatesubmodelsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreatesubmodelsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
