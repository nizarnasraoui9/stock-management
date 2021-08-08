import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditenginesComponent } from './editengines.component';

describe('EditenginesComponent', () => {
  let component: EditenginesComponent;
  let fixture: ComponentFixture<EditenginesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditenginesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditenginesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
