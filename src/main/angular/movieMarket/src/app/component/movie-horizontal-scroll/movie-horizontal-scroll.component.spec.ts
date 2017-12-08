import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieHorizontalScrollComponent } from './movie-horizontal-scroll.component';

describe('MovieHorizontalScrollComponent', () => {
  let component: MovieHorizontalScrollComponent;
  let fixture: ComponentFixture<MovieHorizontalScrollComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MovieHorizontalScrollComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MovieHorizontalScrollComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
