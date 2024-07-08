package com.bootcamp.springboot.controller;

import com.bootcamp.springboot.model.SekolahModel;
import com.bootcamp.springboot.service.SekolahService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/sekolah")
public class SekolahController {

    private SekolahService sekolahService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/sekolah/index");
        List<SekolahModel> result = this.sekolahService.getAll();

        view.addObject("index", result);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        return new ModelAndView("pages/sekolah/add");
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute SekolahModel sekolahModel){
        this.sekolahService.save(sekolahModel);
        return new ModelAndView("redirect:/sekolah");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id){
        SekolahModel sekolahModel = this.sekolahService.getById(id).orElse(null);
        if (sekolahModel == null){
            return new ModelAndView("redirect:/sekolah");
        }
        ModelAndView view = new ModelAndView("pages/sekolah/edit");
        view.addObject("edit", sekolahModel);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute SekolahModel sekolahModel){
        this.sekolahService.update(sekolahModel.getId(), sekolahModel);
        return new ModelAndView("redirect:/sekolah");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id){
        SekolahModel sekolahModel = this.sekolahService.getById(id).orElse(null);
        if (sekolahModel == null){
            return new ModelAndView("redirect:/sekolah");
        }
        ModelAndView modelAndView = new ModelAndView("pages/sekolah/delete");
        modelAndView.addObject("delete", sekolahModel);
        return modelAndView;
    }

    @PostMapping("delete")
    public ModelAndView delete(@ModelAttribute SekolahModel sekolahModel){
        this.sekolahService.delete(sekolahModel.getId());
        return new ModelAndView("redirect:/sekolah");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") Integer id){
        SekolahModel sekolahModel = this.sekolahService.getById(id).orElse(null);
        if (sekolahModel == null){
            return new ModelAndView("redirect:/sekolah");
        }
        ModelAndView modelAndView = new ModelAndView("pages/sekolah/detail");
        modelAndView.addObject("detail", sekolahModel);
        return modelAndView;
    }
}
