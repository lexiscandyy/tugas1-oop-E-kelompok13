import java.lang.reflect.Array;
import java.util.ArrayList;
import java.text.*;
import java.util.*;

public class Kamar {
    private static ArrayList<ArrayList<String>> listKamar = new ArrayList<>();
    private static ArrayList<ArrayList<String>> listPenghuni = new ArrayList<>();
    private static ArrayList<Boolean> isTerisi = new ArrayList<>();
    private static ArrayList<String> listHarga = new ArrayList<>();
    NumberFormat rp = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

    public ArrayList<ArrayList<String>> getKamar(){
        return listKamar;
    }
    public ArrayList<ArrayList<String>> getPenghuni(){
        return listPenghuni;
    }
    public ArrayList<Boolean> getIsTerisi(){
        return isTerisi;
    }
    public ArrayList<String> getHarga(){
        return listHarga;
    }

    public void addKamar(){
        listKamar.add(new ArrayList<>());
        listPenghuni.add(new ArrayList<>());
        listHarga.add("Harga belum di set");
        isTerisi.add(false);
    }

    public Boolean removeKamar(int nomorKamar){
        if(nomorKamar > listKamar.size()) return false;
        listKamar.remove(nomorKamar-1);
        listPenghuni.remove(nomorKamar-1);
        isTerisi.remove(nomorKamar-1);
        listHarga.remove(nomorKamar-1);
        return true;
    }

    public Boolean addPenghuni(int nomorKamar, String namaPenghuni){
        if(nomorKamar > listKamar.size()) return false;
        listPenghuni.get(nomorKamar-1).add(namaPenghuni);

        isTerisi.set(nomorKamar-1, true);

        return true;
    }

    public Boolean removePenghuni(int nomorKamar, int nomorPenghuni){
        if(nomorKamar > listKamar.size()) return false;
        if(nomorPenghuni > listPenghuni.get(nomorKamar-1).size()) return false;
        listPenghuni.get(nomorKamar-1).remove(nomorPenghuni-1);

        if(listPenghuni.get(nomorKamar-1).size() == 0) isTerisi.set(nomorKamar-1, false);

        return true;
    }

    public Boolean setHarga(int nomorKamar, String harga){
        if(harga.length() >= 9) return false;
        if(nomorKamar > listKamar.size()) return false;
        for(int i = 0 ;i < harga.length();i++){
            if(harga.charAt(i) < '0' || harga.charAt(i) > '9') return false;
        }
        listHarga.set(nomorKamar-1, rp.format(Integer.parseInt(harga)));
        return true;
    }

    public Boolean addFasilitas(int nomorKamar, String namaFasilitas){
        if(nomorKamar > listKamar.size()) return false;

        listKamar.get(nomorKamar-1).add(namaFasilitas);
        return true;
    }
}
