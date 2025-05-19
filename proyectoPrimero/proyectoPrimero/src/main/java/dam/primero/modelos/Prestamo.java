package dam.primero.modelos;

import java.time.LocalDate;
import java.util.Objects;

public class Prestamo {
	private int id_prestamo;
	private int id_libro;
	private int id_usuario;
	private LocalDate fecha_prestamo;
	private LocalDate fecha_devolucion;
	private boolean devuelto;

	public Prestamo(int id_libro, int id_usuario, LocalDate fecha_prestamo, LocalDate fecha_devolucion, boolean devuelto) {
		super();
		this.id_usuario = id_usuario;
		this.id_libro = id_libro;
		this.fecha_prestamo = fecha_prestamo;
		this.fecha_devolucion = fecha_devolucion;
		this.devuelto = devuelto;
	}

	public Prestamo() {
		super();
	}

	public int getId_prestamo() {
		return id_prestamo;
	}

	public void setId_prestamo(int id_prestamo) {
		this.id_prestamo = id_prestamo;
	}

	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public LocalDate getFecha_prestamo() {
		return fecha_prestamo;
	}

	public void setFecha_prestamo(LocalDate fecha_prestamo) {
		this.fecha_prestamo = fecha_prestamo;
	}

	public LocalDate getFecha_devolucion() {
		return fecha_devolucion;
	}

	public void setFecha_devolucion(LocalDate fecha_devolucion) {
		this.fecha_devolucion = fecha_devolucion;
	}

	public boolean isDevuelto() {
		return devuelto;
	}

	public void setDevuelto(boolean devuelto) {
		this.devuelto = devuelto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fecha_prestamo, id_libro, id_prestamo, id_usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prestamo other = (Prestamo) obj;
		return Objects.equals(fecha_prestamo, other.fecha_prestamo) && id_libro == other.id_libro
				&& id_prestamo == other.id_prestamo && id_usuario == other.id_usuario;
	}

	@Override
	public String toString() {
		return "Prestamo [id_prestamo=" + id_prestamo + ", id_libro=" + id_libro + ", id_usuario=" + id_usuario
				+ ", fecha_prestamo=" + fecha_prestamo + ", fecha_devolucion=" + fecha_devolucion + ", devuelto="
				+ devuelto + "]";
	}

}