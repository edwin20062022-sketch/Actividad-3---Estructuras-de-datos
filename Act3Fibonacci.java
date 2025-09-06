public class Act3Fibonacci {
    public static int calcularSerie(int n) { // Función recursiva
        if (n == 0) { //  \
            return 0; //   > Caso base. Cuando n es igual a 0 se retorna 0
        }             //  / 

        else if (n == 1) { //  \
            return 1;      //   > Caso base. Cuando n es igual a 1 se retorna 1
        }                  //  /

        return calcularSerie(n - 1) + calcularSerie(n - 2); // Caso recursivo. 
        // Cuando n es mayor a 1 se calcula la suma de los dos anteriores
    }
    public static void main(String[] args) {
        int n = 5;
        // Hice un bucle for para mostrar los valores de cada número
        for (int i = 0; i < n + 1; i++) {
            System.out.print(calcularSerie(i) + " ");
        }
        
    }
}