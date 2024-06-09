package list.pesquisa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SomaNumero {
    //atributo
    private List<Integer> numeros;

    public SomaNumero() {
        this.numeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        this.numeros.add(numero);
    }

    public int calcularSoma(){
        int soma = 0;
        for(Integer numero: numeros){
            soma += numero;
        }
        return soma;
    }

    public int encontrarMaiorNumero(){
        int numeroMaior = Integer.MIN_VALUE;
        if(!this.numeros.isEmpty()){
            for (Integer numero : numeros){
                if(numero > numeroMaior){
                    numeroMaior = numero;
                }
            }
        }else {
            throw new RuntimeException("A lista está vazia");
        }
        return numeroMaior;
    }

    public int encontrarMenorNumero(){
        int numeroMenor = Integer.MAX_VALUE;
        if(!this.numeros.isEmpty()){
            for (Integer numero : numeros){
                if(numero < numeroMenor){
                    numeroMenor = numero;
                }
            }
        }else{
            throw new RuntimeException("A lista está vazia");
        }
        return numeroMenor;
    }

    public void exibirNumeros(){
        if(!this.numeros.isEmpty()){
            System.out.println("A lista de números: " + this.numeros);
        }else{
            System.out.println("A lista está vazia");
        }

    }

    public static void main(String[] args) {
        //Criando uma instância da lista de números
        SomaNumero somaNumero = new SomaNumero();

        //Adicionando números na lista
        somaNumero.adicionarNumero(1);
        somaNumero.adicionarNumero(2);
        somaNumero.adicionarNumero(5);
        somaNumero.adicionarNumero(6);
        somaNumero.adicionarNumero(7);
        somaNumero.adicionarNumero(10);
        somaNumero.adicionarNumero(20);

        //Maior número
        System.out.println("O maior número é: " + somaNumero.encontrarMaiorNumero());

        //Menor número
        System.out.println("O menor número é: " + somaNumero.encontrarMenorNumero());

        //exibir a lista de números
        System.out.println("Exibindo lista de números: ");
        somaNumero.exibirNumeros();

        //Soma de números da lista
        System.out.println("A soma da lista deu: " + somaNumero.calcularSoma());
    }

}
