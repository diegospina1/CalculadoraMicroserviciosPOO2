package com.edu.ue;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/*
 *   Entregado por: Danna García y Diego Ospina
 *   Programa: Ingeniería de Software 14A.
 *   Asignatura: POO 2
 *   Fecha: 31/07/24
 * */

@RestController
public class SecondController {

    public Double validadorDouble(String dato) {
        try {
            double datoDouble = Double.parseDouble(dato);
            return datoDouble;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //variables url o path (Sumar)
    @GetMapping(value = "sumar/{numero1}/{numero2}")
    public String add(@PathVariable("numero1") String num1,
                      @PathVariable("numero2") String num2) {

        Double numerito1 = validadorDouble(num1);
        Double numerito2 = validadorDouble(num2);

        if (numerito1 != null && numerito2 != null) {
            double sumar = numerito1 + numerito2;
            return "El resultado es: " + sumar;

        } else {
            return "No se puede calcular texto o letras (Strings)";
        }
    }

    //QueryString (Restar)
    @RequestMapping(value = "restar", method = RequestMethod.GET)
    public String subtract(@RequestParam("number1") String num1,
                           @RequestParam("number2") String num2) {
        Double numerito1 = validadorDouble(num1);
        Double numerito2 = validadorDouble(num2);

        if (numerito1 != null && numerito2 != null) {
            double restar = numerito1 - numerito2;
            return "El resultado es: " + restar;

        } else {
            return "No se puede calcular con texto o letras (Strings)";
        }
    }

    //Dividir
    @RequestMapping(value = "division", method = RequestMethod.GET)
    public String div(@RequestParam("numerito1") String num1,
                      @RequestParam("numerito2") String num2) {

        Double numerito1 = validadorDouble(num1);
        Double numerito2 = validadorDouble(num2);

        if (numerito1 != null && numerito2 != null) {
            if (numerito2 != 0) {
                double dividir = numerito1 / numerito2;
                return "El resultado es: " + dividir;
            } else {
                return "DIVISION: No se puede dividir entre 0 ni a 0";
            }
        } else {
            return "No se puede calcular texto o letras (Strings)";
        }
    }

    //Mod (resto de una división)
    @RequestMapping(value = "mod", method = RequestMethod.GET)
    public String mod(@RequestParam("numero1") String num1,
                      @RequestParam("numero2") String num2) {

        Double numerito1 = validadorDouble(num1);
        Double numerito2 = validadorDouble(num2);

        if (numerito1 != null && numerito2 != null) {
            if (numerito2 != 0) {
                double mod = numerito1 % numerito2;
                return "El resultado es: " + mod;
            } else {
                return "DIVISION: No se puede dividir entre 0 ni a 0";
            }
        } else {
            return "No se puede csalcular texto o letras (Strings)";
        }
    }

    //Exponente (elevado a)
    @RequestMapping(value = "exponente", method = RequestMethod.GET)
    public String exponente(@RequestParam("numero1") String num1,
                            @RequestParam("numero2") String num2) {

        Double numerito1 = validadorDouble(num1);
        Double numerito2 = validadorDouble(num2);

        if (numerito1 != null && numerito2 != null) {
            double acumulador = 1;
            if (numerito2 == 0) {
                return "El resultado es: " + acumulador;
            } else {
                for (int i = 0; i < numerito2; i++) {
                    acumulador *= numerito1;
                }
                return "El resultado es: " + acumulador;
            }
        } else {
            return "No se puede calcular con texto o letras (Strings)";
        }

    }

    //Multiplicación
    @RequestMapping(value = "multiplicacion", method = RequestMethod.GET)
    public String multi(@RequestParam("numero1") String num1,
                        @RequestParam("numero2") String num2) {

        Double numerito1 = validadorDouble(num1);
        Double numerito2 = validadorDouble(num2);

        if (numerito1 != null && numerito2 != null) {
            double multiplicar = numerito1 * numerito2;
            return "El resultado es: " + multiplicar;

        } else {
            return "No se puede calcular texto o letras (Strings)";
        }
    }

}
