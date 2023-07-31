package br.com.conversor;

public class App {
    public static void main(String[] args) throws Exception 
    {
        // variaveis utilizadas 
        String opcaoSelecionada = null;
        boolean control = true; 

        while (control) 
        {
            // Exibindo o diálogo e obtendo a opção selecionada pelo usuário
            opcaoSelecionada = Utils.mode(1);


            // Verificando se o usuário selecionou alguma opção e exibindo o resultado
            if (opcaoSelecionada != null) 
                opcaoSelecionada = Utils.mode(Utils.verifyOptions(opcaoSelecionada));

            // verifica se o usuário deseja fazer outra operação
            if (Utils.otherOperations() == 0)
                control = true;
            else
            {
                control = false;
                Utils.finalization();
            }
        }       
    }
}
