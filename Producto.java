import java.util.Iterator;

public class Producto extends ComponenteCatalogo implements Componentes{
    private String codigoDeBarras;
    private String nombre;
    private String departamento;
    public double precio;

    public Producto(String codigoDeBarras, String nombre, String departamento, double precio){
        this.codigoDeBarras=codigoDeBarras;
        this.nombre=nombre;
        this.departamento=departamento;
        this.precio=precio;
    }

    public String getCodigoDeBarras(){
        return codigoDeBarras;
    }

    public String getNombre(){
        return nombre;
    }

    public String getDepartamento(){
        return departamento;
    }

    public double getPrecio(){
        return precio;
    }

    @Override
    public void imprimir() {
        System.out.println("\n"+nombre+"\n"+precio+"\nCodigo de barras: "+codigoDeBarras);
    }

    /**
     * Metodo para crear un iterador de productos
     * @return Iterator El iterador de los productos, un iterador nulo
     */
    @Override
    public Iterator crearIterador() {
        return new IteradorNulo();
    }
}
