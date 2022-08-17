package br.com.alura.td.service;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusServiceTest {

    @Test
    void bonusDeveriaSerZero() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Peter", LocalDate.now(), new BigDecimal("25000")));

        assertEquals(BigDecimal.ZERO, bonus);
    }

    @Test
    void bonusDeveriaSer10PorCento() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Peter", LocalDate.now(), new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.0"), bonus);
    }

    @Test
    void bonusPadrao() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Peter", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.0"), bonus);
    }
}
