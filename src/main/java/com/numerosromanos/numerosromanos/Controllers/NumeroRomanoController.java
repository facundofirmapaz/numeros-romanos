package com.numerosromanos.numerosromanos.Controllers;

import com.numerosromanos.numerosromanos.Entities.ErrorTransformacion;
import com.numerosromanos.numerosromanos.Entities.NumeroRomano;
import com.numerosromanos.numerosromanos.Services.ConversorDecimalRomanoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/numero-romano")
public class NumeroRomanoController
{
    @GetMapping("/convertir/{numero}")
    public ResponseEntity<?> convertir(@PathVariable() int numero)
    {

        if (numero > 0 && numero <= 3999)
        {
            NumeroRomano romano = ConversorDecimalRomanoService.toRoman(numero);

            return ResponseEntity.ok(romano);
        }
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorTransformacion(numero, "Numero invalido"));

    }

}
