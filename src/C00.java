import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class C00 {
    public static void main(String[] args) {
        System.out.println("TASK 01 -->" + toplamAmele(10));
        System.out.println("TASK 01 -->" + toplamCincix(10));
        System.out.println("   ***   ");

        System.out.println("TASK 02 -->" + toplaCift(10));
        System.out.println("   ***   ");

        System.out.println("TASK 03 -->" + toplaIlkXCift(10));
        System.out.println("   ***   ");

        System.out.println("TASK 04 -->" + toplaIlkXTek(10));
        System.out.println("   ***   ");

        System.out.println("TASK 05 -->");
        ikininIlkXKuvvetPrint(3);
        System.out.println("   ***   ");

        System.out.println("TASK 06 -->");
        istenenSayiIlkXKuvvetPrint(4, 3);
        System.out.println("   ***   ");
        istenenSayiIlkXKuvvetPrint(3, 4);
        System.out.println("   ***   ");

        System.out.println("   ***   ");

        System.out.println("TASK 07 -->" + istenenSayiFaktPrint(5));
        System.out.println("   ***   ");

        System.out.println("TASK 08 -->" + istenenSayiXKuvvetPrint(4, 4));
        System.out.println("   ***   ");

        System.out.println("Yavuz");
    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program create ediniz.
    //Structured(AMELE) Programming
    public static int toplamAmele(int x) {
        int toplam = 0;
        for (int i = 1; i <= x; i++) {
            toplam += i;
        }
        return toplam;
    }

    //Functional(cincix Programming
    public static int toplamCincix(int x) {
        return IntStream.range(1, x + 1).sum();
    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int toplaCift(int x) {
        return IntStream.rangeClosed(1, x).filter(Lambda01::ciftBul).sum();
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    public static int toplaIlkXCift(int x) {
        return IntStream.iterate(2, t -> t + 2).limit(x).sum();
    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int toplaIlkXTek(int x) {
        return IntStream.iterate(1, t -> t + 2).limit(x).sum();
    }

    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikininIlkXKuvvetPrint(int x) {
        IntStream.iterate(2, t -> t * 2).limit(x).forEach(Lambda01::yazdir);
    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void istenenSayiIlkXKuvvetPrint(int istenenSayi, int x) {
        IntStream.iterate(istenenSayi, t -> t * istenenSayi).limit(x).forEach(Lambda01::yazdir);
    }

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    public static int istenenSayiFaktPrint(int x) {
        return IntStream.rangeClosed(1, x).reduce(1, (t, u) -> t * u);
    }

    //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.
    public static int istenenSayiXKuvvetPrint(int x, int istenenSayi) {
        return IntStream.iterate(istenenSayi, t -> t * istenenSayi).limit(x).reduce(0, (t, u) -> u);


    }

}
