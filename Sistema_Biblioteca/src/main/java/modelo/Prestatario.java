/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author DELL
 */
public class Prestatario {
    int codigo;
    String Nombre;
    int ci;
    int fecha;  // dia: 5 bits + mes: 4 bits + año: 7 bits = 16 bits
    char sexo;
    int telefono;
    
    public Prestatario(int cod,String Nombre,int ci,int dia,int mes,int año,char sex,int tele){
        this.codigo = cod;
        this.Nombre = Nombre;
        this.ci = ci;
        int mask = dia;
        mask = mask << 4;
        mask = mask | mes;
        mask = mask << 7;
        int naño = año - 1920;
        mask = mask | naño;
        this.fecha = mask;
        this.sexo = sex;
        this.telefono = tele;
    }
    
    //Setters
    
    public void Setcog(int cod){
        this.codigo = cod;
    }
    
    public void setnombre(String nom){
        this.Nombre=nom;
    }
    
    public void setci(int Ci){
        this.ci=Ci;
    }
    
    public void setsexo(char sexo){
        this.sexo=sexo;
        
    }
    
    public void settel(int tele){
        this.telefono=tele;
    }
    
   public void SetDia(int dia){
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
    
    public void SetMes(int mes){
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
    
    public void SetAño(int año){
        if (año>= 1920 && año <=2026) {
        int borrar = (int) Math.pow(2, 7);
        borrar = ~borrar;
        this.fecha = this.fecha & borrar;
        año = año - 1920;
        int mask = año;
        this.fecha = this.fecha | mask;                
        }
    }
    
    //Getters
    
    public int getcod(){
        return codigo;
    }
    
    public String getNom(){
        return Nombre;
    }
    
    public int getci(){
        return ci;
    }
    
    public char getsexo(){
        return sexo;
    }
    
    public int gettelefono(){
        return telefono;
    }
    
    public int getDia(){
        return this.fecha >> 11;  
    }
    
    public int getMes(){
        int mes = this.fecha >> 7; //32-4
        mes = mes << 28;
        mes = mes >>>28;
        return mes;
    }
    public int getAño(){
        int año = this.fecha; //32-7
        año = año << 25;
        año = año >>>25;
        return año;
    }
}
