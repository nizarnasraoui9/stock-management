import { TestBed } from '@angular/core/testing';

import { SubsubcategoriesService } from './subsubcategories.service';

describe('SubsubcategoriesService', () => {
  let service: SubsubcategoriesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SubsubcategoriesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
