package Trabalho1705;

public class JogadorSortudo extends Jogador
{
    public JogadorSortudo(String cor)
    {
        super(cor);
    }

    public boolean jogarDados()
    {
        int num1 = (int)(Math.random() * 6) + 1;
        int num2 = (int)(Math.random() * 6) + 1;
        int resultado = num1 + num2;
        if(resultado < 7)
        {
            jogarDados();
        }
        posicao = posicao + resultado;
        System.out.println("Valor dos dados: " + num1 + " e " + num2 + " , total: " + resultado);
        jogadas = jogadas + 1;
        if(num1 == num2)
        {
            return true;
        }
        return false;
    }
}