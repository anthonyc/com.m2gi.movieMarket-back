import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchResultContentComponent } from './search-result-content.component';

describe('SearchResultContentComponent', () => {
  let component: SearchResultContentComponent;
  let fixture: ComponentFixture<SearchResultContentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchResultContentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchResultContentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
