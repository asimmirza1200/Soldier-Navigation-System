import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AssigndoctorComponent } from './assigndoctor.component';

describe('AssigndoctorComponent', () => {
  let component: AssigndoctorComponent;
  let fixture: ComponentFixture<AssigndoctorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AssigndoctorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AssigndoctorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
