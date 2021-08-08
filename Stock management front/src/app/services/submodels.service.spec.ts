import { TestBed } from '@angular/core/testing';

import { SubmodelsService } from './submodels.service';

describe('SubmodelsService', () => {
  let service: SubmodelsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SubmodelsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
