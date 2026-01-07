import { TestBed } from '@angular/core/testing';

import { TascaModel } from './tasca.model';

describe('TascaModel', () => {
  let service: TascaModel;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TascaModel);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
