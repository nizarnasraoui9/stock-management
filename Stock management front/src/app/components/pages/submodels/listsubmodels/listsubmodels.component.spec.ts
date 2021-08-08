import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListsubmodelsComponent } from './listsubmodels.component';

describe('ListsubmodelsComponent', () => {
  let component: ListsubmodelsComponent;
  let fixture: ComponentFixture<ListsubmodelsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListsubmodelsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListsubmodelsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
