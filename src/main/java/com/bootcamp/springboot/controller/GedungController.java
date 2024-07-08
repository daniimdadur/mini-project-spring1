package com.bootcamp.springboot.controller;

import com.bootcamp.springboot.model.GedungModel;
import com.bootcamp.springboot.service.GedungService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/gedung")
public class GedungController {

    private GedungService gedungService;

    public GedungController(GedungService gedungService) {
        this.gedungService = gedungService;
    }

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/gedung/index");
        List<GedungModel> result = this.gedungService.getAll();

        view.addObject("index", result);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        return new ModelAndView("pages/gedung/add");
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute GedungModel gedungModel){
        this.gedungService.save(gedungModel);
        return new ModelAndView("redirect:/gedung");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id){
        GedungModel gedungModel = this.gedungService.getById(id).orElse(null);
        if (gedungModel == null){
            return new ModelAndView("redirect:/gedung");
        }
        ModelAndView view = new ModelAndView("pages/gedung/edit");
        view.addObject("edit", gedungModel);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute GedungModel gedungModel){
        this.gedungService.edit(gedungModel.getId(), gedungModel);
        return new ModelAndView("redirect:/gedung");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id){
        GedungModel gedungModel = this.gedungService.getById(id).orElse(null);
        if (gedungModel == null){
            return new ModelAndView("redirect:/gedung");
        }
        ModelAndView modelAndView = new ModelAndView("pages/gedung/delete");
        modelAndView.addObject("delete", gedungModel);
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView delete(@ModelAttribute GedungModel gedungModel){
        this.gedungService.delete(gedungModel.getId());
        return new ModelAndView("redirect:/gedung");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") Integer id){
        GedungModel gedungModel = this.gedungService.getById(id).orElse(null);
        if (gedungModel == null){
            return new ModelAndView("redirect:/gedung");
        }
        ModelAndView modelAndView = new ModelAndView("pages/gedung/detail");
        modelAndView.addObject("detail", gedungModel);
        return modelAndView;
    }
}
