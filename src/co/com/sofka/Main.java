package co.com.sofka;

public class Main {

    public static void main(String[] args) {
        System.out.println(sumar(8, 2));
        System.out.println(restar(25, 5));
        System.out.println(multiplicar(5, 6));
        System.out.println(dividir(80, 2));
    }

    public static int multiplicar(int num1, int num2) {
        if (num2 >= 1) {
            return sumar(num1, multiplicar(num1, num2 - 1));
        } else {
            return 0;
        }
    }

    public static int dividir(int num1, int num2) {
        if (num2 == 0) {
            System.out.println("ERROR NO SE PUEDE DIVIDIR ENTRE CERO");
            return 0;
        } else {
            if (num1 < num2) {
                return 0;
            } else {
                return 1 + dividir(restar(num1, num2), num2);
            }
        }
    }

    public static int sumar(int num1, int num2) {
        return num1 + num2;
    }

    public static int restar(int num1, int num2) {
        return num1 - num2;
    }
}
