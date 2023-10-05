package Trabalho1705;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String args[])
    {
        Tabuleiro tabuleiro = new Tabuleiro();
        int i = 1;
        ArrayList<Jogador> jogadores = tabuleiro.getJogadores();
        System.out.println("JOGUINHO DO TRABALHO DE POO :)");
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite a quantidade de participantes(mínimo 2 e máximo 6): ");
        int qntd = teclado.nextInt();
        tabuleiro.adicionarJogador(qntd);
        teclado.next();
        System.out.println(".");
        System.out.println("Que começe o jogo!");
        int rodada = 1;
        while(i == 1)
        {
            System.out.println(rodada + "° Rodada");
            for(int a = 0; a < jogadores.size(); a++)
            {
                Jogador jogador = jogadores.get(a);
                System.out.println(jogador.getCor() + " - posição: " + jogador.getPosicao());
            }
            for(int a = 0; a < jogadores.size(); a++)
            {
                Jogador player = jogadores.get(a);
                if(player.getEstado() == 0)
                {
                    System.out.println("Vez de jogar: " + player.getCor());
                    if(player.jogarDados())
                    {
                        System.out.println("Jogue os dados novamente!");
                        player.jogarDados();
                    }
                    if(player.getPosicao() >= 40)
                    {
                        System.out.println("Parabéns " + player.getCor() + " você é o vencedor!");
                        i = 0;
                        break;
                    }
                    if(player.getPosicao() == 10 || player.getPosicao() == 25 || player.getPosicao() == 38)
                    {
                        player.setEstado(1);
                    }
                    if(player.getPosicao() == 13)
                    {
                        System.out.println("Casa surpresa, sortearemos uma carta aleatória que mudará seu tipo de personagem!");
                        int tipo = (int)(Math.random() * 3);
                        if(tipo == 0)
                        {
                            JogadorNormal jogador = (JogadorNormal) player;
                            player = jogador;
                            System.out.println("Novo tipo: Jogador Normal");
                        }
                        if(tipo == 1)
                        {
                            JogadorAzarado jogador = (JogadorAzarado) player;
                            player = jogador;
                            System.out.println("Novo tipo: Jogador Azarado");
                        }
                        if(tipo == 2)
                        {
                            JogadorSortudo jogador = (JogadorSortudo) player;
                            player = jogador;
                            System.out.println("Novo tipo: Jogador Sortudo");
                        }
                    }
                    if(player.getPosicao() == 5 || player.getPosicao() == 15 || player.getPosicao() == 30)
                    {
                        System.out.println("Casa especial, ande 3 casas!");
                        if(player instanceof JogadorNormal || player instanceof JogadorSortudo)
                        {
                            int posicao = player.getPosicao();
                            posicao = posicao + 3;
                            player.setPosicao(posicao);
                        }
                    }
                    if(player.getPosicao() == 17 || player.getPosicao() == 27)
                    {
                        System.out.println("Casa especial, escolha um jogador para voltar ao começo: ");
                        String jogadorEscolhido = teclado.next();
                        for(int b = 0; b < jogadores.size(); b++)
                        {
                            Jogador jogador = jogadores.get(b);
                            if(jogador.getCor().equalsIgnoreCase(jogadorEscolhido))
                            {
                                jogador.setPosicao(0);
                            }
                        }
                    }
                    if(player.getPosicao() == 20 || player.getPosicao() == 35)
                    {
                        System.out.println("Casa mágica, troque de posição com o último jogador");
                        int menorPosicao = 40;
                        String corMenor = "teste";
                        for(int b = 0; b < jogadores.size(); b++)
                        {
                            Jogador jogador = jogadores.get(b);
                            if(jogador.getPosicao() < menorPosicao)
                            {
                                menorPosicao = jogador.getPosicao();
                                corMenor = jogador.getCor();
                            }
                        }
                        for(int b = 0; b < jogadores.size(); b++)
                        {
                            Jogador jogador = jogadores.get(b);
                            if(jogador.getCor().equalsIgnoreCase(corMenor))
                            {
                                jogador.setPosicao(player.getPosicao());
                            }
                        }
                        player.setPosicao(menorPosicao);
                        System.out.println("Sua posição foi trocada com o último jogador!");
                        System.out.println("Posição atual: " + player.getPosicao());
                    }

                    tabuleiro.checarPosicao(player);
                }
                else
                {
                    System.out.println("Vez de " + player.getCor() + " passada!");
                    player.setEstado(0);
                }
            }
            rodada = rodada + 1;
        }
        for(int a = 0; a < jogadores.size(); a++)
        {
            Jogador jogador = jogadores.get(a);
            System.out.println(jogador.getCor() + " - " + jogador.getJogadas() + " jogadas");
        }
    }
}
