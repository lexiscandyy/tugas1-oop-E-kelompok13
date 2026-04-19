import java.util.Scanner;

public class Utils{
    static Scanner sc = new Scanner(System.in);
    public int ScanInt(){
        String str = sc.next();
        boolean ok = true;

        for(int i = 0; i < str.length();i++){
            if(str.charAt(i) < '0' || str.charAt(i) > '9'){
                ok = false;
                break;
            }
        }

        if(str.length() > 10) return -1;
        if(ok) return Integer.parseInt(str);
        return -1;
    }

    public String ScanString(){
        String str = sc.next();
        return str;
    }
}