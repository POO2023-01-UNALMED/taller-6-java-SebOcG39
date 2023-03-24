package vehiculos;

import java.util.ArrayList;


public class Fabricante {
    private String nombre;
    private Pais pais;
    public static ArrayList<Fabricante> listaFabricante= new ArrayList<Fabricante>();

    public Fabricante(String nombre, Pais pais){
        this.nombre = nombre;
        this.pais = pais;
        listaFabricante.add(this);
    }
    
    public static Fabricante fabricaMayorVentas(){
        int[] cantidades = new int[listaFabricante.size()];
        for(int i=0; i<listaFabricante.size(); i++){
            cantidades[i] = 0;
        }
        
        int indice = 0;
        for(Fabricante fabrica : listaFabricante){
            for (Vehiculo vehiculo:Vehiculo.listaVehiculos){
                if(vehiculo.getFabricante()==fabrica){
                    cantidades[listaFabricante.indexOf(fabrica)]++;
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
        
        return listaFabricante.get(indice);
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
    
    
}
