package Dados;

import utilidades.Utils;

public class Contabancaria {
	
	private static int contDeContas = 1;
	
	private int numConta;
	private Clientes clientes;
	private Double saldo = 0.0;
	
	public Contabancaria(Clientes clientes) {
		
		this.numConta = contDeContas;
		this.clientes = clientes;
		contDeContas += 1;
	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public Clientes getClientes() {
		return clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	 public String toString() {
		 return "\nNúmero da conta: " + this.getNumConta()+
		        "\nNome: " + this.clientes.getNome()+
		        "\nCPF: " + this.clientes.getCpf()+
		        "\nEmail: " + this.clientes.getEmail()+
		        "\nSaldo: " + Utils.doubleToString(this.getSaldo());
		 
		 	 
	 }
		  
	 public void deposito(Double valor) {
		 if(valor > 0) {
			 setSaldo(getSaldo() + valor);
			 System.out.println(" Depósito realizado com sucesso !");
		 } 
		 else {
			 System.out.println(" Não foi possivel realizar o depósito ");
		 }
			 
	 }
	 
	 public void saque(Double valor) {
		 if(valor > 0 && this.getSaldo() >= valor ) {
			 setSaldo(getSaldo() - valor);
			 System.out.println("Saque realizado com sucesso");						 
		 }
		 else {
			 System.out.println("Não foi possível realizar o saque");
		 }
		 		 
	 }
	 
	 public void transferir(Contabancaria contaParaDeposito, double valor) {
		 if(valor > 0 && this.getSaldo() >= valor ) {
			 setSaldo(getSaldo() - valor);	
			 
			 contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
			 System.out.println("Transferência realizada com sucesso");	
		 }
		 else { 
			 System.out.println("Não foi possível realizar ");
		 }
		 
	 }
	
}

   
	   
   
