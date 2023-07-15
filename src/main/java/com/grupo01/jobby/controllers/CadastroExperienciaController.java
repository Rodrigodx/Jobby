package com.grupo01.jobby.controllers;

import com.grupo01.jobby.services.CadastroExperienciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experiencia")
@RequiredArgsConstructor
public class CadastroExperienciaController {

    private final CadastroExperienciaService cadastroExperienciaService;

}
