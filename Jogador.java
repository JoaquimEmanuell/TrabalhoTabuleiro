package Trabalho1705;

public abstract class Jogador
{
    protected String cor;
    protected int posicao;
    protected int jogadas;
    protected int estado;

    public Jogador(String cor)
    {
        this.cor = cor;
        this.posicao = 0;
        this.jogadas = 0;
        this.estado = 0;
    }

    public boolean jogarDados()
    {
        return false;
    }

    public String getCor()
    {
        return cor;
    }

    public int getPosicao()
    {
        return posicao;
    }

    public int getEstado()
    {
        return estado;
    }

    public void setEstado(int a)
    {
        estado = a;
    }

    public void setPosicao(int posi)
    {
        posicao = posi;
    }

    public int getJogadas()
    {
        return jogadas;
    }
}