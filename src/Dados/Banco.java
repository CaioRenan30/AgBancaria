package Dados;

import java.util.ArrayList;
import java.util.Scanner;

public class Banco {
	
	static Scanner ent = new Scanner(System.in);
	static ArrayList<Contabancaria> Contas;
	
	public static void main (String[] args) {
		Contas = new ArrayList<Contabancaria>();
		operacoes();
	}
	
	public static void operacoes() {
		System.out.println("Bem vindo ao Banco CR");
		System.out.println("Selecione a operação que você quer fazer ");
		System.out.println("  1- CRIAR CONTA  ");
		System.out.println("  2- DEPOSITAR  ");
		System.out.println("  3- SAQUE  ");
		System.out.println("  4- TRANSFERIR  ");
		System.out.println("  5- SAIR  ");
		
		int operacao = ent.nextInt();
		
		switch(operacao) {
		case 1:
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3:
			saque();
			break;
		case 4:
			transferir();
			break;
		case 5:
			System.out.println(" O banco CR agradece, volte sempre ");
			System.exit(0);
			
		defaut: 
			System.out.println(" Opção inválida ");
		operacoes();
		break;
		}
		
	}
	
	public static void criarConta() {
		System.out.println("\nNome: ");
		String nome = ent.next();
		
		System.out.println("\nCPF: ");
		String cpf = ent.next();
		
		System.out.println("\nEmail: ");
		String email = ent.next();
		
		Clientes cliente = new Clientes(nome, cpf, email);
		
		Contabancaria conta = new Contabancaria(cliente);
		
		Contas.add(conta);		
		System.out.println("Sua conta foi criada com sucesso ");
		
		operacoes();
	}
	
	public static Contabancaria encontrarConta(int numConta) {
		Contabancaria conta = null;
		if(Contas.size() > 0) {
			for(Contabancaria c: Contas ) {
				if(c.getNumConta() == numConta);
				conta = c;
			
			}
		}
		return conta;
		
	}
	
	public static void depositar() {
		System.out.println("Número da conta: ");
		int numConta = ent.nextInt();
		
		Contabancaria conta = encontrarConta(numConta);
		
		if(conta != null) {
			System.out.println("Qual valor deseja depositar? ");
			double valorDeposito = ent.nextDouble();
			conta.deposito(valorDeposito);
			System.out.println("Valor depositado com sucesso ");
		}
		else {
			System.out.println("Conta não encontrada ");
			
		}
		
		operacoes();
		
	}
	
	public static void saque() {
		System.out.println("Número da conta: ");
		int numConta = ent.nextInt();
		
		Contabancaria conta = encontrarConta(numConta);
		
		if(conta != null) {
			System.out.println("Qual valor deseja sacar? ");
			double valorSaque = ent.nextDouble();
			conta.saque(valorSaque);
			//System.out.println("Valor sacado com sucesso ");
		}
		else {
			System.out.println("Conta não encontrada ");
			
		}
		
		operacoes();
	}
	
	public static void transferir() {
		System.out.println("Número da conta do remetente: ");
		int numContaRemetente = ent.nextInt();
		
		Contabancaria contaRemetente = encontrarConta(numContaRemetente);
		
		if(contaRemetente != null) {
			System.out.println(" Número conta destinátario :");
			int numContaDestinatario = ent.nextInt();
			
			Contabancaria contaDestinatario = encontrarConta(numContaDestinatario);
			
		if(contaDestinatario != null) {
			System.out.println("Digite o valor da transferência ");
			double valor = ent.nextDouble();
			
			contaRemetente.transferir(contaDestinatario, valor);
		}
		else {
			System.out.println("Conta para depósito não encontrada");
		}
			
		}
		operacoes();
		
	}
	
	
	

}
