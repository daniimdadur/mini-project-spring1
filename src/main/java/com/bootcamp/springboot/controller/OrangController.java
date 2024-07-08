package com.bootcamp.springboot.controller;

import com.bootcamp.springboot.model.OrangModel;
import com.bootcamp.springboot.service.OrangService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orang")
public class OrangController {

    private OrangService orangService;

    public OrangController(OrangService orangService) {
        this.orangService = orangService;
    }

    @GetMapping
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("pages/orang/index");
        List<OrangModel> result = this.orangService.getAll();

        view.addObject("data", result);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add() {
        return new ModelAndView("pages/orang/add");
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute OrangModel request) {
        this.orangService.save(request);
        return new ModelAndView("redirect:/orang");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id) {
        OrangModel orangModel = this.orangService.getById(id).orElse(null);
        if (orangModel == null) {
            return new ModelAndView("redirect:/orang");
        }
        ModelAndView view = new ModelAndView("pages/orang/edit");
        view.addObject("orang", orangModel);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute OrangModel orangModel) {
        this.orangService.update(orangModel, orangModel.getId());
        return new ModelAndView("redirect:/orang");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id) {
        OrangModel orangModel = orangService.getById(id).orElse(null);
        if (orangModel == null) {
            return new ModelAndView("redirect:/orang");
        }
        this.orangService.delete(id);
        return new ModelAndView("redirect:/orang");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") Integer id) {
        OrangModel orangModel = orangService.getById(id).orElse(null);
        if (orangModel == null) {
            return new ModelAndView("redirect:/orang");
        }
        ModelAndView view = new ModelAndView("pages/orang/detail");
        view.addObject("orang", orangModel);
        return view;
    }
}
