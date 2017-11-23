package control;

import java.util.ArrayList;

public class IOControl 
{

    public String printCorrector(String aux, int cont, int linerror) 
    {
        String correcao = null;
        String[] test = new String[4];
        /////////////////////////////////////////////////////////////////////////
        //Checa se identificador está em letra maiuscula
        if (cont + 1 < aux.length() && Character.isLetter(aux.charAt(cont + 1))) 
        {
            test[0] = aux.charAt(cont + 1) + "";
            test[1] = test[0].toUpperCase();
        }
        /////////////////////////////////////////////////////////////////////////
        //Checa se possui todos os parametros
        if (aux.length() < 2) 
        {
            correcao = "[ERROR - LINE " + linerror + "] Missing Parameter";
        }//Checa se identificador está em letra maiuscula
        else if (test[1] != null && aux.charAt(cont + 1) == test[1].charAt(0) && (cont + 1 < aux.length())) {
            correcao = "[ERROR - LINE " + linerror + "] ID CAPS ERROR";
        }//Checa a quantidade de parâmetros
        else if (aux.length() > 2) {
            correcao = "[ERROR - LINE " + linerror + "] Parameter Stack Overflow";
        }
        /////////////////////////////////////////////////////////////////////////
        return correcao;
    }

    public String idCorrector(String aux, int cont, int linerror) {
        String error = null;
        String[] test = new String[4];
        /////////////////////////////////////////////////////////////////////////
        //Checa se identificador está em letra maiuscula
        if (cont + 1 < aux.length() && Character.isLetter(aux.charAt(cont + 1))) {
            test[0] = aux.charAt(cont + 1) + "";
            test[1] = test[0].toUpperCase();
        }
        /////////////////////////////////////////////////////////////////////////
        //Checa se possui todos os parametros
        if (aux.length() < 2) {
            error = "[ERROR - LINE " + linerror + "] Missing ID";
        } else if (!Character.isLetter(aux.charAt(cont + 1)) && (cont + 1 < aux.length())) {
            error = "[ERROR - LINE " + linerror + "] Incompatible Char";
        }//Checa se identificador está em letra maiuscula
        else if (test[1] != null && aux.charAt(cont + 1) == test[1].charAt(0) && (cont + 1 < aux.length())) {
            error = "[ERROR - LINE " + linerror + "]ID CAPS ERROR";
        }//Checa a quantidade de parâmetros
        else if (aux.length() > 2) {
            error = "[ERROR - LINE " + linerror + "] Parameter Stack Overflow";
        }
        /////////////////////////////////////////////////////////////////////////
        return error;
    }
}
