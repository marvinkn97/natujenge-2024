package dev.marvin.demo.service;

import dev.marvin.demo.dto.MathRequestDTO;

public interface IMathService {

    Integer add(MathRequestDTO mathRequestDTO);
    Integer subtract(MathRequestDTO mathRequestDTO);
    Integer multiply(MathRequestDTO mathRequestDTO);
    Integer divide(MathRequestDTO mathRequestDTO);
    Integer remainder(MathRequestDTO mathRequestDTO);

}
