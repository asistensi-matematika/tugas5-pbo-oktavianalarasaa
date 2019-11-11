/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oktaviana larasati
 */
public class Perpustakaan {
    
}
class buku extends Perpustakaan{
    private String judul, pengarang;
    private int halaman;
    private String jenis;
    public buku (){
       judul = "null";
       pengarang = "null";
       halaman = 0;
       jenis = "null";
               
    }
    public buku(String judul, String pengarang, String jenis, int halaman){
         this.judul = judul;
    this .pengarang = pengarang;
    this.halaman = halaman;
    this.jenis = jenis;
    }
       

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getJudul() {
        return judul;
    }

    public int getHalaman() {
        return halaman;
    }

    public void setHalaman(int halaman) {
        this.halaman = halaman;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    public void print(){
        System.out.println("Judul : "+judul+"\nPengarang : "+pengarang+"\nhalaman"
                + halaman+"\nJenis : "+jenis);
        
    }
    public String print2 (){
        return "Judul : "+judul+"\n | Pengarang : "+pengarang+ "\n | Halaman : "
                +"\n | Jenis : "+jenis;
    }
    public String jarak (){
        return "                                            " +"";
    }
}
class nonfiksi extends buku {
    private String jenisBuku;
    public nonfiksi(){
        super();
        jenisBuku = "Non Fiksi";
        
    }
    public nonfiksi (String jenisBuku, String judul, String pengarang , String jenis , int halaman){
        super (judul, pengarang, jenis, halaman);
        this.jenisBuku = jenisBuku;
    }
    public String getJenisBuku(){
        return jenisBuku;
    }
}

class fiksi extends buku {
    private String jenisBuku;
    
    public fiksi(){
        super();
        jenisBuku = "fiksi";
        
    }
    public fiksi(String jenisBuku, String judul, String pengarang, String jenis, int halaman){
        super(judul, pengarang, jenis, halaman);
        this.jenisBuku = jenisBuku;
        
        
    }

    public String getJenisBuku() {
        return jenisBuku;
    }

    public void setJenisBuku(String jenisBuku) {
        this.jenisBuku = jenisBuku;
    }
    
}