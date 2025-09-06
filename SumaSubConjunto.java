public class SumaSubConjunto {
    public static boolean haySubconjunto(int[] conjunto, int n, int objetivo) { // Método recursivo

        // Caso base: si el objetivo es 0, fue encontrado
        if (objetivo == 0) {
            return true;
        }
        // Si no hay elementos o el objetivo es negativo, no se puede
        if (n == 0 || objetivo < 0) {
            return false;
        }

        // Caso recursivo: Hay dos opciones
        //                   Excluir el último elemento  Ó  Incluir el último elemento y reducir el objetivo
        return haySubconjunto(conjunto, n - 1, objetivo) || haySubconjunto(conjunto, n - 1, objetivo - conjunto[n - 1]);
    }

    public static void main(String[] args) {
        int[] conjunto = {3, 34, 4, 12, 5, 2};
        int objetivo = 14;

        if (haySubconjunto(conjunto, conjunto.length, objetivo)) {
            System.out.println("Sí existe un subconjunto que suma " + objetivo);
        } else {
            System.out.println("No existe un subconjunto que sume " + objetivo);
        }
    }
}
