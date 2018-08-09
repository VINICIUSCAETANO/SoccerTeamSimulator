/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadesFutebol;

import java.util.Random;

/**
 *
 * @author Vinicius
 */
enum posicao {
    GOLEIRO,
    ZAGUEIRO,
    LATERAL,
    MEIA,
    ATACANTE
}

public class Jogador {

    private Random rnd = new Random();
    private static final String[] LISTA_NOMES = {"Pelé", "Amaral", "Mazinho", "Marinho", "Mussum", "Bebeto",
        "Romario", "Caymar", "Niltinho", "Osmar Santos", "Cafu", "Raizinho", "Ronaldinho", "Marcelo Oliveira",
        "Taison", "Arthur", "Vilsinho"};
    private String nome;
    private String cpf;
    private posicao pos;
    private double valorCompra;
    private boolean ativo;

    public Jogador() {
        nome = LISTA_NOMES[rnd.nextInt(LISTA_NOMES.length)];
        cpf = geraCpf();
        pos = geraPosicao();
        valorCompra = rnd.nextDouble() * 1000000.00 + 10000;
        ativo = false;
    }

    public Jogador(String nome, String cpf, posicao pos, double valorCompra, boolean ativo) {
        this.nome = nome;
        this.cpf = cpf;
        this.pos = pos;
        this.valorCompra = valorCompra;
        this.ativo = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public posicao getPos() {
        return pos;
    }

    public void setPos(posicao pos) {
        this.pos = pos;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    private String geraCpf() {
        String temp = "";
        for (int i = 1; i <= 12; i++) {
            if (i == 10) {
                temp += "-";
            } else {
                temp += Integer.toString(rnd.nextInt(9));
            }
        }
        return temp;
    }

    private posicao geraPosicao() {
        int posicaoInt = rnd.nextInt(5);
        switch (posicaoInt) {
            case 0:
                return posicao.GOLEIRO;
            case 1:
                return posicao.ZAGUEIRO;
            case 2:
                return posicao.LATERAL;
            case 3:
                return posicao.MEIA;
            case 4:
                return posicao.ATACANTE;
            default:
                return posicao.GOLEIRO;
        }
    }

    @Override
    public String toString() {
        String valor = String.format("%.2f", valorCompra);
        return "Nome: " + nome + "\nCPF: " + cpf
                + "\nPosicao: " + pos + "\nValor de Compra: R$ " + valor;
    }

    //Esse main é só para testar os métodos
    public static void main(String[] args) {
        Jogador[] jogadores = new Jogador[10];
        for (int i = 0; i < 10; i++) {
            jogadores[i] = new Jogador();
        }
        for (Jogador jogador : jogadores) {
            System.out.println(jogador);
            System.out.println("");
        }
    }
}
