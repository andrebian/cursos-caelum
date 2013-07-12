
public class ImpostoTest {

	
	public static void main(String[] args) {
		Imposto iss = new ISS();
		Imposto icms = new ICMS();
		
	
		Orcamento orcamento = new Orcamento(500.00);

		CalculadorDeImpostos calculadora = new CalculadorDeImpostos();
		
		calculadora.realizaCalculo(orcamento, iss);
		calculadora.realizaCalculo(orcamento, icms);
		
	}
	
}
