package dam.primero.dao;

import java.util.List;

import dam.primero.modelos.Libro;

public class PruebasDao {
	public static void main(String[] args) {
		try {
			LibroDao dao = new LibroDao();
			
			List<Libro> lista = dao.buscarLibros("Palabras Radiantes", null, null);
			dao.imprimirLibros(lista);
			
			System.out.println();
			lista = dao.buscarLibros(null, "Brandon Sanderson", null);
			dao.imprimirLibros(lista);
			
			System.out.println();
			lista = dao.buscarLibros(null, null, "Fantasía");
			dao.imprimirLibros(lista);
			
			System.out.println();
			lista = dao.buscarLibros(null, null, null);
			dao.imprimirLibros(lista);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
