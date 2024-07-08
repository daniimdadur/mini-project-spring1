package com.bootcamp.springboot.controller;

import com.bootcamp.springboot.model.GuruModel;
import com.bootcamp.springboot.service.GuruService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/guru")
public class GuruController {

    private GuruService guruService;

    public GuruController(GuruService guruService) {
        this.guruService = guruService;
    }

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/guru/index");
        List<GuruModel> result = this.guruService.getAll();

        view.addObject("data", result);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        return new ModelAndView("pages/guru/add");
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute GuruModel guruModel){
        this.guruService.save(guruModel);
        return new ModelAndView("redirect:/guru");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id){
        GuruModel guruModel = this.guruService.getById(id).orElse(null);
        if (guruModel == null){
            return new ModelAndView("redirect:/guru");
        }
        ModelAndView view = new ModelAndView("pages/guru/update");
        view.addObject("update",guruModel);
        return view;
    }

    @PostMapping("update")
    public ModelAndView update(@ModelAttribute GuruModel guruModel){
        this.guruService.update(guruModel.getId(), guruModel);
        return new ModelAndView("redirect:/guru");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id){
        GuruModel guruModel = this.guruService.getById(id).orElse(null);
        if (guruModel == null){
            return new ModelAndView("redirect:/guru");
        }
        this.guruService.delete(id);
        return new ModelAndView("redirect:/guru");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") Integer id){
        GuruModel guruModel = this.guruService.getById(id).orElse(null);
        if (guruModel == null){
            return new ModelAndView("redirect:/guru");
        }
        ModelAndView view = new ModelAndView("pages/guru/detail");
        view.addObject("detail", guruModel);
        return view;
    }
}
