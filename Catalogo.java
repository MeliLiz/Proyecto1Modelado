import java.util.ArrayList;
import java.util.Iterator;

public class Catalogo {

    private ArrayList<Categoria> categoriasCatalogo;

    public Catalogo() {
        categoriasCatalogo = new ArrayList<Categoria>();
        addCategoria(new Electronica());
        addCategoria(new Electrodomesticos());
        addCategoria(new Alimenticios());
    }

    public ArrayList<Categoria> getCategorias() {
        return categoriasCatalogo;
    }

    public void setCategoriasDisponibles(ArrayList<Categoria> categorias) {
        categoriasCatalogo = categorias;
    }

    public void addCategoria(Categoria categoria) {
        categoriasCatalogo.add(categoria);
    }

    public void eliminarCategoria(Categoria categoria) {
        categoriasCatalogo.remove(categoria);
    }

    public void mostrarCatalogos() {
        for (Categoria categoria : categoriasCatalogo) {
            System.out.println("\n###" + categoria.getNombre() + "##\n");
            Iterator iterador = categoria.crearIterador();
            while (iterador.hasNext()) {
                Producto producto = (Producto) iterador.next();
                System.out.println(producto);
            }
        }
    }

    public Producto buscarProducto(int idProducto) {
        for (Categoria categoria : categoriasCatalogo) {
            Iterator iterador = categoria.crearIterador();
            while (iterador.hasNext()) {
                Producto producto = (Producto) iterador.next();
                if (producto.getCodigoDeBarras().equals(idProducto)) {
                    return producto;
                }
            }
        }
        return null;
    }
}
