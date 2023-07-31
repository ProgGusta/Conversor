package br.com.conversor;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

//classe com os metodos e atributos usados no conversor 
public class Utils {

    //padrão de formatação do valor de saída
    private final static String padrao = "$ ###,###.##";

    //menus de opção para o usuário
    private final static String[] conversoes = {"Reais a Dolar", "Reais a Euro", "Reais a Libras Esterlinas", 
                                    "Reais a Peso argentino", "Reais a Peso Chileno", 
                                    "Dolar a Reais", "Euro a Reais", "Libras Esterlinas a Reais", 
                                    "Peso argentino a  Reais", "Peso Chileno a Reais"};

    private final static String[] menu = {"Conversor de moedas"};

    //valores arredondados dos valores das moedas em relação ao real
    private final static double dolar = 4.75;
    private final static double euro = 5.25;
    private final static double libra = 6.10;
    private final static double pArg = 0.017;
    private final static double pChi = 0.0057;

    public static String mode(String[] options, String message, String title)
    {
        // Exibindo o diálogo e obtendo a opção selecionada pelo usuário
        String opcaoSelecionada = (String) JOptionPane.showInputDialog(
                null,                        // Componente pai (null para centralizar na tela)
                message,      // Mensagem exibida no diálogo
                title,          // Título da caixa de diálogo
                JOptionPane.PLAIN_MESSAGE,   // Tipo de mensagem (sem ícone)
                null,                        // Ícone personalizado (null para nenhum)
                options,                      // Opções a serem exibidas
                options[0]                    // Opção pré-selecionada (opcional)
        );

        return opcaoSelecionada;
    }

    // sobrecarga de métodos
    public static String mode(int options)
    {
        String opcaoSelecionada = null;
        switch (options) {
            case 1: //menu inicial
                opcaoSelecionada = Utils.mode(menu, "Selecione uma opção:", "menu");
                break;

            case 2: //Conversor
                double value = 0.0;
                boolean invalido = false;
                do {
                    try 
                    {
                        value = Double.valueOf(JOptionPane.showInputDialog("insira o valor(use \".\" para a parte decimal)"));
                        invalido = false;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(
                            null,
                            "Caracter invalido",
                            "ERROR!",
                            JOptionPane.ERROR_MESSAGE
                            );
                        invalido = true;
                    }
                } while (invalido);
                
                opcaoSelecionada = Utils.mode(conversoes, "Selecione as moedas", "Conversor");

                opcaoSelecionada = Utils.conversion(opcaoSelecionada, value);

                JOptionPane.showMessageDialog(
                            null,
                            opcaoSelecionada,
                            "valor convertido",
                            JOptionPane.INFORMATION_MESSAGE
                            );
                break;

            default:
                break;
        }

        return opcaoSelecionada;
    }

    // verifica a opção selecionada pelo usuário
    public static int verifyOptions(String options)
    {
        if (options != null)
        {
            if (options == "Conversor de moedas")
                return 2;
        }
        
        return 0;
    }

    //Usuário decide se quer fazer outra operação 
    public static int otherOperations()
    {
        return JOptionPane.showConfirmDialog(
            null,
            "Deseja fazer outra operação?",
            "finalização",
            JOptionPane.YES_NO_CANCEL_OPTION
            );
    }

    //Tratamento das conversões
    public static String conversion(String coin, double value)
    {
        double convertido = 0.0;
        DecimalFormat df = new DecimalFormat(padrao);

        switch (coin)
        {
            case "Reais a Dolar":
                convertido = value / dolar;
                break;

            case "Reais a Euro":
                convertido = value / euro;
                break;

            case "Reais a Libras Esterlinas":
                convertido = value / libra;
                break;

            case "Reais a Peso argentino":
                convertido = value / pArg;
                break;

            case "Reais a Peso Chileno":
                convertido = value / pChi;
                break;

            case "Dolar a Reais":
                convertido = value * dolar;
                break;

            case "Euro a Reais":
                convertido = value * euro;
                break;

            case "Libras Esterlinas a Reais":
                convertido = value * libra;
                break;
            
            case "Peso argentino a  Reais":
                convertido = value * pArg;
                break;

            case "Peso Chileno a Reais":
                convertido = value * pChi;
                break;
        }

        return "O valor da conversao e " + df.format(convertido);
    }

    // finalização do programa
    public static void finalization()
    {
        JOptionPane.showMessageDialog(
                            null,
                            "Programa finalizado",
                            "Finalizacao",
                            JOptionPane.INFORMATION_MESSAGE
                            );
    }
}