import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormulariTasca } from './formulari-tasca';

describe('FormulariTasca', () => {
  let component: FormulariTasca;
  let fixture: ComponentFixture<FormulariTasca>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormulariTasca]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormulariTasca);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
