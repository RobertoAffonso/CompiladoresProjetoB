package control;

import java.util.ArrayList;

public class ConditionalControl {
    OperatorControl oc = new OperatorControl();
    IOControl ic = new IOControl();
    ArrayList error = new ArrayList();
    int errorGeral = 0;

    public ArrayList corrigeIf(String aux, int cont, int linerror) {
        ArrayList line = new ArrayList();
        //Checa se identificadores estão em letra maiuscula;
        breakLine(aux, cont, linerror);
        String correcao = null;
        int contkey = 0, auxkey = 0;
        /////////////////////////////////////////////////////////////////////////
        correctInitial(aux, cont, linerror);
        if (error.size() == 0) {
            line = breakLine(aux, cont, linerror);
            for (int i = 0; i < line.size(); i++) {
                aux = line.get(i).toString();

                for (int h = 0; h < aux.length(); h++) {
                    if ((aux.charAt(h) == 'G')) {
                        String result = null;
                        result = ic.idCorrector(aux, h, linerror);
                        if (result != null) {
                            error.add(result);
                        }
                    } //Atribuição
                    else if ((aux.charAt(h) == '=')) {
                        String result = null;
                        result = oc.corrigeAt(aux, h, linerror);
                        if (result != null) {
                            error.add(result);
                        }
                    }//Operação
                    else if (aux.charAt(h) == '*' || aux.charAt(h) == '+'
                            || aux.charAt(h) == '/' || aux.charAt(h) == '-' || aux.charAt(h) == '%') {
                        String result = null;
                        result = oc.corrigeOps(aux, h, linerror);
                        if (result != null) {
                            error.add(result);
                        }
                    }
                    //Print
                    else if (aux.charAt(h) == 'P') {
                        String result = null;
                        result = ic.printCorrector(aux, h, linerror);
                        if (result != null) {
                            error.add(result);
                        }
                    }
                }
            }
        }
        ////////////////////////////////////////////////////////////////////////
        return error;
    }

    public ArrayList breakLine(String aux, int cont, int linerror) {
        ArrayList breaker = new ArrayList();
        int tam = cont + 4;
        int controlIf = 0;
        int y = tam;
        for (int g = y; g < aux.length(); g++) {
            controlIf = 0;

            /////////////////////////////////////////////////////////////////////////////////////
            if (aux.charAt(g) == 'G') {
                int j = 0;
                int total = g + 1;
                String temp = "";
                if (total < aux.length()) {
                    while (j < 2) {
                        temp = temp + aux.charAt(y);
                        j++;
                        y++;
                    }
                    breaker.add(temp);
                } else {
                    error.add("[ERROR - LINE " + linerror + " IF - Get Statement] Missing Parameters");
                }
            }
            /////////////////////////////////////////////////////////////////////////////////////
            if (aux.charAt(g) == 'P') {
                int j = 0;
                int total = g + 1;
                String temp = "";
                if (total < aux.length()) {
                    while (j < 2) {
                        temp = temp + aux.charAt(y);
                        j++;
                        y++;
                    }
                    breaker.add(temp);
                } else {
                    error.add("[ERROR - LINE " + linerror + " IF - Print Statement] Missing Parameters");
                    break;
                }
            }
            /////////////////////////////////////////////////////////////////////////////////////
            if (aux.charAt(g) == '+' || aux.charAt(g) == '-' || aux.charAt(g) == '%' || aux.charAt(g) == '*' || aux.charAt(g) == '/') {
                int j = 0;
                int total = g + 3;
                String temp = "";
                if (total < aux.length()) {
                    while (j < 4) {
                        temp = temp + aux.charAt(y);
                        j++;
                        y++;
                    }
                    breaker.add(temp);
                } else {
                    error.add("[ERROR - LINE " + linerror + " dentro do IF - Op] Missing Parameters");
                    break;
                }
            }
            /////////////////////////////////////////////////////////////////////////////////////
            if (aux.charAt(g) == '=') {
                int j = 0;
                int total = g + 2;
                String temp = "";
                if (total < aux.length()) {
                    while (j < 3) {
                        temp = temp + aux.charAt(y);
                        j++;
                        y++;
                    }
                    breaker.add(temp);
                } else {
                    error.add("[ERROR - LINE " + linerror + " dentro do IF - Attr] Missing Parameters");
                    break;
                }
            }
        }
        return breaker;
    }

