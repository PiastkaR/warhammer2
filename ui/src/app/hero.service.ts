import { Injectable } from '@angular/core';
import { Hero } from './hero';

@Injectable({
  providedIn: 'root'
})
export class HeroService {
private heroesUrl = 'api/heroes';  // URL to web api

  httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };

    constructor(
      private http: HttpClient,
//       private messageService: MessageService
      ) { }

//     private log(message: string) {
//       this.messageService.add(`HeroService: ${message}`);
//     }

  getHeroes(): Observable<Hero[]> {
    return this.http.get<Hero[]>(this.heroesUrl)
//       .pipe(
//         tap(_ => this.log('fetched heroes')),
//         catchError(this.handleError<Hero[]>('getHeroes', []))
      );
  }

    getHero(id: number): Observable<Hero> {
      const url = `${this.heroesUrl}/${id}`;
      return this.http.get<Hero>(url)
//       .pipe(
//         tap(_ => this.log(`fetched hero id=${id}`)),
//         catchError(this.handleError<Hero>(`getHero id=${id}`))
      );
    }

//     private handleError<T>(operation = 'operation', result?: T) {
//       return (error: any): Observable<T> => {
//         console.error(error); // log to console instead
//         this.log(`${operation} failed: ${error.message}`);
//         return of(result as T);
//       };
//     }



}
