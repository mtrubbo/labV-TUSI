package frgp.utn.edu.ar.main;

public class MatrizAdyacencia {

	private boolean[][] _ady;
	private int cantElementos=0;
	
	public MatrizAdyacencia(int cant)
	{
		cantElementos = cant;
		_ady = new boolean[cant][cant];
	}
	
	public void agregarElemento(int i, int j)
	{
		_ady[i][j] = true;
		_ady[j][i] = true;
	}
	
	public void eliminarElemento(int i, int j)
	{
		_ady[i][j] = false;
		_ady[j][i] = false;
	}
	
	public boolean existeElemento(int i, int j)
	{
		return _ady[i][j];
	}
	
	public int getCantidadElementos()
	{
		int cont=0;
		for(int i=0; i<=cantElementos-1; i++)
		{
		   for(int j=0; j<=cantElementos-1; j++)
			   if(_ady[i][j]==true)
				   cont++;
		}
		cont = cont/2;
		return cont;
	}
}
