import { TestBed } from '@angular/core/testing';

import { ManufacturesService } from './manufactures.service';

describe('ManufacturesService', () => {
  let service: ManufacturesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ManufacturesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
