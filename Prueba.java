public class Prueba {
    public static void main(String[] args) {

        //Podemos tener una clase con una lista de categorias y subcategorias y la clase que crea las categorias las agrega directamente a esa lista teniendo una referencia al objeto de la clase con la lista

        Categoria catalogo=new Categoria("Catalogo");

        Categoria electronica=new Categoria("Electronica");
        Categoria electrodomesticos=new Categoria("Electrodomesticos");
        Categoria alimenticios=new Categoria("Alimenticios");

        catalogo.add(electronica);
        catalogo.add(electrodomesticos);
        catalogo.add(alimenticios);

        Categoria celulares=new Categoria("Celulares");
        Categoria computadoras=new Categoria("Computadoras");
        Categoria hornos=new Categoria("Hornos");
        Categoria licuadoras=new Categoria("Licuadoras");
        Categoria lacteos=new Categoria("Lacteos");
        Categoria enlatados=new Categoria("Enlatados");

        electronica.add(celulares);
        electronica.add(celulares);
        electrodomesticos.add(hornos);
        electrodomesticos.add(licuadoras);
        alimenticios.add(lacteos);
        alimenticios.add(enlatados);

        celulares.add(new CelularHwahuauA530());
        celulares.add(new CelularXiami16plus());

        computadoras.add(new ComputadoraAsisVivBook());

        hornos.add(new HornoOstormini());
        hornos.add(new MicroondasSmsungA100());

        licuadoras.add(new LicuadoraBlckDeckerSWL());

        lacteos.add(new QuesoPanelaFudi());
        lacteos.add(new YogurtNaturalAlpuma());

        enlatados.add(new ChicharosHerdz());

        Mesera mesera=new Mesera(catalogo);
        mesera.imprimirCatalogo();
    }
}
