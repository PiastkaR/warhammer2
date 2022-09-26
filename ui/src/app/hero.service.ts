import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';

import { Hero } from './hero';

@Injectable({
  providedIn: 'root'
})
@Injectable({ providedIn: 'root' })
export class HeroService {
private heroUrl = 'http://localhost:8080/api/hero';  // URL to web api
//http://localhost:8080/api/hero?race=ELF&gender=MALE

  httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };

    constructor(
      private http: HttpClient
      ) { }

    /** GET hero from the server */
    getHero(race: string, gender: string): Observable<Hero> {
    const url = `${this.heroUrl}/${race}/${gender}`;
      return this.http.get<Hero>(url)
    }

}
