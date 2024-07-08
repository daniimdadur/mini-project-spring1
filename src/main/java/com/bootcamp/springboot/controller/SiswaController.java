package com.bootcamp.springboot.controller;
import com.bootcamp.springboot.model.SiswaModel;
import com.bootcamp.springboot.service.SiswaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/siswa")
public class SiswaController {

    private SiswaService siswaService;

    public SiswaController(SiswaService siswaService) {
        this.siswaService = siswaService;
    }

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/siswa/index");
        List<SiswaModel> result = this.siswaService.getAll();

        view.addObject("data",result);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        return new ModelAndView("pages/siswa/add");
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute SiswaModel request){
        this.siswaService.save(request);
        return new ModelAndView("redirect:/siswa");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id")Integer id){
        SiswaModel siswaModel = this.siswaService.getById(id).orElse(null);
        if (siswaModel == null){
            return new ModelAndView("redirect:/siswa");
        }
        ModelAndView view = new ModelAndView("pages/siswa/edit");
        view.addObject("siswa",siswaModel);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute SiswaModel siswaModel){
        this.siswaService.update(siswaModel,siswaModel.getId());
        return new ModelAndView("redirect:/siswa");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id")Integer id){
        SiswaModel siswaModel = this.siswaService.getById(id).orElse(null);
            if (siswaModel == null){
                return new ModelAndView("redirect:/siswa");
            }
            this.siswaService.delete(id);
            return new ModelAndView("redirect:/siswa");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") Integer id){
        SiswaModel siswaModel = this.siswaService.getById(id).orElse(null);
        if (siswaModel == null){
            return new ModelAndView("redirect:/orang");
        }
        ModelAndView view = new ModelAndView("pages/siswa/detail");
        view.addObject("siswa",siswaModel);
        return view;
    }
}
