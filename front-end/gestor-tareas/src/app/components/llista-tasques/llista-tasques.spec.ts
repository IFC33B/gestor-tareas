import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LlistaTasques } from './llista-tasques';

describe('LlistaTasques', () => {
  let component: LlistaTasques;
  let fixture: ComponentFixture<LlistaTasques>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LlistaTasques]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LlistaTasques);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
