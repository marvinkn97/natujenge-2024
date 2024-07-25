import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RegistrationRequest } from '../model/registration.request';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WalletService {

  private WALLET_URL = 'http://localhost:8080/wallet';

  constructor(private http: HttpClient) {}


  register(request: RegistrationRequest): Observable<any> {
    return this.http.post<any>(this.WALLET_URL, request);
  }
}
