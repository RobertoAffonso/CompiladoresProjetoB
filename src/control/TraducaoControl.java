package control;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import view.TraducaoWindowView;

public class TraducaoControl 
{

    public int lineQTD(String text) 
    {
        int qtd = 0;
        for (int i = 0; i < text.length(); i++) 
        {
            if (text.charAt(i) == '\n') 
            {
                qtd++;
            }
        }

        qtd++;
        return qtd;
    }

    public ArrayList textBreaker(String text) 
    {
        ArrayList line = new ArrayList();
        int qntd = lineQTD(text);
        int y = 1, z = 0, t = 0;
        String temp = "";
        String temp2 = "";
        int i = 0;

        while (z < text.length()) 
        {
            if (text.charAt(z) == '\n') 
            {
                line.add(temp);
                temp = "";
            }
            else 
            {
                temp = temp + text.charAt(z);
            }
            z++;
        }
        line.add(temp);
        return line;
    }

    public String resultado(ArrayList text) 
    {
        int i = 0, y = 0, z = 0;
        ArrayList lines = new ArrayList();
        String[] ops = {"*", "/", "+", "-"};
        int controlIf = 0;
        int controlW = 0;
        String temp = "";
        String aux = "";
        int contkey = 0, auxkey = 0;
        String aux2 = "";
        String text_final = "#include <stdio.h>\n"
                + "int main() {\n"
                + "   int a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, w, x, y, z;\n"
                + "   char str[512];    // auxiliar na leitura com G\n";

        for (i = 0; i < text.size(); i++) 
        {
            temp = text.get(i).toString().replaceAll(" ", "");
            lines.add(temp);
        }

        for (i = 0; i < lines.size(); i++) 
        {
            controlIf = 0;
            aux = lines.get(i).toString();
            for (int h = 0; h < aux.length(); h++) 
            {
                if (aux.charAt(h) == 'I') 
                {
                    controlIf = 1;
                    text_final = text_final + " // " + text.get(i).toString() + "\n    "
                            + "if(" + aux.charAt(h + 1) + aux.charAt(h + 2) + aux.charAt(h + 3) + "){";
                    for (int g = h + 4; g < aux.length(); g++)
                    {
                        // While
                        if ((aux.charAt(g) == 'W')) 
                        {
                            controlW = 1;
                            if (aux.charAt(g + 2) != '#')
                            {
                                text_final = text_final + "\n    "
                                        + "while(" + aux.charAt(g + 1) + aux.charAt(g + 2) + aux.charAt(g + 3) + ") " + aux.charAt(g + 4) + "\n";
                            }
                            else
                            {
                                text_final = text_final + "\n    "
                                        + "while(" + aux.charAt(g + 1) + "!=" + aux.charAt(g + 3) + ") " + aux.charAt(g + 4) + "\n";
                            }
                            contkey++;
                        }
                        else if ((aux.charAt(g) == '}'))
                        {
                            text_final = text_final + "  " + aux.charAt(g) + "\n";
                            auxkey++;
                        }
                        else if ((aux.charAt(g) == 'G') && (Character.isLetter(aux.charAt(g + 1))) && (g + 1 < aux.length())) 
                        {
                            text_final = text_final
                                    + "\n{\n   gets(str);\n    "
                                    + "sscanf(str, \"%d\", &" + aux.charAt(g + 1) + ");\n }\n";
                        }
                        else if ((aux.charAt(g) == '=' && (g + 1 < aux.length()))) 
                        {
                            text_final = text_final + "\n    "
                                    + aux.charAt(g + 1) + aux.charAt(g) + aux.charAt(g + 2) + ";\n";
                        }
                        else if (aux.charAt(g) == '*' || aux.charAt(g) == '+'
                                || aux.charAt(g) == '/' || aux.charAt(g) == '-' || aux.charAt(g) == '%')
                        {
                            text_final = text_final + "\n     "
                                    + aux.charAt(g + 1) + "=" + aux.charAt(g + 2) + aux.charAt(g) + aux.charAt(g + 3) + ";\n";
                        }
                        else if (aux.charAt(g) == 'P')
                        {
                            text_final = text_final + "\n    "
                                    + "printf(\"%d\\n\", " + aux.charAt(g + 1) + ");\n";
                        }
                    }
                    
                    text_final = text_final + "   }\n";
                    break;
                }
                else if ((aux.charAt(h) == 'W') && controlIf == 0) 
                {
                    controlW = 1;
                    text_final = text_final + "// " + text.get(i).toString() + "\n    ";
                    if (aux.charAt(h + 2) != '#')
                    {
                        text_final = text_final +
                                "while(" + aux.charAt(h + 1) + aux.charAt(h + 2) + aux.charAt(h + 3) + ") " + aux.charAt(h + 4) + "\n";
                    }
                    else 
                    {
                        text_final = text_final + "\n    "
                                + "while(" + aux.charAt(h + 1) + "!=" + aux.charAt(h + 3) + ") " + aux.charAt(h + 4) + "\n";
                    }
                    contkey++;
                    break;
                }
                else if ((aux.charAt(h) == '}') && controlIf == 0)
                {
                    text_final = text_final + "  " + aux.charAt(h) + "\n";
                    auxkey++;
                    break;
                }
                else if ((aux.charAt(h) == 'G') && (Character.isLetter(aux.charAt(h + 1))) && (h + 1 < aux.length()) && controlIf == 0)
                {
                    text_final = text_final + "   // " + text.get(i).toString()
                            + "\n{\n   gets(str);\n    "
                            + "sscanf(str, \"%d\", &" + aux.charAt(h + 1) + ");\n }\n";
                    break;
                }
                else if ((aux.charAt(h) == '=' && (h + 1 < aux.length())) && controlIf == 0)
                {
                    text_final = text_final + "   // " + text.get(i).toString() + "\n    "
                            + aux.charAt(h + 1) + aux.charAt(h) + aux.charAt(h + 2) + ";\n";
                } 
                else if (aux.charAt(h) == '*' || aux.charAt(h) == '+'
                        || aux.charAt(h) == '/' || aux.charAt(h) == '-' || aux.charAt(h) == '%')
                {
                    if (controlIf == 0)
                    {
                        text_final = text_final + "    // " + text.get(i).toString() + "\n     "
                                + aux.charAt(h + 1) + "=" + aux.charAt(h + 2) + aux.charAt(h) + aux.charAt(h + 3) + ";\n";
                    }
                    break;
                } 
                else if (aux.charAt(h) == 'P' && controlIf == 0)
                {
                    text_final = text_final + "    // " + text.get(i).toString() + "\n    "
                            + "printf(\"%d\\n\", " + aux.charAt(h + 1) + ");\n";
                    break;
                }
            }
        }
        return text_final + "}";
    }
}
