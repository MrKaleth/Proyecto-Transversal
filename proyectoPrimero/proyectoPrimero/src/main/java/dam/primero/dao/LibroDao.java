package dam.primero.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dam.primero.modelos.Libro;

public class LibroDao extends JdbcDao {

    public LibroDao() throws Exception {
        super();
    }

    public List<Libro> obtenerLibrosBiblioteca() throws SQLException {
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

    public List<Libro> buscarPorTitulo(String titulo) throws SQLException {
        List<Libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM libros WHERE nombre_libro LIKE ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + titulo + "%");
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

    public List<Libro> buscarPorAutor(String autor) throws SQLException {
        List<Libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM libros WHERE autor_libro LIKE ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + autor + "%");
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

    public List<Libro> buscarPorGenero(String genero) throws SQLException {
        List<Libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM libros WHERE genero_libro LIKE ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + genero + "%");
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

    public Libro obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM libros WHERE id_libro = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Libro l = new Libro();
                    l.setId_libro(rs.getInt("id_libro"));
                    l.setNombre_libro(rs.getString("nombre_libro"));
                    l.setAutor_libro(rs.getString("autor_libro"));
                    l.setGenero_libro(rs.getString("genero_libro"));
                    l.setAnyo_publicacion(rs.getInt("anyo_publicacion"));
                    l.setDescripcion(rs.getString("descripcion"));
                    return l;
                }
            }
        }
        return null;
    }
}
