import { Injectable } from '@angular/core';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root',
})
export class InputValidationService {
  constructor() {}

  isMaliciousChar(event: KeyboardEvent): boolean {
    const inputElement = event.target as HTMLInputElement;
    const charStr = event.key;
    let forbiddenChars = /[!@#+$%^&*(),.?":{}|<=>\/\\[\];'`~]/;

    if (inputElement.type === 'email') {
      forbiddenChars = /[!#+$%^&*(),?":{}|<=>\/\\[\];'`~]/;
    }

    if (forbiddenChars.test(charStr)) {
      Swal.fire({
        icon: 'error',
        text: 'Special characters not allowed',
      });
      event.preventDefault(); // Prevent the character from being added to the input
      return false;
    }
    return true;
  }
}
