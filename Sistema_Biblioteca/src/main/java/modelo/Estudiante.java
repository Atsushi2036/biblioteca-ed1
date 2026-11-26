/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import negocio.VectorNBits;
/**
 *
 * @author DELL
 */
public class Estudiante {
    int registro;
    int ci;
    String nombre;
    int fecha; // dia: 5 bits + mes: 4 bits + año: 7 bits = 16 bits
    int vCarrera; // 
    char sexo;
    int telefono;
    String direccion;
    
    public Estudiante(int registro,int ci,String nombre,int dia,int mes,int año,int carrera,char sexo,int telefono,String direccion){
        this.registro = registro;
        this.ci = ci;
        this.nombre = nombre;
        this.sexo = sexo;
        this.telefono = telefono;
        this.direccion = direccion;
        int mask = dia;
        mask = mask << 4;
        mask = mask | mes;
        mask = mask << 7;
        int naño = año - 1920;
        mask = mask | naño;
        fecha = mask;
        vCarrera = carrera;
    }
    public void setRegistro(int registro){
        this.registro = registro;
    }
    
    public void setCi(int ci){
        this.ci = ci;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setSexo(char sexo){
        this.sexo = sexo;
    }
    
     public void setTelefono(int telefono){
        this.telefono = telefono;
    }
    
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    
    public void setDia(int dia){
        if (dia>= 1 && dia <=31) {
        int borrar = (int) Math.pow(2, 5);
        borrar = borrar << 11;
        borrar = ~borrar;
        this.fecha = this.fecha & borrar;
        int mask = dia;
        mask = mask << 11;
        this.fecha = this.fecha | mask;                
        }
    }
    
    public void setMes(int mes){
        if (mes>= 1 && mes <=31) {
        int borrar = (int) Math.pow(2, 4);
        borrar = borrar << 7;
        borrar = ~borrar;
        this.fecha = this.fecha & borrar;
        int mask = mes;
        mask = mask << 7;
        this.fecha = this.fecha | mask;                
        }
    }
    
    public void setAño(int año){
        if (año>= 1920 && año <=2026) {
        int borrar = (int) Math.pow(2, 7);
        borrar = ~borrar;
        this.fecha = this.fecha & borrar;
        año = año - 1920;
        int mask = año;
        this.fecha = this.fecha | mask;                
        }
    }
    
    public void setCarrera (){
        //hacerlo con IA
    }
    
    public int getRegistro(){
    return this.registro;
    }
    
    public int getCi(){
    return this.ci;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public int getDia(){
        return this.fecha >>> 11;  
    }
    
    public int getMes(){
        int mes = this.fecha >>> 7;
        mes = mes << 28;
        mes = mes >>> 28;
        return mes;
    }
    public int getAño(){
        int año = this.fecha;
        año = año << 25;
        año = año >>> 25;
        return año;
    }
    public String getCarrera(){
        String carrera = "";
        //hacer con ia
        return carrera;
    }
    
    public String getFacultad(){
        String faculta="";
        //hacer con ia tambien xd
        return faculta;
    }
}
