package br.com.alura.loja;

import java.math.BigDecimal;
import java.util.Arrays;

import br.com.alura.loja.pedido.GeraPedido;
import br.com.alura.loja.pedido.GeraPedidoHandler;
import br.com.alura.loja.pedido.acoes.CriarPedidoNoBanco;
import br.com.alura.loja.pedido.acoes.EnviarPedidoPorEmail;
import br.com.alura.loja.pedido.acoes.LogDePedido;

public class TestesPedidos {

	public static void main(String[] args) {
		String cliente = "Josuelson";
		BigDecimal valorOrcamento = new BigDecimal("856.78");
		int quantidadeItens = 3;
		
		GeraPedido gerador = new GeraPedido(cliente, valorOrcamento, quantidadeItens);
		GeraPedidoHandler handler = new GeraPedidoHandler(Arrays.asList(
				new EnviarPedidoPorEmail(),
				new CriarPedidoNoBanco(),
				new LogDePedido()));
		handler.executar(gerador);
	}

}
