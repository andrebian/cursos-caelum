package br.com.caelum.leilao.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.caelum.leilao.dominio.MatematicaMaluca;


public class MatematicaMalucaTest {
	
	@Test
	public void testaComNumeroMenorQueDez() {
		MatematicaMaluca mate = new MatematicaMaluca();
		
		assertEquals(10, mate.contaMaluca(5));
	}
	
	@Test
	public void testaComNumeroMaiorQueDezEMenorQueTrinta() {
		MatematicaMaluca mate = new MatematicaMaluca();
		
		assertEquals(45, mate.contaMaluca(15));
	}
	
	@Test
	public void testaComNumeroMaiorQueTrinta() {
		MatematicaMaluca mate = new MatematicaMaluca();
		
		assertEquals(140, mate.contaMaluca(35));
	}
	
}
