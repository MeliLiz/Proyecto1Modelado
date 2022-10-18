import java.util.Iterator;

public class Catalogo {

    private Categoria catalogo;
    
    public Catalogo(String nombreCatalogo){
        catalogo=new Categoria("Catalogo "+nombreCatalogo);
        actualizar();
    }

    private void actualizar(){

        catalogo.eliminarSubcategorias();

        //Categoria Electronica
        Categoria electronica=new Categoria("Electronica");
        //agregamos la categoria al catalogo
        catalogo.add(electronica);
        //Hacemos las subcategorias de electronica
        Categoria celulares=new Categoria("Celulares");
        Categoria computadoras=new Categoria("Computadoras");
        //Agregamos las subcategorias de electronica
        electronica.add(celulares);
        electronica.add(computadoras);
        //Agregamos los productos a las subcategorias correspondientes
        celulares.add(new CelularHwahuauA530());
        celulares.add(new CelularXiami16plus());
        computadoras.add(new ComputadoraAsisVivBook());



        //Categoria electrodomesticos
        Categoria electrodomesticos=new Categoria("Electrodomesticos");
        //Agregamos la categoria al catalogo
        catalogo.add(electrodomesticos);
        //Hacemos las subcategorias de electrodomesticos
        Categoria hornos=new Categoria("Hornos");
        Categoria licuadoras=new Categoria("Licuadoras");
        //Agregamos las subcategorias de electrodomesticos
        electrodomesticos.add(hornos);
        electrodomesticos.add(licuadoras);
        //Agregamos los productos a las subcategorias correspondientes
        hornos.add(new HornoOstormini());
        hornos.add(new MicroondasSmsungA100());
        licuadoras.add(new LicuadoraBlckDeckerSWL());


        //Categoria alimenticios
        Categoria alimenticios=new Categoria("Alimenticios");
        catalogo.add(alimenticios);
        Categoria lacteos=new Categoria("Lacteos");
        Categoria enlatados=new Categoria("Enlatados");
        alimenticios.add(lacteos);
        alimenticios.add(enlatados);
        lacteos.add(new QuesoPanelaFudi());
        lacteos.add(new YogurtNaturalAlpuma());
        enlatados.add(new ChicharosHerdz());
    }

    public void imprimirCatalogo(){
        catalogo.imprimir();
    }

    public void imprimirCategoria(String categoria){
        int indice = catalogo.haySubcategoria(categoria);
        if(indice!=-1){
            ComponenteCatalogo subcategoria=catalogo.getHijo(indice);
            subcategoria.imprimir();
        }else{
            System.out.println("No existe la categoria "+ categoria);
        }
    }

    public static void main(String[] args) {
        Catalogo catalogo=new Catalogo("Prueba");
        //catalogo.imprimirCatalogo();
        catalogo.imprimirCategoria("Electronica");
    }

}
