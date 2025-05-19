package dam.primero.modelos;

import java.util.Objects;

public class Libro {
	private int id_libro;
	private String nombre_libro;
	private String autor_libro;
	private String genero_libro;
	private int anyo_publicacion;
	private String descripcion;

	public Libro(String nombre_libro, String autor_libro, String genero_libro, int anyo_publicacion,
			String descripcion) {
		super();
		this.nombre_libro = nombre_libro;
		this.autor_libro = autor_libro;
		this.genero_libro = genero_libro;
		this.anyo_publicacion = anyo_publicacion;
		this.descripcion = descripcion;
	}

	public Libro() {
		super();
	}

	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}

	public String getNombre_libro() {
		return nombre_libro;
	}

	public void setNombre_libro(String nombre_libro) {
		this.nombre_libro = nombre_libro;
	}

	public String getAutor_libro() {
		return autor_libro;
	}

	public void setAutor_libro(String autor_libro) {
		this.autor_libro = autor_libro;
	}

	public String getGenero_libro() {
		return genero_libro;
	}

	public void setGenero_libro(String genero_libro) {
		this.genero_libro = genero_libro;
	}

	public int getAnyo_publicacion() {
		return anyo_publicacion;
	}

	public void setAnyo_publicacion(int anyo_publicacion) {
		this.anyo_publicacion = anyo_publicacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_libro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return id_libro == other.id_libro;
	}

	@Override
	public String toString() {
		return "Libro [id_libro=" + id_libro + ", nombre_libro=" + nombre_libro + ", autor_libro=" + autor_libro
				+ ", genero_libro=" + genero_libro + ", anyo_publicacion=" + anyo_publicacion + ", descripcion="
				+ descripcion + "]";
	}

}
