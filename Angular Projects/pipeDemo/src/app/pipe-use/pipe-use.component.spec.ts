import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PipeUseComponent } from './pipe-use.component';

describe('PipeUseComponent', () => {
  let component: PipeUseComponent;
  let fixture: ComponentFixture<PipeUseComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PipeUseComponent]
    });
    fixture = TestBed.createComponent(PipeUseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
