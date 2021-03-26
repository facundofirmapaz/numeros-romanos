package com.numerosromanos.numerosromanos.Controllers;

import com.numerosromanos.numerosromanos.Entities.NumeroRomano;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/numero-romano")
public class NumeroRomanoController
{
    @GetMapping("/convertir/{numero}")
    public NumeroRomano sayBye(@PathVariable() int numero)
    {
        NumeroRomano num = new NumeroRomano(numero, "I");

        return num;
    }

}
