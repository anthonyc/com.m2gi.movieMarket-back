import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArianeComponent } from './ariane.component';

describe('ArianeComponent', () => {
  let component: ArianeComponent;
  let fixture: ComponentFixture<ArianeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArianeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArianeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
