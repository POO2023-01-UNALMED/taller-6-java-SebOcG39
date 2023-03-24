package vehiculos;

import java.util.ArrayList;

public class Pais {
    private String nombre;
    public static ArrayList<Pais> listaPaises = new ArrayList<Pais>();
    
    public Pais(String nombre){
        this.nombre = nombre;
        listaPaises.add(this);
    }

    public static Pais paisMasVendedor(){
        int[] cantidades = new int[listaPaises.size()];
        for(int i=0; i<listaPaises.size(); i++){
            cantidades[i] = 0;
        }
        
        int indice = 0;
        for(Pais pais : listaPaises){
            for (Fabricante fabricante:Fabricante.listaFabricante){
                if(fabricante.getPais()==pais){
                    cantidades[listaPaises.indexOf(pais)]++;
                }
            }
        }
        int mayor = cantidades[0];
        for (int i=1; i<cantidades.length; i++){
            if(cantidades[i]>mayor){
                mayor = cantidades[i];
                indice = i;
            }
        }
        
        return listaPaises.get(indice);
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }    
}