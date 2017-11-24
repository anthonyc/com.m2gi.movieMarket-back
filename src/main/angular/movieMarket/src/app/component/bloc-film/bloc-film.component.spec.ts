import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BlocFilmComponent } from './bloc-film.component';

describe('BlocFilmComponent', () => {
  let component: BlocFilmComponent;
  let fixture: ComponentFixture<BlocFilmComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BlocFilmComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BlocFilmComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
