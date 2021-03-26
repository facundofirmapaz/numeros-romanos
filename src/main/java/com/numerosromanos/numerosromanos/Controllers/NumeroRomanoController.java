package com.numerosromanos.numerosromanos.Controllers;

import com.numerosromanos.numerosromanos.Entities.NumeroRomano;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/numero-romano")
public class NumeroRomanoController
{
    @GetMapping("/convertir/{numero}")
    public ResponseEntity<?> convertir(@PathVariable() int numero)
    {

        if (numero > 0 && numero <= 3999)
        {
            String romano = toRoman(numero);

            NumeroRomano num = new NumeroRomano(numero, romano);

            return ResponseEntity.ok(num);
        }
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Numero invalido");

    }

    private String toRoman(int n)
    {
        String romanNumbers[] = {"M", "CMXC", "CM", "D", "CDXC", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int arab[] = {1000, 990, 900, 500, 490, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (n > 0 || arab.length == (i - 1)) {
            while ((n - arab[i]) >= 0) {
                n -= arab[i];
                result.append(romanNumbers[i]);
            }
            i++;
        }
        return result.toString();
    }

}
