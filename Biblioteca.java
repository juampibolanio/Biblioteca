import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Biblioteca {
    private ArrayList <Libro> listaLibros = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public Biblioteca(ArrayList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    //agregar un nuevo libro
    public void agregarLibro(Libro libro) {
        listaLibros.add(libro);
        System.out.println("-[ Libro agregado correctamente ]- ");
    }

    //buscar un libro
    public Libro buscarLibro(Libro libroBuscado) {
        for (Libro libro : listaLibros) {
            if (libro.getNombre().equals(libroBuscado.getNombre())) {
                return libro;
        }
    }
    return null; 
}

    //eliminar libro
    public void eliminarLibro(Libro libroAEliminar) {
        int posicionAEliminar = listaLibros.indexOf(libroAEliminar);

        if (posicionAEliminar != -1) {
            System.out.println("Se eliminó el libro: " + libroAEliminar.getNombre());
            listaLibros.remove(posicionAEliminar);
        } else {
            System.out.println("El libro no fue encontrado.");
        }
    }

    //modificar un libro por nombre
    public void modificarLibroPorNombre(Libro libroAModificar, String nombre, String autor, int isbn) {
        Libro libro = buscarLibro(libroAModificar);
        if (libro != null) {
            libro.setNombre(nombre);
            libro.setAutor(autor);
            libro.setIsbn(isbn);
            System.out.println("Datos de libro actualizados.");
        } else {
            System.out.println("El libro no fue encontrado.");
        }
    }
    
    //modificar libro por índice
    public void modificarLibroPorIndice(int indice, String nuevoNombre, String nuevoAutor, int nuevoIsbn) {
        if (indice >= 0 && indice < listaLibros.size()) {
            Libro libro = listaLibros.get(indice);
            
            // Modificamos sus datos
            libro.setNombre(nuevoNombre);
            libro.setAutor(nuevoAutor);
            libro.setIsbn(nuevoIsbn);
            
            System.out.println("El libro en la posición " + indice + " ha sido modificado.");
        } else {
            System.out.println("Índice fuera de rango.");
        }
    }
    
    //listar libros
    public void listarLibros() {
        if (listaLibros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca. ");
        } else {
            System.out.println("=== Lista de libros ===");
            for (Libro libro : listaLibros) {
                System.out.println(libro);
            }
        }
    }

    public void ordenarLibros() {
    Collections.sort(listaLibros, new Comparator<Libro>() {

        public int compare(Libro libro1, Libro libro2) {
            return libro1.getNombre().compareToIgnoreCase(libro2.getNombre());
        }
    });
    System.out.println("Los libros han sido ordenados alfabéticamente.");
}

public void mostrarMenu() {
    int opcion;
    do {
        System.out.println("---- Menú de Biblioteca ----");
        System.out.println("1. Agregar libro");
        System.out.println("2. Buscar libro");
        System.out.println("3. Eliminar libro");
        System.out.println("4. Modificar libro");
        System.out.println("5. Ordenar libros");
        System.out.println("6. Mostrar todos los libros");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        opcion = sc.nextInt();
        sc.nextLine(); 

        
    } while (opcion != 0);
}
}
