package dam.primero.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dam.primero.modelos.Libro;

public class LibroDao extends JdbcDao {

	public LibroDao() throws Exception {
		super();
	}

	public List<Libro> obtenerListadoCompleto() throws SQLException {
		List<Libro> biblioteca = new ArrayList<>();
		String sql = "SELECT * FROM libros";
		try (Connection conn = getConnection();
				PreparedStatement st = conn.prepareStatement(sql);
				ResultSet rs = st.executeQuery()) {

			while (rs.next()) {
				Libro l = new Libro();
				l.setId_libro(rs.getInt("id_libro"));
				l.setNombre_libro(rs.getString("nombre_libro"));
				l.setAutor_libro(rs.getString("autor_libro"));
				l.setGenero_libro(rs.getString("genero_libro"));
				l.setAnyo_publicacion(rs.getInt("anyo_publicacion"));
				l.setDescripcion(rs.getString("descripcion"));
				biblioteca.add(l);
			}
		}
		return biblioteca;
	}

	public boolean insertarLibro(Libro libro) throws SQLException {
		String sql = "INSERT INTO libros(nombre_libro, autor_libro, genero_libro, anyo_publicacion, descripcion) "
				+ "VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			ps.setString(1, libro.getNombre_libro());
			ps.setString(2, libro.getAutor_libro());
			ps.setString(3, libro.getGenero_libro());
			ps.setInt(4, libro.getAnyo_publicacion());
			ps.setString(5, libro.getDescripcion());

			int filas = ps.executeUpdate();
			if (filas > 0) {
				try (ResultSet keys = ps.getGeneratedKeys()) {
					if (keys.next()) {
						libro.setId_libro(keys.getInt(1));
					}
				}
				return true;
			}
			return false;
		}
	}

	public List<Libro> buscarLibros(String titulo, String autor, String genero) throws SQLException {
		List<Libro> lista = new ArrayList<>();
		StringBuilder sql = new StringBuilder("SELECT * FROM libros WHERE 1=1");
		List<Object> params = new ArrayList<>();

		if (titulo != null && !titulo.isBlank()) {
			sql.append(" AND nombre_libro LIKE ?");
			params.add("%" + titulo + "%");
		}
		if (autor != null && !autor.isBlank()) {
			sql.append(" AND autor_libro LIKE ?");
			params.add("%" + autor + "%");
		}
		if (genero != null && !genero.isBlank()) {
			sql.append(" AND genero_libro LIKE ?");
			params.add("%" + genero + "%");
		}

		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql.toString())) {

			for (int i = 0; i < params.size(); i++) {
				ps.setObject(i + 1, params.get(i));
			}

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Libro l = new Libro();
					l.setId_libro(rs.getInt("id_libro"));
					l.setNombre_libro(rs.getString("nombre_libro"));
					l.setAutor_libro(rs.getString("autor_libro"));
					l.setGenero_libro(rs.getString("genero_libro"));
					l.setAnyo_publicacion(rs.getInt("anyo_publicacion"));
					l.setDescripcion(rs.getString("descripcion"));
					lista.add(l);
				}
			}
		}
		return lista;
	}

	public void imprimirLibros(List<Libro> libros) {
		if (libros == null || libros.isEmpty()) {
			System.out.println("No se han encontrado libros.");
			return;
		}
		for (Libro l : libros) {
			System.out.println("–––––––––––––––––––––––––––––––––––");
			System.out.printf("ID:               %d%n", l.getId_libro());
			System.out.printf("Título:           %s%n", l.getNombre_libro());
			System.out.printf("Autor:            %s%n", l.getAutor_libro());
			System.out.printf("Género:           %s%n", l.getGenero_libro());
			System.out.printf("Año publicación:  %d%n", l.getAnyo_publicacion());
			System.out.printf("Descripción:      %s%n", l.getDescripcion());
		}
		System.out.println("–––––––––––––––––––––––––––––––––––\n");
	}
}
