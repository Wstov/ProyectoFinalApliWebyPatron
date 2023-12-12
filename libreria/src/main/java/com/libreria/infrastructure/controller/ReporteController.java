/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.infrastructure.controller;

import com.libreria.infrastructure.adapter.ReportRepository;
import java.io.IOException;
import org.apache.logging.log4j.message.ParameterConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Wstov
 */
@Controller
@RequestMapping("/reportes")
public class ReporteController {
    
    @Autowired
    ReportRepository reportService;
    
    @GetMapping("/principal")
    public String principal(Model model){
        return "/reportes/principal";
    
   }
    
    @GetMapping("/usuarios")
    public ResponseEntity<Resource> usuarios(@RequestParam String tipo) throws IOException {
        return reportService.getReport("user", null, tipo);
    }
}
