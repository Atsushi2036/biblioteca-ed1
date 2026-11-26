/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
/**
 *
 * @author DELL
 */
public class Devolucion {
    int iddevolucion;
    int codlibro;
    int registroest;
    int codpresta;
    int fechaprestamo;
    int fechadevolucion;
    String observacion;
    int horaprestamo;
    
    public Devolucion(Prestamo P){
        this.iddevolucion = 0;
        this.codlibro = P.codlibro;
        this.registroest = P.registroest;
        this.codpresta = P.codpresta;
        this.fechaprestamo = P.fechaprestamo;
        this.fechadevolucion = P.fechadevolucion;
        this.observacion = P.observacion;
        this.horaprestamo = P.horaprestamo;
    }
}
