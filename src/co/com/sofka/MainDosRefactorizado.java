package co.com.sofka;


import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class MainDosRefactorizado {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> sumar = getSumar();
        BiFunction<Integer, Integer, Integer> restar = getRestar();
        BiFunction<Integer, Integer, Integer> multiplicar = getMultiplicar(sumar);
        BiFunction<Integer, Integer, Integer> dividir = getDividir(sumar, multiplicar);


        System.out.println(sumar.apply(-2, 7)); // 5
        System.out.println(restar.apply(35, 20)); // 15
        System.out.println(multiplicar.apply(5, 5)); // 25
        System.out.println(dividir.apply(60, 2)); // 30
        System.out.println(dividir.apply(5, 0)); // Respuesta Illegal
    }

    private static BiFunction<Integer, Integer, Integer>
    getDividir(BiFunction<Integer, Integer, Integer> sumar, BiFunction<Integer, Integer, Integer> multiplicar) {
        return (num1, num2) -> {
            if (num2.equals(0) || num1.equals(0)) {
                throw new IllegalArgumentException("El numerador o denominador no puede estar definido en cero.");
            }
            return IntStream.range(0, num1)
                    .reduce((acomulador, numero) ->
                            multiplicar.apply(numero, num2) <= num1 ? sumar.apply(acomulador, 1) : acomulador).orElse(0);

        };
    }

    private static BiFunction<Integer, Integer, Integer> getMultiplicar(BiFunction<Integer, Integer, Integer> sumar) {
        return (num1, num2) -> IntStream.range(0, num2 + 1)
                .reduce((acomulador, numero) -> sumar.apply(acomulador, num1)).getAsInt();
    }

    private static BiFunction<Integer, Integer, Integer> getRestar() {
        return (num1, num2) -> num1 - num2;
    }

    private static BiFunction<Integer, Integer, Integer> getSumar() {
        return Integer::sum;
    }
}
