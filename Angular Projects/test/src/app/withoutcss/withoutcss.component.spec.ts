import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WithoutcssComponent } from './withoutcss.component';

describe('WithoutcssComponent', () => {
  let component: WithoutcssComponent;
  let fixture: ComponentFixture<WithoutcssComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [WithoutcssComponent]
    });
    fixture = TestBed.createComponent(WithoutcssComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
