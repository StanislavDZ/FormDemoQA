package junit;

public class PrimitiveTO {

        public static void main(String args[]) {
            int a = 10, b = 20, c = 25, d = 30, e = 60, f = 13, g =  0;

                // Арифметические операторы
            System.out.println("a + b = " + (a + b));
            System.out.println("a - b = " + (a - b));
            System.out.println("a * b = " + (a * b));
            System.out.println("b / a = " + (b / a));
            System.out.println("b % a = " + (b % a));
            System.out.println("c % a = " + (c % a));
            System.out.println("a++   = " +  (a++));
            System.out.println("b--   = " +  (a--));
                // Проверьте разницу в d++ и ++d
            System.out.println("d++   = " +  (d++));
            System.out.println("++d   = " +  (++d));

                // Операторы сравнения
            System.out.println("a == b = " + (a == b) );
            System.out.println("a != b = " + (a != b) );
            System.out.println("a > b = " + (a > b) );
            System.out.println("a < b = " + (a < b) );
            System.out.println("b >= a = " + (b >= a) );
            System.out.println("b <= a = " + (b <= a) );

                //Побитовые операторы - очень крутая тема, не смог пройти мимо ^_^, разобрался, но где это применяют, ума не приложу...
            g = e & f;
            System.out.println("e & f = " + g );
            g = e | f;
            System.out.println("e | f = " + g );
            g = e ^ f;
            System.out.println("e ^ f = " + g );
            g = ~e;
            System.out.println("~e = " + g );
            g = e << 2;
            System.out.println("e << 2 = " + g );
            g = e >> 2;
            System.out.println("e >> 2  = " + g );
            g = e >>> 2;
            System.out.println("e >>> 2 = " + g );


                //Логические операторы
            boolean h = true, i = false;

            System.out.println("a && b = " + (h&&i));

            System.out.println("a || b = " + (h||i) );

            System.out.println("!(a && b) = " + !(h && i));

            // Разные типы данных + операции над  ними
            byte a1 = 15, a2 = 30;
            short b1 = 20;
            long c1 = 30;
            float d1 = 40;
            double e1 = 50;
            char d2 = 'D', f2 = 'F';

            System.out.println("byte - byte = " + (a1 - a2));
            System.out.println("byte + short = " + (a1 + b1));
            System.out.println("short + long =" + (b1 - c1));
            System.out.println("byte + float =" + (a1 * d1));
            System.out.println("byte + long =" + (a1 / c1));
            System.out.println("double + short =" + (e1 % b1));
            System.out.println("Переполнение byte =" + ((a1 + 118)^a2) + " " + (a2 - 173));
            System.out.println("Char = " + (d2+f2));
   }

}
