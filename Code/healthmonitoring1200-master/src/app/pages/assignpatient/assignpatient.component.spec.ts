import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AssignpatientComponent } from './assignpatient.component';

describe('AssignpatientComponent', () => {
  let component: AssignpatientComponent;
  let fixture: ComponentFixture<AssignpatientComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AssignpatientComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AssignpatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
