import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] arg){
        int inp = new InputNumber().Scan();
        if(inp == -1){
            System.out.println("input tidak valid");
            return;
        }else System.out.println(inp);
    }
}
