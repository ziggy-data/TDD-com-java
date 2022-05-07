package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {
	
	

	@Test
	void bonusDeveriaSerZeroParaFuncionarComSalarioMuitoAlto() {
		BonusService service= new BonusService();
		
		/*
		assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(
				new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"))
				));//lambda
		//como lê: lanço uma classe da excecao e o lambda com o metodo a ser chamado
		
		*/
		
		try {
			service.calcularBonus(
					new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
			//se chegar a essa linha ele ta errado, pq tinha q cair no catch na linha anterior
			fail("Não ocorreu a exception esperada!");
		} catch (Exception e) {
			assertEquals("Salário muito alto para receber bônus", e.getMessage());
		}
	}

	@Test
	void bonusDeveriaSer10PorcentoDoSalario() {
		BonusService service= new BonusService();
		BigDecimal bonus = service.calcularBonus(
				new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500")));
		
		assertEquals(new BigDecimal("250.00"), bonus);
	}
	
	@Test
	void bonusDeveriaSer10PorcentoParaSalarioDeExatamente10000() {
		BonusService service= new BonusService();
		BigDecimal bonus = service.calcularBonus(
				new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));
		
		assertEquals(new BigDecimal("1000.00"), bonus);
	}
	
}
