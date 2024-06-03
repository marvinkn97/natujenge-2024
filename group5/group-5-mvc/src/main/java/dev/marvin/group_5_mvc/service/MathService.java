package dev.marvin.group_5_mvc.service;

import dev.marvin.group_5_mvc.model.MathForm;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    public Integer add(MathForm mathForm){
        return mathForm.getNum1() + mathForm.getNum2();
    }
}
