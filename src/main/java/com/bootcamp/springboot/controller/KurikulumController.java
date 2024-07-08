package com.bootcamp.springboot.controller;

import com.bootcamp.springboot.service.KurikulumService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gedung")
public class KurikulumController {

    private KurikulumService kurikulumService;

    public KurikulumController(KurikulumService kurikulumService){
        this.kurikulumService = kurikulumService;
    }
}
