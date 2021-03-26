package com.numerosromanos.numerosromanos.Services;

import com.numerosromanos.numerosromanos.Entities.NumeroRomano;

public class ConversorDecimalRomanoService
{
    public static NumeroRomano toRoman(int n)
    {
        String romanNumbers[] = {"M", "CMXC", "CM", "D", "CDXC", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int arab[] = {1000, 990, 900, 500, 490, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (n > 0 || arab.length == (i - 1))
        {
            while ((n - arab[i]) >= 0)
            {
                n -= arab[i];
                result.append(romanNumbers[i]);
            }
            i++;
        }
        String roman = result.toString();
        return new NumeroRomano(n, roman);
    }
}
