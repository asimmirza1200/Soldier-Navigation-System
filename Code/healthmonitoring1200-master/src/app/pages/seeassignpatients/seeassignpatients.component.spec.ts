import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SeeassignpatientsComponent } from './seeassignpatients.component';

describe('SeeassignpatientsComponent', () => {
  let component: SeeassignpatientsComponent;
  let fixture: ComponentFixture<SeeassignpatientsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SeeassignpatientsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SeeassignpatientsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
