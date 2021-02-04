import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InformationPetComponent } from './information-pet.component';

describe('InformationPetComponent', () => {
  let component: InformationPetComponent;
  let fixture: ComponentFixture<InformationPetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InformationPetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InformationPetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
