import { TestBed, inject } from '@angular/core/testing';

import { FormsHelperService } from './forms-helper.service';

describe('FormsHelperService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FormsHelperService]
    });
  });

  it('should be created', inject([FormsHelperService], (service: FormsHelperService) => {
    expect(service).toBeTruthy();
  }));
});
