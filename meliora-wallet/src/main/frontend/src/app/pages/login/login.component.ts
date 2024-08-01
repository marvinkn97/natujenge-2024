import { Component, inject } from '@angular/core';
import { InputValidationService } from 'src/app/services/validator.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  validator: InputValidationService = inject(InputValidationService);
}
