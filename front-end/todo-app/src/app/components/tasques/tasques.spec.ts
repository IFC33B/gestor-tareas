import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Tasques } from './tasques';

describe('Tasques', () => {
  let component: Tasques;
  let fixture: ComponentFixture<Tasques>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Tasques]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Tasques);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
