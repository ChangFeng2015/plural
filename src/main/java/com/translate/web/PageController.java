package com.translate.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * dispachar the page
 *
 * @Autor:Dave
 * @Create:2017-09-27 22:27
 */
@RestController
public class PageController {

    @GetMapping("/save")
    public ModelAndView save(){
        return new ModelAndView("save");
    }

    @GetMapping("/translate")
    public ModelAndView translate(){
        return new ModelAndView("translate");
    }
}
