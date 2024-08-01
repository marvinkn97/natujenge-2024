import { ApiService } from './../../services/api.service';
import { Component, inject } from '@angular/core';
import {
  AbstractControl,
  FormControl,
  FormGroup,
  ValidatorFn,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { RegistrationRequest } from 'src/app/model/registration.request';
import { InputValidationService } from 'src/app/services/validator.service';
import { environment } from 'src/environments/environment.development';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent {
  registrationForm!: FormGroup;

  private apiService: ApiService = inject(ApiService);
  validator: InputValidationService = inject(InputValidationService);
  private router: Router = inject(Router);

  ngOnInit() {
    this.initializeForm();
  }

  initializeForm(): void {
    this.registrationForm = new FormGroup(
      {
        username: new FormControl('', [Validators.required]),
        fullName: new FormControl('', [Validators.required]),
        phoneNumber: new FormControl('', [
          Validators.required,
          Validators.pattern('^254[0-9]{9}$'),
        ]),
        password: new FormControl('', [
          Validators.minLength(4),
          Validators.maxLength(8),
          Validators.required,
        ]),
        confirmPassword: new FormControl('', Validators.required),
      },
      {
        validators: this.passwordMatchValidator,
      }
    );
  }

  passwordMatchValidator: ValidatorFn = (
    control: AbstractControl
  ): { [key: string]: any } | null => {
    const password = control.get('password');
    const confirmPassword = control.get('confirmPassword');

    if (
      password &&
      confirmPassword &&
      password.value !== confirmPassword.value
    ) {
      confirmPassword.setErrors({ passwordMismatch: true });
      return { passwordMismatch: true };
    } else {
      confirmPassword?.setErrors(null);
      return null;
    }
  };

  onSubmit() {
    const registrationRequest: RegistrationRequest = {
      username: this.registrationForm.value.username as string,
      fullName: this.registrationForm.value.fullName as string,
      phoneNumber: this.registrationForm.value.phoneNumber as string,
      password: this.registrationForm.value.password as string,
    };

    console.log(registrationRequest);

    this.apiService
      .postData(environment.WALLET_URL, registrationRequest)
      .subscribe({
        next: (response: any) => this.showSuccessMessage(response.payload),
        error: (error) =>
          this.showErrorMessage(error.error.status, error.error.payload),
        complete: () => {
          this.router.navigateByUrl('/dashboard');
        },
      });
  }

  showSuccessMessage(message: string) {
    Swal.fire({
      title: 'Success!',
      text: message,
      icon: 'success',
    });
  }

  showErrorMessage(status: string, message: string) {
    Swal.fire({
      title: status || 'Error!',
      text: message || 'An unexpected error occurred',
      icon: 'error',
    });
  }
}
