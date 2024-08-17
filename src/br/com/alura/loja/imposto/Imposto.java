package br.com.alura.loja.imposto;

import java.math.BigDecimal;
import br.com.alura.loja.orcamento.Orcamento;

// Pattern Decorator
public abstract class Imposto {

	private Imposto outroImposto;
	public Imposto (Imposto outroImposto){
		this.outroImposto = outroImposto;
	}

	protected abstract BigDecimal realizarCalculo(Orcamento orcamento);

	public BigDecimal calcular(Orcamento orcamento){
		BigDecimal valorImposto = realizarCalculo(orcamento);
		BigDecimal valorOutroImposto = BigDecimal.ZERO;

		if(outroImposto != null){
			valorOutroImposto = outroImposto.realizarCalculo(orcamento);
		}
		return valorImposto.add(valorOutroImposto);
	}

}
