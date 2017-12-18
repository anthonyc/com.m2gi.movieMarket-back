import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StoreButtonComponentComponent } from './store-button-component.component';

describe('StoreButtonComponentComponent', () => {
  let component: StoreButtonComponentComponent;
  let fixture: ComponentFixture<StoreButtonComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StoreButtonComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StoreButtonComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
