public class Mesera {

    private Categoria catalogo;

    public Mesera(Categoria catalogo){
        this.catalogo=catalogo;
    }

    public void imprimirCatalogo(){
        catalogo.imprimir();
    }
}
