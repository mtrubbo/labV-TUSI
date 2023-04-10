package packageTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import frgp.utn.edu.ar.main.MatrizAdyacencia;

class MatrizAdyacenciaTest {

	MatrizAdyacencia ma = new MatrizAdyacencia(3);
	
	@Test
	public void agregarElementoTest() {
		ma.agregarElemento(1, 1);
		assertTrue(ma.existeElemento(1, 1));
	}
	
	@Test
	public void agregarElementoSimetriaTest() {
		ma.agregarElemento(2, 1);
		assertEquals(ma.existeElemento(2, 1), ma.existeElemento(1, 2));
	}
	
	@Test
	public void eliminarElementoTest() {
		ma.eliminarElemento(1, 1);
		assertTrue(!ma.existeElemento(1, 1));
		assertFalse(ma.existeElemento(1, 1));
	}

}
