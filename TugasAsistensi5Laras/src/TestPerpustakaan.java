/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author oktaviana larasati
 */
public class TestPerpustakaan {
    public static void main(String[] args) {
        Scanner baca = new Scanner(System.in);
        buku[] perpus = new buku [10000];
        int n = 3;
        double jumlahHalaman = 900;
        double HalamanFiksi = 0;
        double HalamanNonfiksi = 0;
        double sd = 0;
        double sdf = 0;
        double sdnf = 0;
        Random aja = new Random();
        int fiksi = 0 ;
        int nonfiksi = 0 ;
        
        for (int i = 0 ; i < perpus.length; i++){
            int coinflip = aja.nextInt(2) + 1;
            if (coinflip == 1){
                perpus[i] = new fiksi();
                
            }
           else if (coinflip ==2){
                perpus[i] = new nonfiksi();
            }
            
        }
        for (int i = 0 ; i < 3; i++){
            int coinflip = aja.nextInt(2)+1;
            if (coinflip == 1){
                perpus[i]= new buku ("buku ","Kata","fiksi",300);
                fiksi += 1;
                HalamanFiksi +=300;
                
            }
            if (coinflip == 2){
                perpus[i] = new buku ("buku", "Kata","nonfiksi",300);
                nonfiksi +=1;
                HalamanNonfiksi += 300;
            }
        }
        int pil =1;
        do {
           garis();
           header("PERPUSTAKAAN.txt");
           garis();
            System.out.println("[1]. input buku baru ");
            System.out.println("[2]. modifikasi detail buku ");
            System.out.println("[3]. hapus buku ");
        System.out.println("[0]. EXIT");
        garis();
        
        double ratarata = jumlahHalaman/n;
        for(int i=0; i<n;i++){
            sd = Math.pow((perpus[i].getHalaman()- ratarata),2);
            
        }
        double rataFiksi = HalamanFiksi/fiksi;
        double rataNonFiksi = HalamanNonfiksi/nonfiksi;
        for(int i= 0 ; i<n; i++){
            if(perpus[i].getJenis()=="fiksi"){
                sdf = Math.pow((perpus[i].getHalaman()-rataFiksi), 2);
                
            }else{
                sdnf = Math.pow((perpus[i].getHalaman()- rataNonFiksi),2);
                
            }
        }
                System.out.println("Jumlah buku di perpustakan\t\t: "+n);
                System.out.println("rata-rata halaman buku di perpustakaan \t:"+ratarata);
                System.out.println("Standar deviasi halaman buku di perpustakaan : "+Math.sqrt(sd/n));
                garis();
                System.out.println("Jumlah buku di perpustakan\t\t: "+fiksi);
                System.out.println("rata-rata halaman buku di perpustakaan \t:"+rataFiksi);
                System.out.println("Standar deviasi halaman buku di perpustakaan : "+Math.sqrt(sdf/fiksi));
       garis();
       System.out.println("Jumlah buku di perpustakan\t\t: "+nonfiksi);
                System.out.println("rata-rata halaman buku di perpustakaan \t:"+rataNonFiksi);
                System.out.println("Standar deviasi halaman buku di perpustakaan : "+Math.sqrt(sdnf/nonfiksi));
                garis();
                
                System.out.println("Pilih : ");
                int pilih = baca.nextInt();
                if(pilih == 1){
                    garis();
                    header("BUKUBARU.txt");
                    garis();
                    n +=1;
                    System.out.println("Masukkan Judul Buku : ");
                    String judul = baca.next();
                    perpus[n-1].setJudul(judul);
                    System.out.println("Masukkan Pengarang Buku : ");
                    String pengarang = baca.next();
                    perpus[n-1].setPengarang(pengarang);
                    System.out.println("masukkan Jumlah Halaman : ");
                    int halaman = baca.nextInt();
                    perpus[n-1].setHalaman(halaman);
                    
                    int coinflip = aja.nextInt(2)+1;
                    if(coinflip == 1){
                        perpus[n-1]= new buku (judul,pengarang,"Fiksi", halaman);
                        fiksi +=1;
                        HalamanFiksi += halaman;
                        
                    }
                    
                }else if (pilih == 2){
                    garis();
                    header("UBAHBUKU.txt");
                    garis();
                    System.out.println("pilih Buku yang akan diubah : ");
                    for(int i = 0; i<n; i++){
                        System.out.println("["+(i+1)+"]"+perpus[i].getJudul()+"\t--->\t"+perpus[i].getPengarang());
                        
                    }
                    int UbahBuku = baca.nextInt();
                    System.out.println("Input Judul Buku : ");
                    String judul = baca.next();
                    perpus[UbahBuku-1].setJudul(judul);
                    System.out.println("Masukkan Pengarang Buku :");
                    String pengarang = baca.next();
                    perpus[UbahBuku-1].setPengarang(pengarang);
                    
                    int halLama = perpus[UbahBuku-1].getHalaman();
                    System.out.println("Masukkan Jumlah Halaman Buku : ");
                    int halaman = baca.nextInt();
                    perpus[UbahBuku-1].setHalaman(halaman);
                    jumlahHalaman = jumlahHalaman - halLama + halaman;
                    if(perpus[UbahBuku-1].getJenis()=="fiksi"){
                        HalamanFiksi = HalamanFiksi - halLama + perpus [UbahBuku].getHalaman();
                        
                    }else{
                        HalamanNonfiksi = HalamanNonfiksi - halLama + perpus[UbahBuku].getHalaman();
                    }
                    
                } else if (pilih == 3){
              garis();
              header("HAPUSBUKU.txt");
              garis();
                    System.out.println("Pilih buku yang akan dihapus : ");
                    for(int i = 0 ; i<n; i++){
                        System.out.println("["+(i+1)+"]"+perpus[i].getJudul()+"\t-->"+perpus[i].getPengarang());
                        
                    }
                    int HapusBuku = baca.nextInt();
                    for(int i = HapusBuku; i<n; i++){
                        perpus[i-1]= perpus[i];
                        
                    }
              jumlahHalaman -= perpus[HapusBuku].getHalaman();
              n -= 1;
              if  (perpus[HapusBuku].getJenis()=="fiksi"){
              fiksi -= 1;
              HalamanFiksi -= perpus[HapusBuku].getHalaman();
              
        }else{
                  nonfiksi -= 1;
                  HalamanNonfiksi -= perpus[HapusBuku].getHalaman();
                  
              }
        }else{
                    pil = 0;
                }
                
    }while (pil != 0 );
        String path = "DATA.txt";
        try{
            FileWriter fw = new FileWriter(path);
            BufferedWriter ajah = new BufferedWriter(fw);
            for(int i = 0; i<n; i++){
                int a = i +1;
                ajah.write("Buku ke- ["+ Integer.toString(a)+"]");
                ajah.newLine();
                ajah.write("Judul : "+perpus[i].getJudul());
                ajah.newLine();
                ajah.write("Pengarang : " +perpus[i].getPengarang());
                ajah.newLine();
                ajah.write("Jumlah Halaman : "+Integer.toString(perpus[i].getHalaman()));
                ajah.newLine();
                ajah.write("JenisBuku : "+perpus[i].getJenis());
                ajah.newLine();
                ajah.newLine();
                
            }
            ajah.close();
            
            
        }catch (Exception e){

        }
    }
    public static void garis(){
        System.out.println("================================================================================================================================");
    }
    public static void header (String Perpustakaan){
        File file = new File(Perpustakaan);
        String encoding = "utf-8";
        try(InputStreamReader isr = new InputStreamReader(new FileInputStream(file),encoding)){
            int data = isr.read();
            while (data != -1){
                System.out.print((char)data);
                data = isr.read();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}