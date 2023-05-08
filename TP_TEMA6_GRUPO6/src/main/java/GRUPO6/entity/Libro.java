package GRUPO6.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
public class Libro implements Serializable {

	private static final long serialVersionUID = 1L;	
		@Id
	    private String ISBN;
	    private String titulo;
	    private Date fechaLanzamiento;
	    private String idioma;
	    private int cantidadPaginas;
	    @ManyToOne(cascade = {CascadeType.ALL})
	    @JoinColumn(name="IDAutor")
	    private Autor autor;
	    private String descripcion;
	    @ManyToMany(cascade = {CascadeType.ALL})
	    @JoinTable(name="libro_x_generos",joinColumns= {@JoinColumn(name="IDLibro")},inverseJoinColumns= {@JoinColumn(name="IDGenero")})
	    private List<Genero> generos;
	    @ManyToOne(cascade = {CascadeType.ALL})
	    @JoinColumn(name="IDBiblioteca")
	    private Biblioteca biblioteca;
	    
	    public Libro(String ISBN, String titulo, Date fechaLanzamiento, String idioma, int cantidadPaginas, Autor autor, String descripcion, List<Genero> generos, Biblioteca biblioteca) {
	        this.ISBN = ISBN;
	        this.titulo = titulo;
	        this.fechaLanzamiento = fechaLanzamiento;
	        this.idioma = idioma;
	        this.cantidadPaginas = cantidadPaginas;
	        this.autor = autor;
	        this.descripcion = descripcion;
	        this.generos = generos;
	        this.biblioteca = biblioteca;
	    }
	    
	    // Métodos getters y setters para cada atributo
	    
	    public String getISBN() {
	        return ISBN;
	    }
	    
	    public void setISBN(String ISBN) {
	        this.ISBN = ISBN;
	    }
	    
	    public String getTitulo() {
	        return titulo;
	    }
	    
	    public void setTitulo(String titulo) {
	        this.titulo = titulo;
	    }
	    
	    public Date getFechaLanzamiento() {
	        return fechaLanzamiento;
	    }
	    
	    public void setFechaLanzamiento(Date fechaLanzamiento) {
	        this.fechaLanzamiento = fechaLanzamiento;
	    }
	    
	    public String getIdioma() {
	        return idioma;
	    }
	    
	    public void setIdioma(String idioma) {
	        this.idioma = idioma;
	    }
	    
	    public int getCantidadPaginas() {
	        return cantidadPaginas;
	    }
	    
	    public void setCantidadPaginas(int cantidadPaginas) {
	        this.cantidadPaginas = cantidadPaginas;
	    }
	    
	    public Autor getAutor() {
	        return autor;
	    }
	    
	    public void setAutor(Autor autor) {
	        this.autor = autor;
	    }
	    
	    public String getDescripcion() {
	        return descripcion;
	    }
	    
	    public void setDescripcion(String descripcion) {
	        this.descripcion = descripcion;
	    }
	    
	    public List<Genero> getGeneros() {
	        return generos;
	    }
	    
	    public void setGeneros(List<Genero> generos) {
	        this.generos = generos;
	    }
	    
	    public Biblioteca getBiblioteca() {
	        return biblioteca;
	    }
	    
	    public void setBiblioteca(Biblioteca biblioteca) {
	        this.biblioteca = biblioteca;
	    }

	    @Override
	    public String toString() {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	        StringBuilder sb = new StringBuilder();
	        sb.append("ISBN: ").append(this.ISBN).append("\n");
	        sb.append("Título: ").append(this.titulo).append("\n");
	        sb.append("Fecha de Lanzamiento: ").append(dateFormat.format(this.fechaLanzamiento)).append("\n");
	        sb.append("Idioma: ").append(this.idioma).append("\n");
	        sb.append("Cantidad de páginas: ").append(this.cantidadPaginas).append("\n");
	        sb.append("Autor: ").append(this.autor.getNombre()).append("\n");
	        sb.append("Descripción: ").append(this.descripcion).append("\n");
	        sb.append("Géneros: ").append("\n");
	        for (Genero genero : this.generos) {
	            sb.append(" - ").append(genero.getDescripcion()).append("\n");
	        }
	        sb.append("Biblioteca: ").append(this.biblioteca.getIdLibro()).append("\n");

	        return sb.toString();
	    }
	    
	    
}
