/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import modelo.Estudiante;
import modelo.Libro;
/**
 *
 * @author DELL
 */
public class Prestamo {
    int idprestamo;
    int codlibro;
    int registroest;
    int codpresta;
    int fechaprestamo;
    int fechadevolucion;
    String observacion;
    int horaprestamo;
    
    public Prestamo(Estudiante E,Libro L, Prestatario P,int dia,int mes,int año,int diad,int mesd,String obs,int hora,int min){
        if ((año > 25)&&(año<28)){
            this.idprestamo = 0;
            this.codlibro = L.codigo;
            this.registroest = E.registro;
            this.codpresta = P.codigo;
            int mask = dia;
            int mask1= diad;
            mask = mask << 4;
            mask = mask | mes;
            mask = mask << 1;
            
            mask1 = diad;
            mask1 = mask1 << 4;
            mask1= mask1 | mesd;
            mask1 = mask1 << 1;
            if (año == 26){
                mask = mask | 0;
                mask1 = mask| 0;
            } else {
                mask = mask | 1;
                mask = mask| 1;
            }
            this.fechaprestamo = mask;
            this.fechadevolucion = mask1;
            this.observacion = obs;
            mask = hora;
            mask = mask << 6;
            mask = mask | min;
            this.horaprestamo = mask;
        }
    }
}
