package packageTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import frgp.utn.edu.ar.main.MatrizAdyacencia;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MatrizAdyacenciaTest {

	private MatrizAdyacencia ma = new MatrizAdyacencia(5);

	/// A
	@Disabled
	@Test
	public void agregarElementoTest() {
		ma.agregarElemento(1, 1);
		assertTrue(ma.existeElemento(1, 1));
	}

	/// B
	@Disabled
	@Test
	public void agregarElementoSimetriaTest() {
		ma.agregarElemento(3, 2);
		assertEquals(true, ma.existeElemento(2, 3));
	}

	/// C
	@Disabled
	@Test
	public void eliminarElementoTest() {
		ma.agregarElemento(1, 1);
		ma.eliminarElemento(1, 1);
		assertTrue(!ma.existeElemento(1, 1));
		assertFalse(ma.existeElemento(1, 1));
	}

	/// D
	@Disabled
	@Test
	public void eliminarElementoSimetricoTest() {
		ma.agregarElemento(3, 2);
		ma.eliminarElemento(3, 2);
		assertEquals(false, ma.existeElemento(2, 3));
	}

	// e. Crear un mÃ©todo llamado contarRelacionesTest que verifique
	// que el mÃ©todo getCantidadRelaciones de la clase MatrizAdyacencia.
	// Ejemplo: Si agregamos tres elementos [2,3] [1,4] y [1,2] ...
	// hay un total de tres relaciones.}

	/// E
	@Disabled
	@Test
	public void contarRelacionesTest() {
		ma.agregarElemento(2, 3);
		ma.agregarElemento(1, 4);
		ma.agregarElemento(1, 2);

		int resultado = ma.getCantidadElementos();

		assertEquals(3, resultado);
	}

	// f. Verificar que si se completan todos las posiciones de la matriz,
	// todos estos elementos se hayan guardado correctamente
	// en su posiciÃ³n original y en su simetrico.

	/// F
	@Disabled
	@Test
	public void existenTodosLosElementosTest() {
		ma.agregarElemento(1, 2);
		ma.agregarElemento(0, 3);
		ma.agregarElemento(4, 1);

		assertTrue(ma.existeElemento(1, 2));
		assertTrue(ma.existeElemento(2, 1));
		assertTrue(ma.existeElemento(0, 3));
		assertTrue(ma.existeElemento(3, 0));
		assertTrue(ma.existeElemento(4, 1));
		assertTrue(ma.existeElemento(1, 4));
	}

	
	@Test
	public void agregarElementoFilaNegativaTest() throws Exception {

		int fila = -1; // fila negativa
		int columna = 3; // columna válida

		Exception excepcion = assertThrows(IndexOutOfBoundsException.class, () -> {
			ma.agregarElemento(fila, columna); // llama al método agregarElemento con un índice de fila negativo
														
		});

		String mensajeEsperado = "Índice de fila negativo: " + fila;
		String mensajeObtenido = excepcion.getMessage(); // obtiene el mensaje de la excepción

		assertEquals(mensajeEsperado, mensajeObtenido); // verifica que el mensaje de la excepción sea el esperado
	}

	
	@Test
	public void agregarElementoColumnaNegativaTest() {

		    int fila = 2; // fila válida
	        int columna = -1; // columna negativa
	        
	        Exception excepcion = assertThrows(IndexOutOfBoundsException.class, () -> {
	            ma.agregarElemento(fila, columna); // llama al método agregarElemento con un índice de columna negativo
	        });
	        
	        String mensajeEsperado = "Índice de columna negativo: " + columna;
	        String mensajeObtenido = excepcion.getMessage(); // obtiene el mensaje de la excepción
	        
	        assertEquals(mensajeEsperado, mensajeObtenido); // verifica que el mensaje de la excepción sea el esperado

	}

	
	@Test
	public void agregarElementoFueraRangoTest()  {
		
		int fila = 1; // fila válida
        int columna = 6; // columna fuera de rango
        
        Exception excepcion = assertThrows(IndexOutOfBoundsException.class, () -> {
            ma.agregarElementoFueraRango(fila, columna); // llama al método agregarElemento con una columna fuera de rango
        });
        
        String mensajeEsperado = "Índice de fila o columna fuera de rango: (" + fila + ", " + columna + ")";
        String mensajeObtenido = excepcion.getMessage(); // obtiene el mensaje de la excepción
        
        assertEquals(mensajeEsperado, mensajeObtenido); // verifica que el mensaje de la excepción sea el esperado

	}

}
