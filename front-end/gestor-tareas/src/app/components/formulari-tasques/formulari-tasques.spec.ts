import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormulariTasques } from './formulari-tasques';

describe('FormulariTasques', () => {
  let component: FormulariTasques;
  let fixture: ComponentFixture<FormulariTasques>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormulariTasques]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormulariTasques);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
