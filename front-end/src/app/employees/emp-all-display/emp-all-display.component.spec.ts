import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpAllDisplayComponent } from './emp-all-display.component';

describe('EmpAllDisplayComponent', () => {
  let component: EmpAllDisplayComponent;
  let fixture: ComponentFixture<EmpAllDisplayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmpAllDisplayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmpAllDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
