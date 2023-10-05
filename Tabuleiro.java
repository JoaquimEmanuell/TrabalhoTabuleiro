package Trabalho1705;
import java.util.ArrayList;

public class Tabuleiro {
    protected ArrayList<Jogador> jogadores = new ArrayList<Jogador>();

    //Não vou iniciar um construtor, porque não precisa :p

    public void adicionarJogador(int qntd)
    {
        String cor = "teste";
        for(int i = 1; i <= qntd; i++)
        {
            //Atribuindo uma cor a cada player

            switch(i)
            {
                case 1:
                    cor = "vermelho";
                    break;
                case 2:
                    cor = "laranja";
                    break;
                case 3:
                    cor = "amarelo";
                    break;
                case 4:
                    cor = "verde";
                    break;
                case 5:
                    cor = "azul";
                    break;
                case 6:
                    cor = "roxo";
                    break;
            }
           

            //Gerando um tipo de player aleatoriamente

            int tipo = (int)(Math.random() * 3);
            if(tipo == 0)
            {
                JogadorNormal player = new JogadorNormal(cor);
                jogadores.add(player);
            }
            if(tipo == 1)
            {
                JogadorAzarado player = new JogadorAzarado(cor);
                jogadores.add(player);
            }
            if(tipo == 2)
            {
                JogadorSortudo player = new JogadorSortudo(cor);
                jogadores.add(player);
            }
            int contadorNormal = 0;
            int contadorAzarado = 0;
            int contadorSortudo = 0;
            for(int b = 0; b < jogadores.size(); b++)
            {
                Jogador jogador = jogadores.get(b);
                if(jogador instanceof JogadorNormal)
                {
                    contadorNormal = contadorNormal++;
                }
                if(jogador instanceof JogadorAzarado)
                {
                    contadorAzarado = contadorAzarado++;
                }
                if(jogador instanceof JogadorSortudo)
                {
                    contadorSortudo = contadorSortudo++;
                }
            }
            if(contadorAzarado == qntd || contadorNormal == qntd)
            {
                Jogador jogador = jogadores.get(0);
                JogadorSortudo player = (JogadorSortudo) jogador;
                jogador = player;
            }
            if(contadorSortudo == qntd)
            {
                Jogador jogador = jogadores.get(0);
                JogadorNormal player = (JogadorNormal) jogador;
                jogador = player;
            }
        }
        System.out.println("Participantes gerados: ");
        for(int i = 0; i < jogadores.size(); i++)
        {
            Jogador jogador = jogadores.get(i);
            if(jogador instanceof JogadorNormal)
            {
                System.out.println((i+1) + "- " + jogador.getCor() + " - Jogador Normal");
            }
            if(jogador instanceof JogadorAzarado)
            {
                System.out.println((i+1) + "- " + jogador.getCor() + " - Jogador Azarado");
            }
            if(jogador instanceof JogadorSortudo)
            {
                System.out.println((i+1) + "- " + jogador.getCor() + " - Jogador Sortudo");
            }
        }
    }

    public void checarPosicao(Jogador jogador)
    {
        int posicao = jogador.getPosicao();
        if(posicao == 10 || posicao == 25 || posicao == 38)
        {
            //Ele não joga a próxima rodada
        }
    }

    public ArrayList<Jogador> getJogadores()
    {
        return jogadores;
    }
}
