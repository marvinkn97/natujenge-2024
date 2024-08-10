import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Route, Router } from '@angular/router';
import { Observable, catchError, map, of, tap } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private http: HttpClient, private router: Router) {}

  authenticate(uri: string, data: any): Observable<string> {
    return this.http.post<any>(uri, data).pipe(
      tap(response => {
        if (response && response.payload.token) {
         this.storeToken(response.payload.token); 
         this.router.navigateByUrl('/dashboard');
        }
      }),
      catchError(error => {
        console.error('Authentication error:', error);
        return of('Authentication failed. Please try again.');
      })
    );
  }

  // Method to store the token
  storeToken(token: string): void {
    localStorage.setItem("token", token);
  }

  // Method to retrieve the token
  getToken(token: string): string | null {
    return localStorage.getItem(token);
  }

  // Method to clear the token
  clearToken(token: string): void {
    localStorage.removeItem(token);
  }

}
