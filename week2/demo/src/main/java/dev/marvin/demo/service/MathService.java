package dev.marvin.demo.service;

import dev.marvin.demo.dto.MathRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class MathService implements IMathService {
    @Override
    public Integer add(MathRequestDTO mathRequestDTO) {
        int num1 = mathRequestDTO.getNum1();
        int num2 = mathRequestDTO.getNum2();

        return num1 + num2;
    }

    @Override
    public Integer subtract(MathRequestDTO mathRequestDTO) {
        int num1 = mathRequestDTO.getNum1();
        int num2 = mathRequestDTO.getNum2();

        return num1 - num2;
    }

    @Override
    public Integer multiply(MathRequestDTO mathRequestDTO) {
        int num1 = mathRequestDTO.getNum1();
        int num2 = mathRequestDTO.getNum2();

        return num1 * num2;
    }

    @Override
    public Integer divide(MathRequestDTO mathRequestDTO) {
        int num1 = mathRequestDTO.getNum1();
        int num2 = mathRequestDTO.getNum2();

        return num1 / num2;
    }

    @Override
    public Integer remainder(MathRequestDTO mathRequestDTO) {
        int num1 = mathRequestDTO.getNum1();
        int num2 = mathRequestDTO.getNum2();

        return num1 % num2;

    }
}
