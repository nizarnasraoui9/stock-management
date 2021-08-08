import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateengineComponent } from './createengine.component';

describe('CreateengineComponent', () => {
  let component: CreateengineComponent;
  let fixture: ComponentFixture<CreateengineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateengineComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateengineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
