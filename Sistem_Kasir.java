/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 * @author HP
 */
public class Sistem_Kasir {
    static int buah, sayur, makan, minum, pilihan, hasilB = 0, hasilS = 0, 
            hasilMakan = 0, hasilMinum = 0, diskonP, hasilDiskon, m, sm, p1, 
            p2, jBuah, jSayur, jMakan, jMinum,pil,uang, kembalian;
    double hargaB, hargaS, hargaSN, hargaM; 
    static String nama,dbtA,dbtT,dbtA2,pil2,pil3;
    public static void main(String[] args) {
     Scanner sc = new Scanner (System.in);
        
        bacaInput();
        hitungIsi(); 
        diskonPromo();
        System.out.println("keterangan :\n0 tidak\n1 ya");
        adaMemb();
        metodePem();
        do{
        System.out.println("Konfirmasi Pembayaran: ");
        System.out.print("Setuju(Y)/Tidak Setuju(N)");
        pil2=sc.next();
        if("Y".equals(pil2)||"y".equals(pil2)){
            kembalian = uang-sm;
        }else if("N".equals(pil2)||"n".equals(pil2)){
            System.out.print("Ganti Metode Pembayaran?(Y/N)");
            pil3=sc.next();
            if("Y".equals(pil3)||"y".equals(pil3)){
                metodePem();
            }else if("N".equals(pil3)||"n".equals(pil3)){
                System.out.println("Kembali ke Konfirmasi Pembayaran");
            }
        }
        }while("N".equals(pil3)&&"N".equals(pil2)||"n".equals(pil3)&&"n".equals(pil2));

        nota();

    }
    static void bacaInput(){
        System.out.println("Pilih Menu Belanjaan yang Ingin Anda Hitung ");
        System.out.println("1. Buah\n2. Sayur\n3. Makanan/Snack\n4. Minuman\n5. Keluar");
    }
    static void hitungIsi(){
        Scanner sc = new Scanner (System.in);
        do {
        System.out.print("Pilihan : ");
        pilihan = sc.nextInt();
        if (pilihan== 1){
            System.out.print("Masukkan Jumlah Buah : ");
            jBuah = sc.nextInt();
            for (int i = 1; i <= jBuah; i++){
                System.out.print("Masukkan Harga Buah ke "+i+" : ");
                int hB = sc.nextInt();
                hasilB+=hB;  
            }
        }
        else if (pilihan == 2){
            System.out.print("Masukkan Jumlah Sayur : ");
            jSayur = sc.nextInt();
            for (int i = 1; i <= jSayur; i++){
                System.out.print("Masukkan Harga Sayur ke "+i+" : ");
                int hS = sc.nextInt();
                hasilS+=hS;
            }
        }
        else if (pilihan == 3){
            System.out.print("Masukkan Jumlah Makanan : ");
            jMakan = sc.nextInt();
            for (int i = 1; i <= jMakan; i++){
                System.out.print("Masukkan Harga Makanan ke "+i+" : ");
                int hMakan = sc.nextInt();
                hasilMakan+=hMakan;
            }
        }
        else if (pilihan == 4){
            System.out.print("Masukkan Jumlah Minuman : ");
            jMinum = sc.nextInt();
            for (int i = 1; i <= jMinum; i++){
                System.out.print("Masukkan Harga Minuman ke "+i+" : ");
                int hMinum = sc.nextInt();
                hasilMinum+=hMinum;
            }
        }
        else if (pilihan == 5){
        }
        }while(pilihan!=5);  
    }
    static int hitungTotal(){
        int total = hasilS+hasilB+hasilMakan+hasilMinum; 
        return total;
    }
    static int diskonPromo(){
        Scanner sc = new Scanner (System.in);
        System.out.print("Masukkan Diskon yang Didapatkan (%) : ");
        diskonP = sc.nextInt();
        hasilDiskon = (hitungTotal()*diskonP)/100;
        return hasilDiskon;
    }
    static int adaMemb(){
        Scanner sc = new Scanner(System.in);
        System.out.print("ada Member?");
        m = sc.nextInt();
        
        if(m==0){
            sm = setelahDiskon();
        }else if(m==1){
            System.out.print("jumlah poin?");
            p1 = sc.nextInt();
            switch(p1){
                case 20:
                    System.out.print("dipakai? ");
                    p2 = sc.nextInt();
                    if(p2==0){
                        sm=setelahDiskon();
                    }else if (p2==1){
                        sm = (int) (setelahDiskon()-(setelahDiskon()*0.2));
                    }break;
                default :
                    System.out.println("poin tidak cukup");
                    sm= setelahDiskon();
                    break;
            }  
        }
        return sm;
    }
    static void dapatPoin(){
    if(hitungTotal()>=50000){
        System.out.println("Poin didapat \t\t\t\t5");
    }else{
        System.out.println("Poin didapat \t\t\t\t0");
    }
    }
    static void metodePem(){
        Scanner sc=new Scanner(System.in);
        System.out.println("yang harus dibayarkan : "+sm);
        System.out.println("1. Cash\n2. Debit\n(No.Rek=8917428123)");
        do{
            System.out.print("Pilih Metode Pembayaran: ");
            pil=sc.nextInt();
        }while(pil<1&&pil>3);
        switch (pil) {
            case 1:
                System.out.print("Masukan Jumlah Uang: ");
                uang=sc.nextInt();
                break;
            case 2:
                System.out.print("Masukan Nomor Rekening Anda: ");
                dbtA=sc.next();
                System.out.print("Masukan Jumlah Uang: ");
                uang=sc.nextInt();
                do{
                    System.out.print("Masukan Nomor Rekening Toko: ");
                    dbtT=sc.next();
                }while(!("8917428123".equals(dbtT)));
                break;
            default:
                break;
        }  
    }
    static int setelahDiskon(){
        int setelah_disk = (hitungTotal()-hasilDiskon);
        return setelah_disk;
    }
    static void printIsi(){
        if(jBuah==0){
        }else if(jBuah!=0){
            System.out.println("Buah\t\t"+jBuah+"\t\t\tRp "+hasilB);
        }if(jSayur==0){
        }else if(jSayur!=0){
            System.out.println("Sayur\t\t"+jSayur+"\t\t\tRp "+hasilS);
        }if(jMakan==0){
        }else if(jMakan!=0){
            System.out.println("Snack\t\t"+jMakan+"\t\t\tRp "+hasilMakan);
        }if(jMinum==0){
        }else if(jMinum!=0){
            System.out.println("Minuman\t\t"+jMinum+"\t\t\tRp "+hasilMinum);
        }
    }
    static void nota(){
        Scanner in = new Scanner  (System.in);
        System.out.println("\n\n==========================================================");
        System.out.println("----------------------- Toko Utama -----------------------");
        System.out.println("==========================================================");
        System.out.print("Nama Pembeli : ");
        nama = in.nextLine();
        System.out.println("Kategori\tJumlah Barang\t\tJumlah Harga");
        printIsi();
        System.out.println("==========================================================");
        System.out.println("Total Harga\t\t\t\tRp "+hitungTotal());
        System.out.println("Mendapat diskon sebesar\t\t\t"+"Rp "+hasilDiskon);
        System.out.println("Total Harga Setelah Diskon\t\t"+"Rp "+setelahDiskon());
        System.out.println("Harga Setelah Diskon Member\t\tRp "+sm);
        dapatPoin();
        System.out.println("==========================================================");
        System.out.println("Total uang yang dibayarkan\t\tRp "+uang);
        System.out.println("Kembalian\t\t\t\tRp "+kembalian);
        System.out.println("==========================================================");
        System.out.println("======= TERIMA KASIH TELAH BERBELANJA DI TOKO KAMI =======");
        

    }
    }
    

