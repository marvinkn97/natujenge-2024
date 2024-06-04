package dev.marvin.group_5_mvc.controller;

import dev.marvin.group_5_mvc.model.MathForm;
import dev.marvin.group_5_mvc.service.MathService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller  //similar to @RestController but returns static pages instead of json/xml data
public class MathController {

    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

//    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @GetMapping("/index")
    public String getIndexPage(){
        return "index";  // returns index page
    }

//    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @PostMapping("/add")
    public String add(@ModelAttribute MathForm mathForm, Model model){
        System.out.println(mathForm);
        var result = mathService.add(mathForm);

        //model acts as a dto, it's basically a container to pass data between controller layer and view layer

        model.addAttribute("result", result);
        return "result";
    }


    @GetMapping("/indexJs")
    public String getIndexJSPage(){
        return "indexJs";  // returns indexJs page
    }

//    @RequestMapping(value = "/addJs", method = RequestMethod.POST)
    @PostMapping("/addJs")
    public void add(@RequestBody MathForm mathForm, HttpServletResponse httpServletResponse){
        System.out.println(mathForm);
        var result = mathService.add(mathForm);

        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        httpServletResponse.setStatus(HttpStatus.OK.value());
        try {
            httpServletResponse.getWriter().println(result.intValue());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
