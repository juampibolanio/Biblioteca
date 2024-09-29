public class Libro {
    private String nombre;
    private String autor;
    private int isbn;
    
    
    public Libro(String nombre, String autor, int isbn) {
        this.nombre = nombre;
        this.autor = autor;
        this.isbn = isbn;
    }


    @Override
    public String toString() {
        return "Libro: " + nombre + " - Autor: " + autor + " - ISBN: " + isbn ;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getAutor() {
        return autor;
    }


    public void setAutor(String autor) {
        this.autor = autor;
    }


    public int getIsbn() {
        return isbn;
    }


    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    
    
}
