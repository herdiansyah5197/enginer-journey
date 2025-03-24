package id.hds.exercise.service;

import java.util.Scanner;

public class JavaOutputFormating {



    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++){
            String s1=sc.next();
            int x=sc.nextInt();
            //membaca panjang character y
            String y = String.valueOf(x);
            //menginsiasi panjang chaccter y
            y = y.length()==2?"0".concat(y):y.length()==1?"00".concat(y):y;
            //menginisasi spasi
            String z = " ";
            //maximal charcter
            int max = 14;
            //jumlah chaccter input
            int s2 = s1.length();
            int maxTable =  max-s2;

            for (int j = 0; j<maxTable;j++){
                String o = " ";
                z = z.concat(o);
            }
            System.out.println(s1.concat(z).concat((y)));
        }
        System.out.println("================================");

    }

//    ================================ SUCCESS ===== Yuhu
//    java           100
//    cpp            065
//    python         050
//    ================================
//
}
