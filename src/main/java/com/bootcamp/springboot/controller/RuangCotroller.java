package com.bootcamp.springboot.controller;

import com.bootcamp.springboot.model.RuangModel;
import com.bootcamp.springboot.service.RuangService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/ruang")
public class RuangCotroller {

    private RuangService ruangService;

    public RuangCotroller(RuangService ruangService) {
        this.ruangService = ruangService;
    }
    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/ruang/index");
        List<RuangModel> result = this.ruangService.getAll();

        view.addObject("index", result);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        return new ModelAndView("pages/ruang/add");
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute RuangModel request){
        this.ruangService.save(request);
        return new ModelAndView("redirect:/ruang");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id){
        RuangModel ruangModel = this.ruangService.getById(id).orElse(null);
        if (ruangModel == null){
            return new ModelAndView("redirect:/ruang");
        }
        ModelAndView view = new ModelAndView("pages/ruang/edit");
        view.addObject("edit", ruangModel);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute RuangModel ruangModel){
        this.ruangService.edit(ruangModel.getId(), ruangModel);
        return new ModelAndView("redirect:/ruang");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id){
        ModelAndView view = new ModelAndView("pages/ruang/delete");
        RuangModel ruangModel = this.ruangService.getById(id).orElse(null);
        if (ruangModel == null){
            return new ModelAndView("redirect:/ruang");
        }
        view.addObject("delete", ruangModel);
        return view;
    }

    @PostMapping("/delete")
    public ModelAndView delete(@ModelAttribute RuangModel ruangModel){
        this.ruangService.delete(ruangModel.getId());
        return new ModelAndView("redirect:/ruang");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") Integer id){
        RuangModel ruangModel = this.ruangService.getById(id).orElse(null);
        if (ruangModel == null){
            return new ModelAndView("redirect:/ruang");
        }
        ModelAndView modelAndView = new ModelAndView("pages/ruang/detail");
        modelAndView.addObject("detail", ruangModel);
        return modelAndView;
    }
}
