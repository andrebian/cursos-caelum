
public class CalculadorDeImpostos {

	
	/**
	 * 
	 * @param orcamento
	 * @param imposto
	 */
	public void realizaCalculo(Orcamento orcamento, Imposto imposto) {
		
		double valor = imposto.calcula(orcamento);
		
		System.out.println("O valor do " + imposto + " é: " + valor);
	}
	
}
