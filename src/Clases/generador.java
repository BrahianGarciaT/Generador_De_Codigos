package Clases;

import java.util.Random;

public class generador {

    int intDigitos;
    Random aleatorio = new Random(System.currentTimeMillis());

    public generador(int intDigitos) {
        this.intDigitos = intDigitos;
    }

    public int GenerarNumero() {
        int intAleatorio = aleatorio.nextInt(10);
        return intAleatorio;
    }

    public char GenerarLetra() {
        int intTipo = aleatorio.nextInt(3) + 1;
        if (intTipo == 1) {
            char chaAleatorio = (char) (aleatorio.nextInt(26) + 97);
            return chaAleatorio;
        } else {
            char chaAleatorio = (char) (aleatorio.nextInt(26) + 65);
            return chaAleatorio;
        }
    }

    public char GenerarSimbolo() {
        int intTipo = aleatorio.nextInt(3) + 1;
        if (intTipo == 1) {
            char chaAleatorio = (char) (aleatorio.nextInt(15) + 33);
            return chaAleatorio;
        } else {
            char chaAleatorio = (char) (aleatorio.nextInt(7) + 58);
            return chaAleatorio;
        }
    }

    public String GenerarCodigo(boolean blnLetras, boolean blnNumeros, boolean blnSimbolos) {
        String strCodigo = "";
        if (intDigitos != 0) {
            if (blnLetras || blnNumeros || blnSimbolos) {
                for (int i = 0; i < intDigitos; i++) {
                    boolean continuar = true;
                    while (continuar) {
                        int intAleatorio = aleatorio.nextInt(4) + 1;
                        switch (intAleatorio) {
                            case 1:
                                if (blnNumeros) {
                                    strCodigo += GenerarNumero();
                                    continuar = false;
                                }
                                break;
                            case 2:
                                if (blnLetras) {
                                    strCodigo += GenerarLetra();
                                    continuar = false;
                                }
                                break;
                            case 3:
                                if (blnSimbolos) {
                                    strCodigo += GenerarSimbolo();
                                    continuar = false;
                                }
                                break;
                        }
                    }

                }
                return strCodigo;
            } else {
                return "Selecciona almenos un checkbox.";
            }
        } else {
            return "Especifica una cantidad de dígitos.";
        }

    }
}
