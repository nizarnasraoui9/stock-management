import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListenginesComponent } from './listengines.component';

describe('ListenginesComponent', () => {
  let component: ListenginesComponent;
  let fixture: ComponentFixture<ListenginesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListenginesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListenginesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
