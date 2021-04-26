package com.company;

import com.company.modelo.Linha;
import com.company.modelo.Processador;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Linha linhas[] = new Linha[20];
        int TempoMedioEspera = 0;
        int NumeroSelecinado = 0;
        int CalculoPriorizado;
        int Total = 0;
        int quantum;
        int Escolha;
        int Inicio = 0;
        int i;
        int j;
        int Prioridades[] = new int[20];
        int aux = 0;
        int Termino;
        int TesteTermino = 0;
        int TempoDecorrido = 0;
        int TPT = 0;
        int auxTPE;
        float TempoMedioEsperaCalculo;
        int TempoRetorno = 0;

    //Inserir o quantum
        System.out.println("Insira o Quantum");
        Processador.setQuantum(sc.nextInt());
        if (Processador.getQuantum() <= 0) {
            do {
                System.out.println("insira um numero valido");
                Processador.setQuantum(sc.nextInt());
            } while (Processador.getQuantum() <= 0);
        }

        do {
            System.out.println("------------------------------");
            System.out.println("1-Inserir");
            System.out.println("2-Mostrar");
            System.out.println("------------------------------");
            do {
                Escolha = sc.nextInt();
                if (Escolha != 1 && Escolha != 2) {
                    System.out.println("Por favor inserir numero valido");
                }
            } while (Escolha != 1 && Escolha != 2);
            sc.nextLine();
            if (Escolha == 1) {
                Total = Total + 1;
                Inicio = Inicio + 1;
                //Criação de um novo processo
                linhas[Inicio] = new Linha();
                System.out.println("Inserir Nome do Processo");
                linhas[Inicio].setNomeDado(sc.nextLine());
                System.out.println("Inserir a Duração do Processo");
                linhas[Inicio].setCPU(sc.nextInt());
                System.out.println("Inserir prioridade");
                linhas[Inicio].setPrioridade(sc.nextInt());
                Prioridades[((Inicio) - 1)] = linhas[Inicio].getPrioridade();
                linhas[Inicio].setFinalizado(0);
                TPT = TPT + linhas[Inicio].getCPU();
                linhas[Inicio].setDuracao(linhas[Inicio].getCPU());

            }

            //enquanto o usuario escolher 1-inserir o while mantera o usuario na criação de novos processos
        } while (Escolha == 1);
        Arrays.sort(Prioridades);
        do{
            //onde o sistema procura qual o processo deve ser executado no momento
            for (i = 19; i > (19 - Total); i--) {
                NumeroSelecinado = Prioridades[i];
                //o sistema procura qual processo possui a prioridade selecionada, para que entao ocorra a execução
                for (j = 1; j <= Total; j++) {
                    if (NumeroSelecinado == linhas[j].getPrioridade()) {
                        if (linhas[j].getCPU() > 0) {
                            aux = 0;
                            //funcionalidade feita para que na hora de adicionar quanto tempo passou durante a execução, o resultado seja preciso
                            if(Processador.getQuantum() > linhas[j].getCPU()){
                                aux = linhas[j].getCPU() - Processador.getQuantum();
                            }
                            //Calculo para diminuir a duração restante, com base no quantum inserido
                            CalculoPriorizado = linhas[j].getCPU() - Processador.getQuantum();
                            linhas[j].setCPU(CalculoPriorizado);
                                //esta função atualiza o quanto de duração passou
                                TempoDecorrido = TempoDecorrido + Processador.getQuantum() + aux;


                            //Teste para ver se terminou
                            if(linhas[j].getFinalizado() == 0) {
                                if (linhas[j].getCPU() <= 0) {
                                    linhas[j].setTurnaround(TempoDecorrido);
                                    linhas[j].setFinalizado(1);
                                    TesteTermino = TesteTermino + 1;
                                }
                            }
                        } else {

                        }
                    }
                }

            }



        }while(TesteTermino != Total);
        //Apresenta o Turnaround na tela
        System.out.println("Tempo de Turnaround de cada processo: ");
        for (j = 1; j <= Total; j++){

            System.out.print(linhas[j].getNomeDado() + " : " + linhas[j].getTurnaround() + ",");
            System.out.print("  ");
            //Calcula o tempo de retorno
            TempoRetorno = TempoRetorno + linhas[j].getTurnaround();
        }

        System.out.print("\n");
        //Apresenta o Tempo de Espera na tela
        System.out.println("Tempo de Espera de cada processo: ");
        for (j = 1; j <= Total; j++){
            auxTPE = linhas[j].getTurnaround() - linhas[j].getDuracao();
            TempoMedioEspera =  TempoMedioEspera + auxTPE;
            linhas[j].setTPE(auxTPE);

            System.out.print(linhas[j].getNomeDado() + " : " + linhas[j].getTPE() + ",");
            System.out.print("  ");

        }
        System.out.print("\n");
        //Apresenta o Tempo medio de espera na tela
        System.out.print("Tempo medio de espera: ");
        TempoMedioEsperaCalculo = TempoMedioEspera / (float)Total;
        System.out.print(TempoMedioEsperaCalculo);
        System.out.print("\n");

        //Apresenta o Tempo de retorno na tela
        System.out.print("Tempo de retorno: ");
        System.out.print(TempoRetorno);
        System.out.print("\n");

        //Apresenta o Tempo de processamento total na tela
        System.out.print("Tempo de processamento total: ");
        System.out.println(TPT);



        }
    }

