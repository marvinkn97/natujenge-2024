import { Component, inject } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { LoginRequest } from 'src/app/model/login.request';
import { ApiService } from 'src/app/services/api.service';
import { AuthService } from 'src/app/services/auth.service';
import { InputValidationService } from 'src/app/services/validator.service';
import { environment } from 'src/environments/environment.development';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  validator: InputValidationService = inject(InputValidationService);
  loginForm!: FormGroup;
  private router: Router = inject(Router);
  private subscriptions: Subscription = new Subscription();
  private authService: AuthService = inject(AuthService);

  ngOnInit() {
    this.initializeForm();
  }

  initializeForm(): void {
    this.loginForm = new FormGroup({
      username: new FormControl('', [Validators.required]),
      password: new FormControl('', [
        Validators.minLength(4),
        Validators.maxLength(8),
        Validators.required,
      ]),
    });
  }

  onSubmit() {
    const loginRequest: LoginRequest = {
      username: this.loginForm.value.username as string,
      password: this.loginForm.value.password as string,
    };
    this.subscriptions.add(
      this.authService
        .authenticate(environment.AUTH_URL, loginRequest)
        .subscribe({
          next: (response: any) => {
            console.log(response);
          },

          error: (error) => this.showErrorMessage(error),

          complete: () => {},
        })
    );
  }

  showSuccessMessage(message: string) {
    Swal.fire({
      title: 'Success!',
      text: message,
      icon: 'success',
    });
  }

  showErrorMessage(message: string, status?: string) {
    Swal.fire({
      title: status || 'Error!',
      text: message || 'An unexpected error occurred',
      icon: 'error',
    });
  }
}
