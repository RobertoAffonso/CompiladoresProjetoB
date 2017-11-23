package model;

public class Traducao {
    public String tradutor(String[] text) {

        String[] instrucoes = text;
        String[] operadores = {"*", "/", "+", "-"};
        String textoFinal = "#include <stdio.h>\n"
                + "int main() {\n"
                + "   int a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, w, x, y, z;\n"
                + "   char str[512];    // auxiliar na leitura com G\n";
        int cont = 0;


        // Remoção dos espaços em branco
        for (int i = 0; i < text.length; i++) {
            instrucoes[i] = text[i].replaceAll(" ", "");
        }


        for (int i = 0; i < instrucoes.length; i++) {
            String instrucao = instrucoes[i];

            //inicio 
            for (int t = 0; t < instrucao.length(); t++) {

                // "if"	(I a < n P n )
                if (instrucao.charAt(t) == 'I') {
                    textoFinal = textoFinal + "// " + instrucao.charAt(t) + " " + instrucao.charAt(t + 1) + " " +
                            instrucao.charAt(t + 2) + " " + instrucao.charAt(t + 3) + "\n";
                    textoFinal = textoFinal + "if(" + instrucao.charAt(t + 1) + instrucao.charAt(t + 2) + instrucao.charAt(t + 3) + "){ \n";

                    // Instruções if
                    for (int aux = 4; aux < instrucao.length(); aux++) {

	               

                        //get (G n)
                        if ((instrucao.charAt(aux) == 'G') && (Character.isLetter(instrucao.charAt(aux + 1)))) {

                            textoFinal = textoFinal + "// " + instrucao.charAt(aux) + " " + instrucao.charAt(aux + 1) + "\n ";
                            textoFinal = textoFinal
                                    + "\n{\n   gets(str);\n    "
                                    + "sscanf(str, \"%d\", &" + instrucao.charAt(aux + 1) + ");\n }\n";
                            aux += 2;
                        }

                        // print (P 5)
                        else if (textoFinal.charAt(aux) == 'P') {

                            textoFinal = textoFinal + "// " + instrucao.charAt(aux) + " " + instrucao.charAt(aux + 1) + "\n ";
                            textoFinal = textoFinal + "\n    "
                                    + "printf(\"%d\\n\", " + instrucao.charAt(aux + 1) + ");\n";
                            aux += 2;

                        }

                        //Aritmética
                        else if (instrucao.charAt(aux) == '*' || instrucao.charAt(aux) == '+'
                                || instrucao.charAt(aux) == '/' || instrucao.charAt(aux) == '-'
                                || instrucao.charAt(aux) == '%') {

                            textoFinal = textoFinal + "//" + instrucao.charAt(aux) + " " + instrucao.charAt(aux + 1) + " " +
                                    instrucao.charAt(aux + 2) + " " + instrucao.charAt(aux + 3) + "\n ";
                            textoFinal = textoFinal + " " + instrucao.charAt(aux + 1) + " = " + instrucao.charAt(aux + 2) +
                                    instrucao.charAt(aux) + " " + instrucao.charAt(aux + 3) + "; \n ";
                            aux += 4;

                        }

                        //Attr
                        else if (instrucao.charAt(aux) == '=') {

                            textoFinal = textoFinal + "//" + instrucao.charAt(aux) + " " + instrucao.charAt(aux + 1) + " " +
                                    instrucao.charAt(aux + 2) + " \n ";
                            textoFinal = textoFinal + " " + instrucao.charAt(aux + 1) + " " + instrucao.charAt(aux) + " " +
                                    +instrucao.charAt(aux + 2) + "; \n ";
                            aux += 3;
                        }

                        // }
                        else if ((instrucao.charAt(aux) == '}')) {
                            textoFinal = textoFinal + "  " + instrucao.charAt(aux) + "\n";
                        }

                    }

                    textoFinal = textoFinal + " } \n ";
                    break;
                }
                // ----------------------------------------------------------------------------------------------------------------------------
                // while
                else if (instrucao.charAt(t) == 'W') {
                    textoFinal = textoFinal + "// " + instrucao.charAt(t) + " " + instrucao.charAt(t + 1) + " " + instrucao.charAt(t + 2)
                            + " " + instrucao.charAt(t + 3) + " \n";

                    if (instrucao.charAt(t + 2) != '#') {
                        textoFinal = textoFinal +
                                "while(" + instrucao.charAt(t + 1) + instrucao.charAt(t + 2) + instrucao.charAt(t + 3) + ") "
                                + instrucao.charAt(t + 4) + "\n";
                    } else {
                        textoFinal = textoFinal
                                + "while(" + instrucao.charAt(t + 1) + "!=" + instrucao.charAt(t + 3) + ") " + instrucao.charAt(t + 4)
                                + "\n";
                    }

                    // Condicionais while
                    for (int aux = 5; aux < instrucao.length(); aux++) {

                        //If
                        if ((instrucao.charAt(aux) == 'I') && (instrucao.charAt(aux + 2) == '#')) {
                            textoFinal = textoFinal + "// " + instrucao.charAt(aux) + " " + instrucao.charAt(aux + 1) + " " +
                                    instrucao.charAt(aux + 2) + " " + instrucao.charAt(aux + 3) + "\n";
                            textoFinal = textoFinal + "if(" + instrucao.charAt(aux + 1) + " != " + instrucao.charAt(aux + 3) + "){ \n";
                        } else if (instrucao.charAt(aux) == 'I') {
                            textoFinal = textoFinal + "// " + instrucao.charAt(aux) + " " + instrucao.charAt(aux + 1) + " " +
                                    instrucao.charAt(aux + 2) + " " + instrucao.charAt(aux + 3) + "\n";
                            textoFinal = textoFinal + "if(" + instrucao.charAt(aux + 1) + instrucao.charAt(aux + 2) +
                                    instrucao.charAt(aux + 3) + "){ \n";
                            aux += 3;
                        }

                        //(G n)
                        else if ((instrucao.charAt(aux) == 'G') && (Character.isLetter(instrucao.charAt(aux + 1)))) {

                            textoFinal = textoFinal + "//  " + instrucao.charAt(aux) + " " + instrucao.charAt(aux + 1) + "\n ";
                            textoFinal = textoFinal
                                    + "\n{\n   gets(str);\n    "
                                    + "sscanf(str, \"%d\", &" + instrucao.charAt(aux + 1) + ");\n }\n";
                            aux += 1;
                        }

                        // print (P 5)
                        else if (instrucao.charAt(aux) == 'P') {

                            textoFinal = textoFinal + "// " + instrucao.charAt(aux) + " " + instrucao.charAt(aux + 1) + "\n ";
                            textoFinal = textoFinal + "\n    "
                                    + "printf(\"%d\\n\", " + instrucao.charAt(aux + 1) + ");\n";
                            aux += 1;
                        }

                        //Aritmetica
                        else if (instrucao.charAt(aux) == '*' || instrucao.charAt(aux) == '+'
                                || instrucao.charAt(aux) == '/' || instrucao.charAt(aux) == '-'
                                || instrucao.charAt(aux) == '%') {

                            textoFinal = textoFinal + "//" + instrucao.charAt(aux) + " " + instrucao.charAt(aux + 1) + " " +
                                    instrucao.charAt(aux + 2) + " " + instrucao.charAt(aux + 3) + "\n ";
                            textoFinal = textoFinal + " " + instrucao.charAt(aux + 1) + " = " + instrucao.charAt(aux + 2) +
                                    instrucao.charAt(aux) + " " + instrucao.charAt(aux + 3) + "; \n ";
                            aux += 3;
                        }

                        //Attr
                        else if (instrucao.charAt(aux) == '=') {

                            textoFinal = textoFinal + "//" + instrucao.charAt(aux) + " " + instrucao.charAt(aux + 1) + " " +
                                    instrucao.charAt(aux + 2) + " \n ";
                            textoFinal = textoFinal + " " + instrucao.charAt(aux + 1) + " " + instrucao.charAt(aux) + " " +
                                    +instrucao.charAt(aux + 2) + "; \n ";
                            aux += 2;
                        }

                        // }
                        else if ((instrucao.charAt(aux) == '}')) {
                            textoFinal = textoFinal + "  " + instrucao.charAt(aux) + "\n";
                        }
                    }
                    break;
                }
                //---------------------------------------------------------------------------------------------------------------------------
                // get (G n)
                else if ((instrucao.charAt(t) == 'G') && (Character.isLetter(instrucao.charAt(t + 1)))) {

                    textoFinal = textoFinal + "// " + instrucao.charAt(t) + " " + instrucao.charAt(t + 1) + "\n ";
                    textoFinal = textoFinal
                            + "\n{\n   gets(str);\n    "
                            + "sscanf(str, \"%d\", &" + instrucao.charAt(t + 1) + ");\n }\n";
                }

                //print (P 5)
                else if (textoFinal.charAt(t) == 'P') {

                    textoFinal = textoFinal + "// " + instrucao.charAt(t) + " " + instrucao.charAt(t + 1) + "\n ";
                    textoFinal = textoFinal + "\n    "
                            + "printf(\"%d\\n\", " + instrucao.charAt(t + 1) + ");\n";
                }

                //Artimetica
                else if (instrucao.charAt(t) == '*' || instrucao.charAt(t) == '+'
                        || instrucao.charAt(t) == '/' || instrucao.charAt(t) == '-'
                        || instrucao.charAt(t) == '%') {

                    textoFinal = textoFinal + "//" + instrucao.charAt(t) + " " + instrucao.charAt(t + 1) + " " +
                            instrucao.charAt(t + 2) + " " + instrucao.charAt(t + 3) + "\n ";
                    textoFinal = textoFinal + " " + instrucao.charAt(t + 1) + " = " + instrucao.charAt(t + 2) +
                            instrucao.charAt(t) + " " + instrucao.charAt(t + 3) + "; \n ";

                }

                //Attr
                else if (instrucao.charAt(t) == '=') {

                    textoFinal = textoFinal + "//" + instrucao.charAt(t) + " " + instrucao.charAt(t + 1) + " " +
                            instrucao.charAt(t + 2) + " \n ";
                    textoFinal = textoFinal + " " + instrucao.charAt(t + 1) + " " + instrucao.charAt(t) + " " +
                            +instrucao.charAt(t + 2) + "; \n ";
                }

                // }
                else if ((instrucao.charAt(t) == '}')) {
                    textoFinal = textoFinal + "  " + instrucao.charAt(t) + "\n";
                }

            }
        }
        return textoFinal;
    }
}

