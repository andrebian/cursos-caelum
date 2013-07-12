package br.com.caelum.leilao.teste;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Avaliador;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class TesteDoAvaliador {
	
	private Leilao leilao;
	private Usuario andre;
	private Usuario fabiane;
	private Usuario kleber;

	@Before
	public void setUp() {
		leilao = new Leilao("Playstation 3");
		leilao.defineValorProduto(380.00);
		
		andre = new Usuario("Andre");
		fabiane = new Usuario("Fabiane");
		kleber = new Usuario("Kleber");
		
	}
	
	@Test
	public void deveEntenderEmOrdemCrescente() {
		
		double lance1 = 450.00;
		double lance2 = 400.00;
		double lance3 = 250.00;
		double mediaLances = (lance2+lance1)/2;
		
		leilao.propoe(new Lance(andre, lance3));
		leilao.propoe(new Lance(fabiane, lance2));
		leilao.propoe(new Lance(kleber, lance1));
		
		Avaliador leiloeiro = new Avaliador();
		
		leiloeiro.avalia(leilao);
		
		
		double maiorEsperado = lance1; 
		double menorEsperado = lance2;
		
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(mediaLances, leiloeiro.obterValorMedioLancesValidos(leilao), 0.00001);
		
	}
	
	@Test
	public void testaLeilaoComApenasUmLance() {
		
		leilao.propoe(new Lance(andre, 420.00));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		assertEquals(420.00, leiloeiro.getMenorLance(), 0.00001);
		assertEquals(420.00, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(leiloeiro.getMenorLance(), leiloeiro.getMaiorLance(), 0.00001);
	}
	
	
	@BeforeClass
	public static void testandoBeforeClass() {
	  System.out.println("before class");
	}
	 
	@AfterClass
	public static void testandoAfterClass() {
	  System.out.println("after class");
	}

}
