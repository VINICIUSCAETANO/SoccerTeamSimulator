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
public class Mercado {

    private Random rnd = new Random();
    private Jogador[] jogadores = new Jogador[100];
    private int numJogadores;
    private int numJogadoresAtivos;
    private double saldoInicio;
    private double saldoAtual;

    public Mercado() {
        numJogadores = 0;
        numJogadoresAtivos = 0;
        saldoInicio = rnd.nextDouble() * 99900000.00 + 100000.00;
        saldoAtual = saldoInicio;
    }

    public Jogador[] getJogadores() {
        return jogadores;
    }

    public double getSaldoInicio() {
        return saldoInicio;
    }

    public double getSaldoAtual() {
        setSaldoAtual();
        return saldoAtual;
    }

    public void setSaldoAtual() {
        saldoAtual = saldoInicio;
        for (int i = 0; i < numJogadores; i++) {
            if (jogadores[i].isAtivo()) {
                saldoAtual -= jogadores[i].getValorCompra();
            }
        }
    }

    public int getNumJogadores() {
        return numJogadores;
    }

    public int getNumJogadoresAtivos() {
        setNumJogadoresAtivos();
        return numJogadoresAtivos;
    }

    public void setNumJogadoresAtivos() {
        numJogadoresAtivos = 0;
        for (int i = 0; i < numJogadores; i++) {
            if (jogadores[i].isAtivo()) {
                numJogadoresAtivos++;
            }
        }
    }

    public void contabilizarJogador(Jogador jogCadastrar) {
        if (numJogadores >= 99) {
            return;
        }
        jogadores[numJogadores] = jogCadastrar;
        numJogadores++;
    }

    public boolean comprarJogador(int index) {
        if (saldoAtual < jogadores[index].getValorCompra()) {
            return false;
        }
        jogadores[index].setAtivo(true);
        saldoAtual -= jogadores[index].getValorCompra();
        return true;

    }

    public void venderJogador(int index) {
        jogadores[index].setAtivo(false);
        saldoAtual += jogadores[index].getValorCompra();
    }

    @Override
    public String toString() {
        return String.format("Mercado de Jogadores\n"
                + "Saldo Inicial: R$ %.2f\n"
                + "Saldo Atual: R$ %.2f\n"
                + "Numero do jogadores (Total): %d\n"
                + "Numero de jogadores no Time: %d\n",
                getSaldoInicio(), getSaldoAtual(),
                getNumJogadores(), getNumJogadoresAtivos());
    }

    //esse main é só para testar os métodos. É SÖ PARA TESTAR MESMO!!!
    //use geter e setter
    public static void main(String[] args) {
        Jogador jogadorTemp;
        Mercado merc = new Mercado();
        System.out.println("Novo Mercado de Jogadores");
        System.out.printf("Saldo Inicial: %.2f\n", merc.saldoInicio);
        for (int i = 0; i < 10; i++) {
            jogadorTemp = new Jogador();
            if (merc.saldoAtual >= jogadorTemp.getValorCompra()) {
                //"compramos" esses jogadores iniciais
                merc.jogadores[i] = jogadorTemp;
                merc.numJogadores++;
                merc.jogadores[i].setAtivo(true);
                merc.saldoAtual -= jogadorTemp.getValorCompra();
                System.out.printf("Num. de jogadores: %d  Subtotal: %.2f\n", merc.numJogadores, merc.saldoAtual);
            }
        }
        System.out.println();
        System.out.println(merc);
        merc.contabilizarJogador(new Jogador());
        merc.comprarJogador(merc.numJogadores - 1);
        System.out.println(merc);
        merc.venderJogador(merc.numJogadores - 1);
        System.out.println(merc);
        merc.venderJogador(0);
        System.out.println(merc);
    }
}
