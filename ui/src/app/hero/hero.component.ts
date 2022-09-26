import { Component, OnInit } from '@angular/core';
import { Hero } from '../hero';
import { HeroService } from '../hero.service';

@Component({
  selector: 'app-hero',
  templateUrl: './hero.component.html',
  styleUrls: ['./hero.component.css']
})
export class HeroComponent implements OnInit {

  constructor(private heroService: HeroService) { }
  hero: Hero;

   ngOnInit(): void {
     this.getHero();
   }

    races = ['Human', 'Dwarf','Elf', 'Halfling'];
    genders = ['Male', 'Female'];

//     model = new Hero('Rafal', this.races[0],  this.genders[0]);

  getHeroes(): void {
    this.heroService.getHero()
    .subscribe(hero => this.hero = hero);
  }

    submitted = false;

    onSubmit() { this.submitted = true; }

}
