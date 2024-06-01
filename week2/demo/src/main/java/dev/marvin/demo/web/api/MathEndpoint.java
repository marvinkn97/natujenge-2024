package dev.marvin.demo.web.api;

import dev.marvin.demo.dto.MathRequestDTO;
import dev.marvin.demo.service.IMathService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/calculate")
@AllArgsConstructor
public class MathEndpoint {

    private final IMathService mathService;

    @PostMapping("/add")
    public Integer add(@RequestBody MathRequestDTO mathRequestDTO){
        return mathService.add(mathRequestDTO);
    }

    @PostMapping("/subtract")
    public Integer subtract(@RequestBody MathRequestDTO mathRequestDTO){
        return mathService.subtract(mathRequestDTO);
    }

    @PostMapping("/multiply")
    public Integer multiply(@RequestBody MathRequestDTO mathRequestDTO){
        return mathService.multiply(mathRequestDTO);
    }

}