    public void correctInitial(String aux, int cont, int linerror) {
        String[] testI = new String[4];
        String correcao = "";
        int errorIf = 0;
        if (cont + 1 < aux.length() && Character.isLetter(aux.charAt(cont + 1))) {
            testI[0] = aux.charAt(cont + 1) + "";
            testI[1] = testI[0].toUpperCase();
        }

        if (cont + 3 < aux.length() && Character.isLetter(aux.charAt(cont + 3))) {
            testI[2] = aux.charAt(cont + 3) + "";
            testI[3] = testI[2].toUpperCase();
        }
        /////////////////////////////////////////////////////////////////////////
        if (aux.length() < 4) {
            correcao = "[ERROR - LINE " + linerror + "] Missing Parameters";
            error.add(correcao);
            errorIf = 1;
        }//Checa o case do segundo identificador
        else if (testI[1] != null && testI[1].charAt(0) == aux.charAt(cont + 1)) {
            correcao = "[ERROR - LINE " + linerror + "] ID CAPS error";
            error.add(correcao);
            errorIf = 1;
        } //Checa se foi colocado outro caracter que não seja um identificador
        else if (!Character.isLetter(aux.charAt(cont + 1)) && (cont + 1 < aux.length())) {
            correcao = "[ERROR - LINE " + linerror + "] Incompatible Char";
            error.add(correcao);
            errorIf = 1;
        }//Checa se contem os operandos
        else if ((cont + 2 < aux.length()) && aux.charAt(cont + 2) != '>' && aux.charAt(cont + 2) != '<'
                && aux.charAt(cont + 2) != '=' && aux.charAt(cont + 2) != '#') {
            correcao = "[ERROR - LINE " + linerror + "] Missing Operators";
            error.add(correcao);
            errorIf = 1;
        } else if (!Character.isLetter(aux.charAt(cont + 3)) && !Character.isDigit(aux.charAt(cont + 3)) && cont + 3 < aux.length()) {
            correcao = "[ERROR - LINE " + linerror + "] Invalid ID";
            error.add(correcao);
            errorIf = 1;
        }
        //Checa o case do segundo identificador
        else if (testI[3] != null && testI[3].charAt(0) == aux.charAt(cont + 3)) {
            correcao = "[ERROR - LINE " + linerror + "] ID CAPS Error";
            error.add(correcao);
            errorIf = 1;
        }

        //Checa o case do segundo identificador
        else if (aux.indexOf("<=") != -1 || aux.indexOf(">=") != -1) {
            correcao = "[ERROR - LINE " + linerror + "] Missing ID or NUM";
            error.add(correcao);
            errorIf = 1;
        }
    }

    public String corrigeWhile(String aux, int cont, int linerror) {
        String correcao = null;
        String[] test = new String[4];
        //Checa tamanho e servirá para testar o case de identificadores
        if (cont + 1 < aux.length() && Character.isLetter(aux.charAt(cont + 1))) {
            test[0] = aux.charAt(cont + 1) + "";
            test[1] = test[0].toUpperCase();
        }

        if (cont + 3 < aux.length() && Character.isLetter(aux.charAt(cont + 3))) {
            test[2] = aux.charAt(cont + 3) + "";
            test[3] = test[2].toUpperCase();
        }
        if (aux.indexOf("{") == -1) {
            //Checa se contém chave
            correcao = "[ERROR - LINE " + linerror + "] Missing '{'";
        }//Parâmetros faltando
        else if (aux.length() < 5) {
            correcao = "[ERROR - LINE " + linerror + "] Missing Parameters";
        } //Identificador em letra maiuscula
        else if (test[1] != null && test[1].charAt(0) == aux.charAt(cont + 1)) {
            correcao = "[ERROR - LINE " + linerror + "] ID CAPS ERROR";
        } // Identificador não é uma letra
        else if (!Character.isLetter(aux.charAt(cont + 1)) && cont + 1 < aux.length()) {
            correcao = "[ERROR - LINE " + linerror + "] INVALID ID";
        } else if (!Character.isLetter(aux.charAt(cont + 3)) && !Character.isDigit(aux.charAt(cont + 3)) && cont + 3 < aux.length()) {
            correcao = "[ERROR - LINE " + linerror + "] Invalid CHAR";
        }// Caracter que será atribuido ao identificador está em letra maiuscula
        else if (test[3] != null && Character.isLetter(aux.charAt(cont + 3)) && test[3].charAt(0) == aux.charAt(cont + 3)) {
            correcao = "[ERROR - LINE " + linerror + "] ID CAPS ERROR";
        }//Checa se contem os operandos
        else if (aux.charAt(cont + 2) != '>' && aux.charAt(cont + 2) != '<'
                && aux.charAt(cont + 2) != '=' && aux.charAt(cont + 2) != '#') {
            correcao = "[ERROR - LINE " + linerror + "] Missing Operators";
        }//Mais parametros que o necessário
        else if (aux.length() > 5) {
            correcao = "[ERROR - LINE " + linerror + "] Parameter Stack Overflow";
        }
        return correcao;
    }
}
