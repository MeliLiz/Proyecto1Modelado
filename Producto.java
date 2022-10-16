public class Producto {
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
}
