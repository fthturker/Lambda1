package lambdaTutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {
    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));

        printElStuructured(sayi);
        System.out.println("\n   ***   ");
        printElFunctional(sayi);
        System.out.println("\n   ***   ");
        printElFunctional1(sayi);
        System.out.println("\n   ***   ");
        printElFunctional2(sayi);
        System.out.println("\n   ***   ");
        printCiftElSturctured(sayi);
        System.out.println("\n   ***   ");
        printCiftElFunctional(sayi);
        System.out.println("\n   ***   ");
        printCiftElFunctional1(sayi);
        System.out.println("\n   ***   ");
        printCiftOtzKckFunctional(sayi);
        System.out.println("\n   ***   ");
        printCiftOtzBykFunctional(sayi);
        System.out.println("\n   ***   ");
    }

    //Task : "Structured Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.
    public static void printElStuructured(List<Integer> sayi) {
        for (Integer w : sayi) {
            System.out.print(w + " ");
        }
    }
    //Task : "functional Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.

    public static void printElFunctional(List<Integer> sayi) {
        sayi.stream().forEach((t) -> System.out.print(t + " "));
    }

    public static void printElFunctional1(List<Integer> sayi) {
        sayi.stream().forEach(System.out::print);//method reference--> System.out yapısında prin methodu refere et
        // bu action task'deki aynı satıra  ve bosluk ile yazmayı karşılmaz bubun için
        // seed(tohum) method create edilip refere edilmeli
    }

    public static void yazdir(int a) {// verilen int degeri aynı satırda bosluk bırakarak yazdırma action yapan seed(tohum) method create edildi
        System.out.print(a + " ");
    }

    public static void printElFunctional2(List<Integer> sayi) {
        sayi.stream().forEach(Lambda01::yazdir);//method reference--> System.out yapısında prin methodu refere et
    }

    // Task : structured Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftElSturctured(List<Integer> sayi) {
        for (Integer w : sayi) {
            if (w % 2 == 0) {
                System.out.print(w + " ");
            }
        }
    }

    //Task : functional Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftElFunctional(List<Integer> sayi) {

        sayi.
                stream().
                filter(t -> t % 2 == 0).//filter() --> ile icersindeki elemanlari istenen sarta göre filtreleme (secim) yapar
                forEach(Lambda01::yazdir);

    }

    public static boolean ciftBul(int a) {//seed(tohum) method kendisine verile int degerin cift olmasını kontrol eder

        return a % 2 == 0;
    }

    public static void printCiftElFunctional1(List<Integer> sayi) {

        sayi.
                stream().//list elemanlrı akısa alındı
                filter(Lambda01::ciftBul).//cift bul method refere edilerek akısdaki elemalar filtrelendi(cift sayı)
                forEach(Lambda01::yazdir);//fitre den gelen elemanlar yazdır() method refer edilerek print edildi

    }

    //Task :functional Programming ile list elemanlarinin 34 den kucuk cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftOtzKckFunctional(List<Integer> sayi) {
        sayi.
                stream().
                // filter(t -> t % 2 == 0 && t < 34).
                        filter(Lambda01::ciftBul).//method ref.
                filter(t -> t < 34).//lambda exp.
                forEach(Lambda01::yazdir);
    }

//Task : functional Programming ile list elemanlarinin 34 den buyk veya cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void printCiftOtzBykFunctional(List<Integer> sayi) {
        sayi.
                stream().
                filter(t -> t % 2 == 0 || t > 34).//çift veya 34'den buyuk elemanları filtreler 44 63 65 38
                // filter(Lambda01::ciftBul).//method ref.
                // filter(t -> t > 34).//lambda exp.
                        forEach(Lambda01::yazdir);
    }
}
