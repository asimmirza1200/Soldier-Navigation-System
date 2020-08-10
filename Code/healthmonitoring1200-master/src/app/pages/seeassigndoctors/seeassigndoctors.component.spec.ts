import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SeeassigndoctorsComponent } from './seeassigndoctors.component';

describe('SeeassigndoctorsComponent', () => {
  let component: SeeassigndoctorsComponent;
  let fixture: ComponentFixture<SeeassigndoctorsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SeeassigndoctorsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SeeassigndoctorsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
