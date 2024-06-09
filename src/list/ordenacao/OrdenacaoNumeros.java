package list.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    //atributo
    private List<Integer> numeros;

    public OrdenacaoNumeros() {
        this.numeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        this.numeros.add(numero);
    }

    public List<Integer> ordenarAscendente(){
        List<Integer> numerosAscendente = new ArrayList<>(this.numeros);
        if(!numeros.isEmpty()){
            Collections.sort(numerosAscendente);
        }else{
            System.out.println("A lista está vazia");
        }
        return numerosAscendente;
    }

    public List<Integer> ordenarDescendente(){
        List<Integer> numerosAscendentes = new ArrayList(this.numeros);
        if(!numeros.isEmpty()){
            numerosAscendentes.sort(Collections.reverseOrder());
        }else{
            System.out.println("A lista está vazia");
        }
        return numerosAscendentes;
    }

    public void exibirNumeros(){
        if(!this.numeros.isEmpty()){
            System.out.println(this.numeros);
        }else{
            System.out.println("A lista está vazia");
        }
    }

    public static void main(String[] args) {
        OrdenacaoNumeros numeros = new OrdenacaoNumeros();

        //Adicionando números
        numeros.adicionarNumero(1);
        numeros.adicionarNumero(10);
        numeros.adicionarNumero(13);
        numeros.adicionarNumero(14);
        numeros.adicionarNumero(122);
        numeros.adicionarNumero(123);

        //Exibir os numeros
        System.out.println("Exibir números");
        numeros.exibirNumeros();

        //números ascendente
        System.out.println("Ordenação ascendente");
        System.out.println(numeros.ordenarAscendente());

        //números descendentes
        System.out.println("Ordenação descendente");
        System.out.println(numeros.ordenarDescendente());

        //Exibir os numeros
        System.out.println("Exibir números");
        numeros.exibirNumeros();

    }


}
