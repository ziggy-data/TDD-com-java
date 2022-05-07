package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {

	private ReajusteService service;
	private Funcionario funcionario;
	
	@BeforeEach //antes de cada um dos metodo chame esse metodo plz
	public void inicializar() {
		System.out.println("inicializar");
		this.service = new ReajusteService();
		this.funcionario = new Funcionario("Ana",LocalDate.now(), new BigDecimal("1000.00")); 
	}

	@AfterEach //caso eu queira fazer algo depois dos metodos serem chamados
	public void finalizar() {
		System.out.println("Fim");
	}
	@BeforeAll // antes d rodar todos os teste   - qnd for all tem q ser estatico
	public static void antesDeTodos() {
		System.out.println("antes de todos");
	}
	@AfterAll
	public static void depoisDeTodos() {
		System.out.println("Depois de todos");
	}
	
	
	@Test
	public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
		inicializar();
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom() {
		inicializar();
		service.concederReajuste(funcionario, Desempenho.BOM);
		
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}

	@Test
	public void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo() {
		inicializar();
		service.concederReajuste(funcionario, Desempenho.OTIMO);
		
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}
	
	
	
}
