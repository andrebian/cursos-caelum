package br.com.caelum.leilao.dominio;

import br.com.caelum.leilao.dominio.Leilao;

public class Avaliador {
	
	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	private double menorDeTodos = Double.POSITIVE_INFINITY;
	private double valorMedioLances;
	
	
	public void avalia(Leilao leilao) {
		for (Lance lance : leilao.getLances()) {
			
			if ( verificaValidadeLance(lance, leilao) ) {
				if ( lance.getValor() > maiorDeTodos  ) {
					 maiorDeTodos = lance.getValor();
				} 
				if ( lance.getValor() < menorDeTodos ) {
					menorDeTodos = lance.getValor();
				}
			}
		}
	}
	
	
	public double getMaiorLance() {
		return maiorDeTodos;
	}
	
	
	public double getMenorLance() {
		return menorDeTodos;
	}
	
	
	public Boolean verificaValidadeLance(Lance lance, Leilao leilao) {
		if ( lance.getValor() >= leilao.obtemValorProduto() ) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public Double obterValorMedioLancesValidos(Leilao leilao) {
		
		double valorTotal = 0.00;
		int quantidadeLances = 0;
		
		for (Lance lance : leilao.getLances()) {
			if ( lance.getValor() >= leilao.obtemValorProduto() ) {
				valorTotal += lance.getValor();
				quantidadeLances++;
				System.out.println(quantidadeLances + " -- " + valorTotal);
			}
		}
		
		this.valorMedioLances = (valorTotal/quantidadeLances);
		
		return this.valorMedioLances;
	}
	

}
