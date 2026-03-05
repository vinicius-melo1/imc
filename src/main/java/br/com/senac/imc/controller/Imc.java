package br.com.senac.imc.controller;

import br.com.senac.imc.dtos.ImcResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/imc")
public class Imc {
    @GetMapping("/calcular")
    public ResponseEntity<ImcResponseDto> calcular(@RequestParam Double peso, @RequestParam Double altura){
        ImcResponseDto imc = new ImcResponseDto();
        imc.setImc(peso / (altura * altura));

        if(imc.getImc() < 18.5) {
            imc.setClassificacao("Abaixo do peso");
        } else if (imc.getImc() >= 18.5 && imc.getImc() <= 24.9) {
            imc.setClassificacao("Peso normal");
        } else if (imc.getImc() >= 25 && imc.getImc() <= 29.9) {
            imc.setClassificacao("Sobrepeso");
        } else if (imc.getImc() >= 30 && imc.getImc() <= 34.9) {
            imc.setClassificacao("Obesidade Grau I");
        } else if (imc.getImc() >= 35 && imc.getImc() <= 39.9) {
            imc.setClassificacao("Obesidade Grau II");
        } else {
            imc.setClassificacao("Obesidade Grau III");
        }
        return ResponseEntity.ok(imc);
    }
}
