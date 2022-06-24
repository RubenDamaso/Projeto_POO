/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projeto;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

/**
 * Main do Projeto
 * @author Rúben Dâmaso
 * @author David Neto
 */
public class Projeto {

    public static void showMenu(){
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("|                                          SGE                                      |");
        System.out.println("|                           Sistema de Gestão Empresarial                           |");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("|                 1 - Adicionar Novo Empregado                                      |");
        System.out.println("|                 2 - Verificar Empregado/Visualizar Empregado                      |");
        System.out.println("|                 3 - Inserir Lista de Empregados                                   |");
        System.out.println("|                 4 - Mostrar Todos os Empregados                                   |");
        System.out.println("|                 5 - Mostrar Todos os Empregados por categoria                     |");
        System.out.println("|                 6 - Determinar o número atual de empregados de uma dada categoria |");
        System.out.println("|                 7 - Calcular Salários a Pagar                                     |");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("|                                      0 - Sair                                     |");
        System.out.println("-------------------------------------------------------------------------------------");
    }
    
    
     
    public static void main(String[] args) {
       
        /* Variaveis*/
        int opcMenu = 10;
        int opcEscolha=0;
        
        Empresa empresa = new Empresa();
        InputReader scanner = new InputReader();
         /*Verificação do ficheiro que guarda os Empregados*/
         empresa.CheckFile();
         /*População Dinamica do Array Através do Ficheiro que contêm os Empregados */
         empresa.GetFromFile();
        do{
         showMenu();
         opcMenu = scanner.getIntegerNumber("Opção? : ");
            switch (opcMenu){
                case 1 :
                      empresa.addEmpregado();
                break;
                case 2:
                    int codigoPretendido = scanner.getIntegerNumber("Código do Empregado : ");
                    boolean verificacao = empresa.checkEmpregadoCodigo(codigoPretendido);
                    if(verificacao){
                        System.out.println("Este Empregado existe! Deseja visualizar a sua Informação ? ");
                        System.out.println(" 1 - Sim");
                        System.out.println(" 2 - Nao");
                        opcEscolha = scanner.getIntegerNumber("Opção? : ");
                         switch(opcEscolha){
                            case 1 ->System.out.println(empresa.showEmpregado(codigoPretendido));
                            case 2 ->System.out.println("Ok :)");
                            default ->System.out.println("!!--ERRO OPÇÃO INVÁLIDA--!!");
                        }
                    }
                break;
                case 3:
                   Empregado[] lista = empresa.getListEmpregados();
                   empresa.importEmpregados(lista);
                break;
                case 4:
                    System.out.println(empresa.showAllEmpregados());
                break;
                case 5:
              
                   String OpcEscolhaCategoriaForSearch;
                    System.out.println("----Categoria----");
                    System.out.println("Gestor");
                    System.out.println("Motorista");
                    System.out.println("Comercial");
                    System.out.println("Normal ");
                    OpcEscolhaCategoriaForSearch = scanner.getText("Opção:");
                    empresa.showAllEmpregadosCategoria(OpcEscolhaCategoriaForSearch);
                    
                    
                break;
                case 6:
                    String OpcEscolhaCategoria;
                    System.out.println("----Categoria----");
                    System.out.println("Gestor");
                    System.out.println("Motorista");
                    System.out.println("Comercial");
                    System.out.println("Normal ");
                    OpcEscolhaCategoria = scanner.getText("Opção:");
                    if(empresa.countType(OpcEscolhaCategoria) != 0){
                    System.out.println("Existe " + empresa.countType(OpcEscolhaCategoria) + " Empregados/as da Categoria " + OpcEscolhaCategoria);
                    }
                    else{
                        System.out.println("!!---Não Existem Empregados---!!");
                    }
                break;
                case 7:
                    System.out.println("------------------Simulação de Pagamentos------------------");
                    System.out.println("|                         Mensal                          |");
                    System.out.println("|                         Trimestral                      |");
                    System.out.println("|                         Semestral                       |");
                    System.out.println("|                         Anual                           |");
                    System.out.println("----------------------------------------------------------");
                    String OpcEscolhaTipoDeCalculo = scanner.getText("Calculo Desejado:");
               
                    
                    OpcEscolhaTipoDeCalculo = OpcEscolhaTipoDeCalculo.trim();
                    
                    if(OpcEscolhaTipoDeCalculo.equalsIgnoreCase("Mensal")){
                      System.out.println("| VALOR TOTAL DE SALARIOS A PAGAR ESTE MES " +  String.format("%,.2f", empresa.CalculateSalarios())+ "€ |");
                    }
                    if(OpcEscolhaTipoDeCalculo.equalsIgnoreCase("trimestral")){
                    System.out.println("| VALOR TOTAL DE SALARIOS A PAGAR NO PROXIMO TRIMESTRE : " + String.format("%,.2f", empresa.CalculateSalariosTrimestre(2022)) + "€ |");
                    }
                      else if(OpcEscolhaTipoDeCalculo.equalsIgnoreCase("Semestral")){
                    System.out.println("| VALOR TOTAL DE SALARIOS A PAGAR NO PROXIMO ANO " + String.format("%,.2f", empresa.CalculateSalariosSemestral(2022)) + "€ |");
                    }
                    else if(OpcEscolhaTipoDeCalculo.equalsIgnoreCase("Anual")){
                    System.out.println("| VALOR TOTAL DE SALARIOS A PAGAR NO PROXIMO ANO " + String.format("%,.2f", empresa.CalculateSalariosAnual(2022)) + "€ |");
                    }
                  
                break;
                    case 0:
                        System.out.println("----OBRIGADO----");
                    break;
                default: System.out.println("!!!---ERRO - OPÇÃO INVÁLIDA---!!!");break;
            }
        
        }while(opcMenu != 0);
    }
    
}
