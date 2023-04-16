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

	/// a. Crear un método llamado agregarElementoTest, que verifique que
	//luego de agregar un elemento este elemento exista dentro de la matriz

	@Disabled
	@Test
	public void agregarElementoTest() {
		ma.agregarElemento(1, 1);
		assertTrue(ma.existeElemento(1, 1));
	}

	/// B Crear un método llamado agregarElementoSimetriaTest, que
	//verifique que luego de agregar un elemento, ese exista en su posición
	//opuesta/simétrica. Ejemplo, si agrego un elemento en la posición [2,3],
	//verificar que se haya agregado el elemento [3,2]
	@Disabled
	@Test
	public void agregarElementoSimetriaTest() {
		ma.agregarElemento(3, 2);
		assertEquals(true, ma.existeElemento(2, 3));
	}

	/// C . Crear un método llamado eliminarElementoTest, que verifique que
	//luego de eliminar un elemento este elemento no exista dentro de la
	//matriz

	@Disabled
	@Test
	public void eliminarElementoTest() {
		ma.agregarElemento(1, 1);
		ma.eliminarElemento(1, 1);
		assertTrue(!ma.existeElemento(1, 1));
		assertFalse(ma.existeElemento(1, 1));
	}

	/// D Crear un método llamado eliminarElementoSimetricoTest, que
	//verifique que luego de eliminar un elemento también elimine su simétrico.
	//Ejemplo, si elimino el elemento de la posición [2,3], verificar que se haya
	//eliminado el elemento [3,2]
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

	//Crear un método llamado agregarElementoFilaNegativaTest
	//que verifique que, si uno quiere agregar un elemento en una fila
	//negativa, éste arroje una excepción.

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

	
	//Crear un método llamado agregarElementoColumnaNegativaTest
	//que verifique que, si uno quiere agregar un elemento en una columna
	//negativa, éste arroje una excepción.

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

	
	//Crear un método llamado agregarElementoFueraRangoTest que
	//verifique que, si uno quiere agregar un elemento en una columna fuera
	//del rango, éste arroje una excepción. Ejemplo: si tenemos una matriz de
	//2x2,(dos filas, dos columnas) probar que si uno quiere agregar en la
	//columna 3 o fila 3, se arroje una excepción
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
