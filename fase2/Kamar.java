import java.lang.reflect.Array;
import java.util.ArrayList;
import java.text.*;
import java.util.*;

public class Kamar {
    private int nomorKamar;
    private Penghuni penghuni;
    private boolean isTerisi;
    private int harga;
    private ArrayList<String> fasilitas = new ArrayList<>();

    public Kamar(int nomorKamar, int harga){
        if(nomorKamar<=0) throw new IllegalArgumentException("Nomor kamar tidak valid");
        this.nomorKamar = nomorKamar;
        this.harga = harga;
        this.penghuni = new Penghuni("BELUM ADA PENGHUNI", "-");
        this.isTerisi = false;
    }

    public void addFasilitas(String namaFasilitas){
        fasilitas.add(namaFasilitas);
    }

    // SETTER

    public void setPenghuni(String nama, String notelp){
        this.isTerisi = true;
        penghuni.setNama(nama);
        penghuni.setNoTelp(notelp);
    }

    public void setHarga(int n){
        if(n <= 0) throw new IllegalArgumentException("Harga tidak valid");
        if(n < 500000 || n > 5e6) throw new IllegalArgumentException("HARGA TIDAK MASUK AKAL");
        this.harga = n;
    }

    public void setIsTerisi(boolean cek){
        this.isTerisi = cek;
    }

    // GETTER
    public ArrayList<String> getFasilitas(){
        return fasilitas;
    }

    public int getNomorKamar(){
        return nomorKamar;
    }
    public Penghuni getPenghuni(){
        return penghuni;
    }
    public boolean getIsTerisi(){
        return isTerisi;
    }
    public int getHarga(){
        return harga;
    }
}
