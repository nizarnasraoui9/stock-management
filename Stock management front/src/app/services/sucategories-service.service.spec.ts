import { TestBed } from '@angular/core/testing';

import { SucategoriesServiceService } from './sucategories-service.service';

describe('SucategoriesServiceService', () => {
  let service: SucategoriesServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SucategoriesServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
