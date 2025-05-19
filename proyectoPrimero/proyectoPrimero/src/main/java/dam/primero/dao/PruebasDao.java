package dam.primero.dao;

public class PruebasDao {
	public static void main(String[] args) {
		try {
			LibroDao libroDao = new LibroDao();
			
			System.out.println(libroDao.buscarPorAutor("Brandon Sanderson"));
			System.out.println(libroDao.buscarPorGenero("Fantasía"));
			System.out.println(libroDao.buscarPorTitulo("Palabras Radiantes"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
