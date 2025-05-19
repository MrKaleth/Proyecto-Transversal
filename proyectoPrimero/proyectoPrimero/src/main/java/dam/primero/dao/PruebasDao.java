package dam.primero.dao;

import java.util.List;

import dam.primero.modelos.Libro;

public class PruebasDao {
	public static void main(String[] args) {
		try {
			LibroDao libroDao = new LibroDao();
			
			List<Libro> l1 = libroDao.buscarPorAutor("Brandon Sanderson");
			List<Libro> l2 = libroDao.buscarPorGenero("Fantasía");
			List<Libro> l3 = libroDao.buscarPorTitulo("Palabras Radiantes");
			
			System.out.println("Libros por Brandon Sanderson");
			libroDao.imprimirLibros(l1);
			System.out.println();
			System.out.println("Libros de Fantasía");
			libroDao.imprimirLibros(l2);
			System.out.println("Busqueda de Libro concreto");
			libroDao.imprimirLibros(l3);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
