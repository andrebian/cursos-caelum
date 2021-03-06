package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;
	private Double valor;
	
	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}
	
	public void propoe(Lance lance) {
		int total = quantidadeLancesDo(lance.getUsuario());
		
		if ( lances.isEmpty() || (!ultimoLanceDado().getUsuario().equals(lance.getUsuario()) && total <5) ) {
			lances.add(lance);
		}
		
	}

	private int quantidadeLancesDo(Usuario usuario) {
		int total = 0;
		
		for (Lance l : lances) {
			if ( l.getUsuario().equals(usuario) ) {
				total++;
			}
		}
		return total;
	}

	private Lance ultimoLanceDado() {
		return lances.get(lances.size()-1);
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}
	
	
	
	public void defineValorProduto(Double valor) {
		this.valor = valor;
	}
	
	public Double obtemValorProduto() {
		return this.valor;
	}

	
	
}
