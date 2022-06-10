package LambdaPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class C2_StringList_StreamOrnekleri {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();

        list.add("Java");
        list.add("ogrenmek");
        list.add("cok");
        list.add("eglencelidi");
        list.add("lambda");
        list.add("gelince");
        list.add("Daha");
        list.add("da");
        list.add("Cok");
        list.add("Eglenceli");
        list.add("Oldu");

        System.out.println(dcIleBaslayanYaz(dcIleBaslayanYaz(list)));
        yildizliYaz(list);
        System.out.println( alfabetikSiralayalimYaz(list));
        lLeriSil(list);
        System.out.println(eOlanlarinListYaz(list));
        ilkHarfi3KereYaz(list);
        ilkHarfiBykSonrasiKckYaz(list);
        System.out.println(uzunluk4ve6Haric(list));


    }
    // S1: ilk harfi d ve ya c olanlari listeleyelim
        public static List<String> dcIleBaslayanYaz(List<String>list){
        return list.stream().filter(t->t.startsWith("d") || t.startsWith("c")).collect(Collectors.toList());

}

    //S2: tum stringlerin basina ve sonuna yildiz ekleyerek yazdiralim
    public static void yildizliYaz(List<String>list){
        list.stream().map(t-> "*"+t+"*").forEach(t-> System.out.print(t+" "));

    }

    //S3: alfabedik  olarak siralayalim list olarak
    public static List<String> alfabetikSiralayalimYaz(List<String>list){
        System.out.println();
        return list.stream().sorted().collect(Collectors.toList());

    }

    //S4: tum 'l' leri silelim yazdiralim
    public static void lLeriSil(List<String>list){
        list.stream().map(t->t.replaceAll("l","")).forEach(t -> System.out.print(t + " "));

    }

    //S5 : icinde e olanlardan yeni bir list olusturunuz
    public static List<String> eOlanlarinListYaz(List<String>list){
        System.out.println();
        return list.stream().filter(t->t.contains("e")).collect(Collectors.toList());
    }

    // S6 : ilk harfini 3 kere tekrar edip yazalim ornek jjjava gibi
    public static void ilkHarfi3KereYaz(List<String>list){
        System.out.println();
        list.stream().map(t->t.substring(0,1).toUpperCase()+t.substring(0,1).toLowerCase()+t.toLowerCase()).forEach(t -> System.out.println(t));

    }


    // S7: tum elemanlarin ilk harfini buyuk digerlerini kucuk yaziniz
    public static void ilkHarfiBykSonrasiKckYaz(List<String>list){
        System.out.println();
        list.stream().map(t->t.substring(0,1).toUpperCase()+t.substring(1).toLowerCase()).forEach(t -> System.out.println(t));

    }

    // S8: uzunlugu 4 ve 6 olanlar haric bir liste olusturunuz
    public static List<String> uzunluk4ve6Haric(List<String>list){
        System.out.println();
        return list.stream().filter(t->t.length()!=4 && t.length()!=6).collect(Collectors.toList());
    }


}
