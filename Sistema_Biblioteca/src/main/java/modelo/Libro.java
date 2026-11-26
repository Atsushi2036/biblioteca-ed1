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
public class Libro {
    int codigo;
    String titulo;
    String autor;
    int vEdiPagTomo; //Ediciones = 4 bits + Paginas = 10 bits + Tomo = 3 bits = Total: 17 bits
    int año;
    String estado;
    String editorial;
    
    public Libro(int codigo,String tit, String autor, int edicion,int pagi,int tomo,int año,String estado,String editorial){
        if ((edicion >0 && edicion <=15)&&(pagi >0 && pagi <= 1023)&&(tomo>=0&&tomo<=7)){
            this.codigo = codigo;
            this.titulo = tit;
            this.autor = autor;
            this.año = año;
            this.estado = estado;
            this.editorial = editorial;
            int mask = edicion;
            mask = mask << 10;
            mask = mask | pagi;
            mask = mask << 3;
            mask = mask | tomo;
            vEdiPagTomo = mask;
        }
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public void setAutor(String autor){
        this.autor = autor;
    }
    
    public void setEdicion(int edi){
        if (edi > 0 && edi<=15){
            int borrar = (int) Math.pow(2,4) -1;
            borrar = borrar << 13;
            borrar = ~borrar;
            this.vEdiPagTomo = this.vEdiPagTomo & borrar;
            int mask = edi;
            mask = mask << 13;
            this.vEdiPagTomo = this.vEdiPagTomo | mask;
        }
    }
    
    public void setPaginas(int paginas){
        if (paginas > 0 && paginas <= 1023){
            int borrar = (int) Math.pow(2,10) -1;
            borrar = borrar << 3;
            borrar = ~borrar;
            this.vEdiPagTomo = this.vEdiPagTomo & borrar;
            int mask = paginas;
            mask = mask << 3;
            this.vEdiPagTomo = this.vEdiPagTomo | mask;
        }
    }
    
    public void setTomo(int tomo){
        if (tomo > 0 && tomo<= 7){
            int borrar = (int) Math.pow(2,3) -1;
            borrar = ~borrar;
            this.vEdiPagTomo = this.vEdiPagTomo & borrar;
            int mask = tomo;
            this.vEdiPagTomo = this.vEdiPagTomo | mask;
        }
    }
    
    public void setAño(int año){
        this.año = año;
    }
    
    public void setEstado(String est){
        this.estado = est;
    }
    
    public void setEditorial(String edi){
        this.editorial = edi;
    }
    
    public int getCodigo(){
        return this.codigo;
    }
    
    public String getTitulo(){
        return this.titulo;
    }
    
    public String getAutor(){
        return this.autor;
    }
    
    public int getEdiciones(){
        int mask = (int) Math.pow(2,4) - 1;
        int dato = this.vEdiPagTomo;
        dato = dato >> 13;
        dato = dato & mask;
        return dato;
    }
    
    public int getPaginas(){
        int mask = (int) Math.pow(2,10)-1;
        int dato = this.vEdiPagTomo;
        dato = dato >> 3;
        dato = dato & mask;
        return dato;
    }
    
    public int getTomos(){
        int mask = (int) Math.pow(2,3)-1;
        int dato = this.vEdiPagTomo;
        dato = dato & mask;
        return dato;
    }
    
    public String getEstado(){
        return this.estado;
    }
    
    public String getEditorial(){
        return this.editorial;
    }
    //estado,editorial
}
