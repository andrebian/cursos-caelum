package br.com.caelum.leilao.teste;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class LeilaoTest {
	
	private Leilao leilao;


	@Before
	public void criaItemLeilao() {
		leilao = new Leilao("Mac Book");
	}

	
	
	@Test
	public void deveReceberUmLance() {
		
		assertEquals(0, leilao.getLances().size());
		
		leilao.propoe(new Lance(new Usuario("Steve Jobs"), 2000));
		
		assertEquals(1, leilao.getLances().size());
		assertEquals(2000.00, leilao.getLances().get(0).getValor(), 0.00001);
	}
	
	
	@Test
	public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
		
		Usuario usuario = new Usuario("Andre");
		
		leilao.propoe(new Lance(usuario, 2000));
		leilao.propoe(new Lance(usuario, 3000));
		
		assertEquals(1, leilao.getLances().size());
		assertEquals(2000.00, leilao.getLances().get(0).getValor(), 0.00001);
		
	}
	
	
	@Test
	public void naoDeveAceitarMaisQueCincoLancesDoMesmoUsuario() {
		Leilao leilao = new Leilao("Produto Teste");
		
		Usuario andre = new Usuario("Andre");
		Usuario fabiane = new Usuario("Fabiane");
		
		leilao.propoe(new Lance(andre, 2000));
		leilao.propoe(new Lance(fabiane, 2100));
		
		leilao.propoe(new Lance(andre, 2150));
		leilao.propoe(new Lance(fabiane, 2200));
		
		leilao.propoe(new Lance(andre, 2230));
		leilao.propoe(new Lance(fabiane, 2250));
		
		leilao.propoe(new Lance(andre, 2270));
		leilao.propoe(new Lance(fabiane, 2285));
		
		leilao.propoe(new Lance(andre, 2290));
		leilao.propoe(new Lance(fabiane, 2295));
		
		//deve ser ignorado
		leilao.propoe(new Lance(andre, 2400));
		
		
		assertEquals(10, leilao.getLances().size());
		assertEquals(2295.00, leilao.getLances().get(leilao.getLances().size()-1).getValor(), 0.00001);
		
	}
	
}
