package dam.primero.modelos;

import java.time.LocalDate;
import java.util.Objects;

public class Usuario {
	private int id_usuario;
	private String nombre_usuario;
	private String apellidos_usuario;
	private String email_usuario;
	private String telefono_usuario;
	private LocalDate fecha_registro;

	public Usuario(String nombre_usuario, String apellidos_usuario, String email_usuario, String telefono_usuario,
			LocalDate fecha_registro) {
		super();
		this.nombre_usuario = nombre_usuario;
		this.apellidos_usuario = apellidos_usuario;
		this.email_usuario = email_usuario;
		this.telefono_usuario = telefono_usuario;
		this.fecha_registro = fecha_registro;
	}

	public Usuario() {
		super();
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getApellidos_usuario() {
		return apellidos_usuario;
	}

	public void setApellidos_usuario(String apellidos_usuario) {
		this.apellidos_usuario = apellidos_usuario;
	}

	public String getEmail_usuario() {
		return email_usuario;
	}

	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}

	public String getTelefono_usuario() {
		return telefono_usuario;
	}

	public void setTelefono_usuario(String telefono_usuario) {
		this.telefono_usuario = telefono_usuario;
	}

	public LocalDate getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(LocalDate fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return id_usuario == other.id_usuario;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nombre_usuario=" + nombre_usuario + ", apellidos_usuario="
				+ apellidos_usuario + ", email_usuario=" + email_usuario + ", telefono_usuario=" + telefono_usuario
				+ ", fecha_registro=" + fecha_registro + "]";
	}

}
