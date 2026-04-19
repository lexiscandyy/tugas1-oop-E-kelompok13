import java.util.Scanner;

public class InputNumber{
    public int Scan(){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        boolean ok = true;

        for(int i = 0; i < str.length();i++){
            if(str.charAt(i) < '0' || str.charAt(i) > '9'){
                ok = false;
                break;
            }
        }

        if(str.length() > 10){
            return -1;
        }
        if(ok){
            return Integer.parseInt(str);
        }
        return -1;
    }

}