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
    public Libro buscarLibro(String nombreBuscado) {
        for (Libro libro : listaLibros) {
            if (libro.getNombre().equalsIgnoreCase(nombreBuscado)) {
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
        Libro libro = buscarLibro(libroAModificar.getNombre());
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
    //ordenar libros
    public void ordenarLibros() {
    Collections.sort(listaLibros, new Comparator<Libro>() {

        public int compare(Libro libro1, Libro libro2) {
            return libro1.getNombre().compareToIgnoreCase(libro2.getNombre());
        }
    });
    System.out.println("Los libros han sido ordenados alfabéticamente.");
}
    //mostrar menú de biblioteca
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

        switch (opcion) {
            case 1:
                    System.out.println("- Ingrese el nombre del libro: ");
                    String nombre = sc.nextLine();
                    System.out.println("- Ingrese el nombre del autor: ");
                    String autor = sc.nextLine();
                    System.out.println("Ingrese el número de ISBN: ");
                    int isbn = sc.nextInt();
                    sc.nextLine();

                    Libro newLibro = new Libro(nombre, autor, isbn);
                    agregarLibro(newLibro);
                    System.out.println("- Libro agregado correctamente.");
                break;
            case 2:
                    System.out.println("- Ingrese el nombre del libro que desea buscar: ");
                    String nomLibroBuscado = sc.nextLine();
                    Libro libroEncontrado = buscarLibro(nomLibroBuscado);
                    if (libroEncontrado != null) {
                        System.out.println("Libro encontrado: " + libroEncontrado);
                    } else {
                    System.out.println("El libro no fue encontrado."); }
                    break;
            case 3:
                    System.out.println("Ingrese el nombre del libro que desea eliminar: ");
                    String nomLibroEliminar = sc.nextLine();
                    Libro libroAEliminar = buscarLibro(nomLibroEliminar);
                    if (libroAEliminar != null) {
                        eliminarLibro(libroAEliminar);
                    } else {
                        System.out.println("No se ha encontrado el libro.");
                    }
                    break;
            case 4:
                    System.out.println("- Ingrese el medio por el cual desea modificar el libro: ");
                    System.out.println("1. Modificar por nombre ");
                    System.out.println("2. Modificar por índice ");
                    System.out.println("- Seleccione una opción: ");
                    int option = sc.nextInt();
                    sc.nextLine();

                    switch (option) {
                        case 1:
                                System.out.println("- Ingrese el nombre del libro que desea modificar: ");
                                String nomLibro = sc.nextLine();
                                Libro libroAModif = buscarLibro(nomLibro);
                                if (libroAModif != null) {
                                    System.out.println("Ingrese el nuevo nombre del libro: ");
                                    String newNombre = sc.nextLine();
                                    System.out.println("Ingrese el nuevo nombre de autor: ");
                                    String newAutor = sc.nextLine();
                                    System.out.println("Ingrese el nuevo ISBN: ");
                                    int newISBN = sc.nextInt();
                                    sc.nextLine();
                                        
                                    modificarLibroPorNombre(libroAModif, newNombre, newAutor, newISBN);
                                }
                                break;
                        case 2:
                                System.out.println("- Ingrese el N° de índice del libro que desea modificar: ");
                                int indice = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Ingrese el nuevo nombre del libro: ");
                                String nNombre = sc.nextLine();
                                System.out.println("Ingrese el nuevo nombre de autor: ");
                                String nAutor = sc.nextLine();
                                System.out.println("Ingrese el nuevo ISBN: ");
                                int nISBN = sc.nextInt();
                                sc.nextLine();
                                modificarLibroPorIndice(indice, nNombre, nAutor, nISBN);
                                break;

                        default:
                                System.out.println("Opción no válida, intente nuevamente.");
                                break;
                        }
                    break;
            case 5:
                    ordenarLibros();
                    break;
            case 6: 
                    listarLibros();
                    break;
            default:
                    break;
            }
        
        } while (opcion != 0);
        sc.close();
    }
    }