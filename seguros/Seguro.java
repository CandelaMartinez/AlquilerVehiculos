
package actividadT09.seguros;

import actividadT09.vehiculos.IAlquilable;

/**
 *
 * @author Candela
 */
//Crea en el package actividadT09.seguros 
//una clase Seguro que implemente la interfaz IAlquilable
public class Seguro implements IAlquilable {
    //Atributos propios de clase
    //Nombre del seguro, Descripción, Precio alquiler por dia, El número de días que se alquila (por defecto 1).
    private String nombreSeguro;
    private String descripcion;
    private int numeroDiasAlquila=1;
    private double precioTotal;
    //El precio de alquiler del seguro es de 10.50€ por día, no se puede modificar. 
    private final double precioAlquilerSeguroPorDia;
 
    /****************************************************************************/
    //constructor
    public Seguro(String nombreSeguro, String descripcion){
        this.nombreSeguro=nombreSeguro;
        this.descripcion=descripcion;
        this.precioAlquilerSeguroPorDia=10.5;
        }
    /****************************************************************************/
    //Metodos heredados de la interface IAlquilable
     @Override
    public void setNumeroDias(int dias) {
        numeroDiasAlquila=dias;
    }

    @Override
    public double getPrecioTotalAlquilerPorDias() {
        double precioXdia=this.getPrecioAlquilerXDia();
        int dias= this.getNumeroDiasAlquila();
        precioTotal= dias*precioXdia;
        return precioTotal;
    }
    /****************************************************************************/
    //Metodos propios
    
     //Sobrescribe toString() para que retorne toda la información del seguro, incluido el precio total
    public String toString(){
       String informacion= "Seguro: "+this.getNombreSeguro()+" Descripcion: "+ this.getDescripcion()+" Precio del alquiler por dia: "+this.getPrecioAlquilerXDia()
               + " Total de dias que se quiere alquilar "+ this.getNumeroDiasAlquila()+ " Precio total de alquiler por todos los dias "+ this.getPrecioTotalAlquilerPorDias();
       return informacion;
        
        
    }
    
    //getters setters

    public String getNombreSeguro() {
        return nombreSeguro;
    }

    public void setNombreSeguro(String nombreSeguro) {
        this.nombreSeguro = nombreSeguro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public int getNumeroDiasAlquila() {
        return numeroDiasAlquila;
    }
   
    public double getPrecioAlquilerXDia(){
        return precioAlquilerSeguroPorDia;
    }
    
      

 

   
}
