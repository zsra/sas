import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SummaryClassroomComponent } from './summary-classroom.component';

describe('SummaryClassroomComponent', () => {
  let component: SummaryClassroomComponent;
  let fixture: ComponentFixture<SummaryClassroomComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SummaryClassroomComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SummaryClassroomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
