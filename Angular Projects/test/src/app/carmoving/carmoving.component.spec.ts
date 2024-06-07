import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarmovingComponent } from './carmoving.component';

describe('CarmovingComponent', () => {
  let component: CarmovingComponent;
  let fixture: ComponentFixture<CarmovingComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CarmovingComponent]
    });
    fixture = TestBed.createComponent(CarmovingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
