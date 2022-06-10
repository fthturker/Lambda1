import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {
        System.out.println("TASK 01 -->" + toplaAmele(10));
        System.out.println("TASK 01 -->" + toplaCincix(10));
        System.out.println("   ***   ");

        System.out.println("TASK 02 -->" + toplaCift(10));
        System.out.println("   ***   ");

        System.out.println("TASK 03 -->" + toplaIlkXCift(10));
        System.out.println("   ***   ");

        System.out.println("TASK 04 -->" + toplaIlkXTek(10));
        System.out.println("   ***   ");

        System.out.println("TASK 05 -->");
        ikininIlkXKuvvetPrint(5);
        System.out.println("   ***   ");

        System.out.println("TASK 06 -->");
        istenenSayiIlkXKuvvetPrint(4, 3);
        System.out.println("   ***   ");
        istenenSayiIlkXKuvvetPrint(3, 4);
        System.out.println("   ***   ");

        System.out.println("TASK 07 -->" + istenenSayiFaktPrint(5));
        System.out.println("   ***   ");

        System.out.println("TASK 08 -->" + istenenSayiXKuvvettPrint(4, 3));
        System.out.println("TASK 08 -->" + istenenSayiXKuvvettPrint(3, 4));
        System.out.println("   ***   ");

    }
    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program create ediniz.
    //Structured(AMELE) Programming
    public static int toplaAmele(int x) {
        int toplam = 0;
        for (int i = 1; i <= x; i++) {
            toplam += i;
        }
        return toplam;
    }
    //Functional(cincix Programming
    public static int toplaCincix(int x) {
        return IntStream.
                range(1, x + 1). // 1 den x'e kadar (x dahil x+1 haric) int degerler akısa alindi
                        sum(); //akıs daki int degerler toplami
    }
    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int toplaCift(int x) {
        return IntStream.
                rangeClosed(1, x).// 1 den x'e kadar (x dahil int degerler akısa alindi
                        filter(Lambda01::ciftBul).// akısdaki cift int degerler filtrelendi
                        sum(); //akıs daki int degerler toplami
    }
    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    public static int toplaIlkXCift(int x) {
        return IntStream.
                iterate(2, t -> t + 2).// 2 den sonsuz'a kadar elemanları 2 arttırarak akısa alir--->2,4,6,8,10,.....
                        limit(x). //akisdaki ilk x int degeri akısa alir
                        sum(); //akıs daki int degerler toplami
        //iterate(seed, repeat action) --> seed'den başlayarak repeat action'a göre  sonsuza kadar elemanları akısa koyar
    }
    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int toplaIlkXTek(int x) {
        return IntStream.
                iterate(1, t -> t + 2).// 1 den sonsuz'a kadar elemanları 2 arttırarak akısa alir--->1,3,5,7,9,.....
                        limit(x). //akisdaki ilk x int degeri akısa alir
                        sum(); //akıs daki int degerler toplami
    }
    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikininIlkXKuvvetPrint(int x) {
        IntStream.
                iterate(2, t -> t + 2).// 2 den sonsuz'a kadar elemanları 2 ile carparak akısa alir--->2,4,6,8,10,.....
                limit(x). //akisdaki ilk x int degeri akısa alir
                forEach(Lambda01::yazdir);
    }
    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void istenenSayiIlkXKuvvetPrint(int istenenSayi, int x) {
        IntStream.
                iterate(istenenSayi, t -> t * istenenSayi).// 2 den sonsuz'a kadar elemanları 2 ile carparak akısa alir--->2,4,6,8,10,.....
                limit(x). //akisdaki ilk x int degeri akısa alir
                forEach(Lambda01::yazdir);
    }
    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    public static int istenenSayiFaktPrint(int x) {
        return IntStream.
                rangeClosed(1, x).
                //reduce(Math::multiplyExact).
                        reduce(1, (t, u) -> t * u);
    }
    //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.
    public static int istenenSayiXKuvvettPrint(int istenenSayi, int x) {
        return //Math.pow(istenenSayi,x)
                IntStream.
                        iterate(istenenSayi, t -> t * istenenSayi).
                        limit(x).
                        reduce(0, (t, u) -> u);
        // return Math.pow(istenenSayi,x);
    }
}
