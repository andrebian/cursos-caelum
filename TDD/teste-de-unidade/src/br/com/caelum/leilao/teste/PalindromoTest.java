package br.com.caelum.leilao.teste;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import br.com.caelum.leilao.dominio.Palindromo;

public class PalindromoTest {

	@Test
	public void verificaFrase() {
		
		Palindromo p = new Palindromo();
		
		boolean falso = p.ehPalindromo("Andre");
		assertFalse(falso);
		
		boolean verdadeiro = p.ehPalindromo("socorram me subi no onibus em marrocos");
		assertTrue(verdadeiro);
	}
	
}
