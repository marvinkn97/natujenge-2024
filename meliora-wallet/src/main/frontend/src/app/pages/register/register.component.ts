import { Component, inject } from '@angular/core';
import {
  AbstractControl,
  FormBuilder,
  FormControl,
  FormGroup,
  ValidatorFn,
  Validators,
} from '@angular/forms';
import { RegistrationRequest } from 'src/app/model/registration.request';
import { WalletService } from 'src/app/services/wallet.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent {
  registrationForm!: FormGroup;

  private walletService: WalletService = inject(WalletService);

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
        validators: this.passwordMatchValidator, // Custom validator function
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
    this.walletService.register(registrationRequest).subscribe({
      next: (response) => {
        console.log(response);
      },
      error: (error) => console.log(error),
      complete: () => console.log('complete'),
    });
  }
}
