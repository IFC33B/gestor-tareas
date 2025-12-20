import { TestBed } from '@angular/core/testing';

import { Tasca } from './tasca';

describe('Tasca', () => {
  let service: Tasca;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Tasca);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
