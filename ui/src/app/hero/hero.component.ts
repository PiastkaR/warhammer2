import { Component, OnInit } from '@angular/core';
import { Hero } from '../hero';

@Component({
  selector: 'app-hero',
  templateUrl: './hero.component.html',
  styleUrls: ['./hero.component.css']
})
export class HeroComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

    races = ['Human', 'Dwarf','Elf', 'Halfling'];
    genders = ['Male', 'Female'];

    model = new Hero('Rafal', this.races[0],  this.genders[0]);

    submitted = false;

    onSubmit() { this.submitted = true; }

}
