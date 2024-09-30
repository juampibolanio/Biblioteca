import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList <Libro> listaLibros = new ArrayList<>();
        Biblioteca biblioteca = new Biblioteca(listaLibros);

        biblioteca.mostrarMenu();


        sc.close();
    }
}