/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;
/**
 *Classe InputReader
 * @author Rúben Dâmaso
 * @author David Neto
 */
import java.util.Scanner;

public class InputReader {
    /*--Atributos--*/
    private Scanner reader;
    /*--Metodo Contrutor--*/
    public InputReader() {
        reader = new Scanner(System.in);
    }

    /**
    * Metodo que Aprenseta a Questão ao Utilizador de forma formatada
    * @param question {String} - Pergunta
    */
    private void showFormattedQuestion(String question) {
        if(question == null) {
            question = "";
        }
        question += "> ";       
        System.out.print(question);
    }
    /**
    * Metodo que lê o numero real introduzido pelo utilizador
    * @param question {String} - Pergunta a realizar
    * @return {double} - Retorna o valor introduzido
    */
    public double getRealNumber(String question) {
        showFormattedQuestion(question);

        while (!reader.hasNextDouble()) {
            reader.nextLine();
            showFormattedQuestion(question);
        }
        double number = reader.nextDouble();
        reader.nextLine();  
        return number;
    }
    /**
    * Metodo que lê o numero inteiro introduzido pelo utilizador
    * @param question {String} - Pergunta a realizar
    * @return {int} - Retorna o valor introduzido
    */
    public int getIntegerNumber(String question) {
        showFormattedQuestion(question);

        while (!reader.hasNextInt()) {
            reader.nextLine();
            showFormattedQuestion(question);
        }
        int number = reader.nextInt();
        reader.nextLine();  
        return number;
    }
    /**
    * Metodo que lê o texto introduzido pelo utilizador
    * @param question {String} - Pergunta a realizar
    * @return {Strign} - Retorna o valor introduzido
    */
    public String getText(String  question) {
        showFormattedQuestion(question);
        return reader.nextLine();
    }
}
