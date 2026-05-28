package com.example.View.Admin;

import com.example.Util.Ferramentas;

public class MenuAdmin 
{
    public static void menuAdminInicio()
    {
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Cadastrar Motorista");
    }   
    public static void cadastrarCliente()
    {
        System.out.println("=========================");
        System.out.println("==  CADASTRAR CLIENTE  ==");
        System.out.println("=========================");

        System.out.println("Digite o Nome: ");
        String nome = Ferramentas.lString();
        System.out.println("Digite o CPF/CNPJ: ");
        String cpfCnpj = Ferramentas.lString();
        System.out.println("Digite o endereço: ");
        String nome = Ferramentas.lString();
        System.out.println("Digite a cidade: ");
        System.out.println("Digite o estado: ");
    }                                                                                                                                                                                                                                   
}
