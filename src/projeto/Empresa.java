/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList; 
import java.util.Random;
import java.util.Scanner;

/**
 *Classe Empresa
 * @author Rúben Dâmaso
 * @author David Neto
 */

public class Empresa {
    
     /*----Atributos----*/
     private final ArrayList<Empregado> empregadoList;
     private final double salarioBase;
     private final InputReader scanner;
     private enum meses{
         JANEIRO(23),
         MARCO(23),
         ABRIL(22),
         MAIO(23),
         JUNHO(22),
         JULHO(23),
         AGOSTO(23),
         SETEMBRO(22),
         OUTUBRO (23),
         NOVEMBRO(22),
         DEZEMBRO(23);   
         
         
         
         
         private int dias;
         meses(int dias){
            this.dias=dias;
         }
         
         public int getDias(){
            return this.dias;
         }
         
     }
  
     
    /*---Metodo Construtor---*/
    /**
    * Metodo Construtor para a Empresa sem qualquer valor passado por parametro
    * 
    */
    public Empresa(){
        this.empregadoList = new ArrayList<>();
        this.scanner = new InputReader();
        this.salarioBase = 4.79;
    }
    /**
    * Metodo Construtor para a Empresa com o valor do salario base passado por parametro
    *
    * @param salarioBase {Double} - Valor do Salario Base da Empresa
    */
    public Empresa(int salarioBase){
     this.empregadoList = new ArrayList<>();
     this.scanner = new InputReader();
     if(salarioBase>0){
      this.salarioBase = salarioBase;
     }else this.salarioBase = 4.79;
   }
      
    /**
    * Função que adiciona um empregado à empresa
    */
    public void addEmpregado(){
     
       //Variaveis
       int opc;
       boolean checkNome;
       boolean checkDiasDeTrabalho;
       boolean checkQuilometros;
       boolean checkTaxaPorQuilometro;
       boolean checktTaxaPorVendas;
       boolean checkVendas;
       
       String nome;
       int diasDeTrabalho;
       int quilometros;
       int vendas;
       double taxaPorVendas;
       double taxaPorQuilometro;
       System.out.println("-----! NOVO EMPREGADO !-----");
       
       /*--- Recolha de dados ---*/
       do{    
        nome = scanner.getText("Nome:");
         if (checkStringIsNumber(nome)){
             System.out.println("!!-- O nome do funcionário só pode conter Letras --!!");
             checkNome = false;
         }
         else if(nome.isBlank()){
            System.out.println("!!-- O nome do funcionário não Pode estar vazio --!!");
             checkNome = false;
         }
         else{
              checkNome = true;
         }
       }while(checkNome != true);
       
       int idEmpregado = this.empregadoList.size() + 1 ;
       
       do{    
         diasDeTrabalho = scanner.getIntegerNumber("Dias de Trabalho do mês atual:");
         if (diasDeTrabalho < 0 || diasDeTrabalho > 23){
             System.out.println("!!-- Os dias de Trabalho Mensais têm de ser superiores a 0 e inferiores a 23 dias uteis--!!");
             checkDiasDeTrabalho = false;
         }
         else{
              checkDiasDeTrabalho = true;
         }
       }while(checkDiasDeTrabalho != true);
       
       do{
       System.out.println("Categoria:");
       System.out.println(" 1 - Gestor");
       System.out.println(" 2 - Motorista");
       System.out.println(" 3 - Comercial");
       System.out.println(" 4 - Normal ");
       opc = scanner.getIntegerNumber("Opção:");
       }while(opc <= 0 || opc >4 );
       
       switch(opc){
           case 1:
               Empregado novoEmpregadoGestor = new Gestor(nome,idEmpregado,diasDeTrabalho,this.salarioBase);
               this.empregadoList.add(novoEmpregadoGestor);
           break;
           case 2:
                     /*Recolha dos Quilometros Percorridos*/
                      do{    
                        quilometros = scanner.getIntegerNumber("Quilometros Percorridos:");
                        if (quilometros < 0){
                            System.out.println("!!-- Os quilometros Percorridos têm de ser superiores a 0--!!");
                            checkQuilometros = false;
                        }
                        else{
                             checkQuilometros = true;
                        }
                      }while(checkQuilometros != true);
                      
                      /*Recolha da Taxa Por Quilometro*/
                      do{    
                        taxaPorQuilometro = scanner.getRealNumber("Taxa por quilometro:");
                        if (taxaPorQuilometro < 0){
                            System.out.println("!!-- A taxa têm de ser superior a 0--!!");
                            checkTaxaPorQuilometro = false;
                        }
                        else{
                             checkTaxaPorQuilometro = true;
                        }
                      }while(checkTaxaPorQuilometro != true);
                      
                      
               Empregado novoEmpregadoMotorista = new Motorista(nome,idEmpregado,diasDeTrabalho,quilometros,taxaPorQuilometro,this.salarioBase);
               this.empregadoList.add(novoEmpregadoMotorista);
           break;
            case 3:
                     /*Recolha das Vendas Realizadas*/
                      do{    
                        vendas = scanner.getIntegerNumber("Vendas:");
                        if (vendas < 0){
                            System.out.println("!!--Vendas têm de ser superiores a 0--!!");
                            checkVendas = false;
                        }
                        else{
                             checkVendas = true;
                        }
                      }while(checkVendas != true);
                      
                      /*Recolha da Taxa Por Venda*/
                      do{    
                        taxaPorVendas = scanner.getRealNumber("Taxa por venda:");
                        if (taxaPorVendas < 0){
                            System.out.println("!!-- A taxa têm de ser superior a 0--!!");
                            checktTaxaPorVendas = false;
                        }
                        else{
                             checktTaxaPorVendas = true;
                        }
                      }while(checktTaxaPorVendas != true);
                      
                      
               Empregado novoEmpregadoComercial = new Comerciais(nome,idEmpregado,diasDeTrabalho,vendas,taxaPorVendas,this.salarioBase);
               this.empregadoList.add(novoEmpregadoComercial);
           break;
           case 4 :
               Empregado novoEmpregado = new Normal(nome,idEmpregado,diasDeTrabalho,this.salarioBase);
               this.empregadoList.add(novoEmpregado);
           break;    
       
       }
       /*Escrever no Ficheiro o novo Empregado*/
        this.Write(this.empregadoList);
        System.out.println("--!Empregado adicionado com sucesso!--");
            
    }
    
    /**
    * Função que verifica se a String contem numeros
    *@param string {String} String a ser verificada 
    * @return  {true} -> Se existir numeros 
    * 
    */
    public boolean checkStringIsNumber(String string){
      boolean check=false;
      for(int i=0; i<string.length();i++){
                try {
                    int intValue = Integer.parseInt(string.charAt(i)+"");
                    check = true;
                } catch (NumberFormatException e) {
                    check = false;  
                }
            }
     return check;
    }
    
    /**
    * Função que verifica se a Lista de Empregados está vazia
    * @return  {true} -> Se estiver vazia 
    * 
    */  
    public boolean isEmpty(){
      return this.empregadoList.isEmpty();
    }
      
    /**
    *Função que verifica a veracidade do Código de empregado inserido.
    *@param idEmpregado {Int} Numero interno do Empregado 
    *@return  {true} -> Se existir um Empregado  
    */
    public boolean checkEmpregadoCodigo(int idEmpregado){ 
          /*--Verificar se existem Empregados*/
          if(isEmpty()){
              System.out.println("!!!! --- Não existem Empregados no momento --- !!!!");
          }
          else{
            /*--Verificar se o codigo que procuramos é valido*/
            if(isIndexValid(idEmpregado)){
                return true;
            }
            else{ 
                System.out.println("!!--ERRO NÃO EXISTE NENHUM EMPREGADO COM ESTE CÓDIGO --!!");
                 return false;
            }
          }
          return false;
      }
     
      
    /**
    * Função que verifica se o Empregado existe utilizando como parametro o seu código
    *@param idEmpregado {Int} Numero de identificação unico do Empregado
    * @return dados {String} -> Informação do Empregado 
    */
    public String showEmpregado( int idEmpregado){
        String dados="";
        for(Empregado i : this.empregadoList){
          if(i.getId_Empregado() == idEmpregado){
          dados = i.toString();
          break;
          }
        }
      return dados;
      }
    
    /**
    * Função que verifica se o Empregado existe utilizando como parametro o seu código
    * @return dados {String} -> Informação do Empregado 
    */     
    public String showAllEmpregados(){
       String dados="\n ----- Lista de Empregados ----- \n";
        if(isEmpty()){
         dados = " !!---Não Existem Empregados---!!";
        }
        else{
        for(Empregado i : this.empregadoList){
           dados += i.toString();
        }
        }
        return dados;
      }
    
    /**
    * Função que devolve um array de empregados
    * @param categoria {String} categoria a contabilizar Empregados
    *@return {Empregado[]} -> Array com empregados
    */
    public int countType(String categoria){
       int contador=0;
       categoria = categoria.trim();
     
        switch(categoria){
        
            case "Comerciais", "comerciais" -> {
                for(Empregado i : this.empregadoList){
                    if(i instanceof Comerciais){
                        contador++;
                    }
                }
             }
            
            case "Gestor", "gestor" -> {
                for(Empregado i : this.empregadoList){
                    if(i instanceof Gestor){
                        contador++;
                    }
                }
             }
            
             case "Motorista", "motorista" -> {
                 for(Empregado i : this.empregadoList){
                     if(i instanceof Motorista){
                         contador++;
                     }
                 }
             }
            
             case "Normal", "normal" -> {
                 for(Empregado i : this.empregadoList){
                     if(i instanceof Normal){
                         contador++;
                     }
                 }
             }
        }
      

       return contador;
    }
    
    /**
    * Função que Mostra todos os Empregados de uma determinada categoria
    * 
    * @param categoria {String} - Categoria a Mostrar
    */   
    public void showAllEmpregadosCategoria(String categoria){
        categoria = categoria.trim();
        categoria= categoria.toLowerCase();
        if(this.isEmpty()){
            System.out.println("!!---Não Existem Empregados---!!");
        
        }
        else{
        switch(categoria){
        
            case "Comerciais", "comerciais" -> {
                for(Empregado Comercial : this.empregadoList){
                    if(Comercial instanceof Comerciais){
                        System.out.println(Comercial.toString());
                    }
                }
             }
            
            case "Gestor", "gestor" -> {
                for(Empregado Gestor : this.empregadoList){
                    if(Gestor instanceof Gestor){
                          System.out.println(Gestor.toString());
                    }
                }
             }
            
             case "Motorista", "motorista" -> {
                 for(Empregado i : this.empregadoList){
                     if(i instanceof Motorista){
                          System.out.println( i.toString());
                     }
                 }
             }
            
             case "Normal", "normal" -> {
                 for(Empregado i : this.empregadoList){
                     if(i instanceof Normal){
                       System.out.println( i.toString());
                     }
                 }
            }
             
           default -> {
               if(this.isEmpty()){
                  System.out.println( "!---Não Existem Empregados Registados de Momento ---!");
               }
               else{
                 System.out.println( "!---Não Existem Empregados Desta Categoria No Momento ---!");      
               }
           }
        }
        }
    
    }
     
    /**
    * Função que devolve um array de empregados
    *@return {Empregado[]} -> Array com empregados
    */
    public Empregado[] getListEmpregados(){
          
      int numeroEmpregados = this.scanner.getIntegerNumber("Numero de total Empregados  a Introduzir:");
      Empregado[] listaEmpregados;
      listaEmpregados = new Empregado[numeroEmpregados];      
      
   
       for(int i = 0 ; i < numeroEmpregados ; i++){
          //Variaveis
       int opc;
       boolean checkNome;
       boolean checkDiasDeTrabalho;
       boolean checkQuilometros;
       boolean checkTaxaPorQuilometro;
       boolean checktTaxaPorVendas;
       boolean checkVendas;
       
       String nome;
       int diasDeTrabalho;
       int quilometros;
       int vendas;
       double taxaPorVendas;
       double taxaPorQuilometro;
       System.out.println("-----! NOVO EMPREGADO !-----");
       
       /*--- Recolha de dados ---*/
       do{    
         nome = scanner.getText("Nome:");
         if (checkStringIsNumber(nome)){
             System.out.println("!!-- O nome do funcionário só pode conter Letras --!!");
             checkNome = false;
         }
         else if(nome.isBlank()){
            System.out.println("!!-- O nome do funcionário não Pode estar vazio --!!");
             checkNome = false;
         }
         else{
              checkNome = true;
         }
       }while(checkNome != true);
       Random r = new Random();
       int idEmpregado =  r.nextInt(100-1) + 1;
       
       do{    
         diasDeTrabalho = scanner.getIntegerNumber("Dias de Trabalho do mês atual:");
         if (diasDeTrabalho < 0 || diasDeTrabalho > 23){
             System.out.println("!!-- Os dias de Trabalho Mensais têm de ser superiores a 0 e inferiores a 23 dias uteis--!!");
             checkDiasDeTrabalho = false;
         }
         else{
              checkDiasDeTrabalho = true;
         }
       }while(checkDiasDeTrabalho != true);
       
       do{
       System.out.println("Categoria:");
       System.out.println(" 1 - Gestor");
       System.out.println(" 2 - Motorista");
       System.out.println(" 3 - Comercial");
       System.out.println(" 4 - Normal ");
       opc = scanner.getIntegerNumber("Opção:");
       }while(opc <= 0 || opc >4 );
       
       switch(opc){
           case 1:
              listaEmpregados[i]  = new Gestor(nome,idEmpregado,diasDeTrabalho,this.salarioBase);
               
           break;
           case 2:
                     /*Recolha dos Quilometros Percorridos*/
                      do{    
                        quilometros = scanner.getIntegerNumber("Quilometros Percorridos:");
                        if (quilometros < 0){
                            System.out.println("!!-- Os quilometros Percorridos têm de ser superiores a 0--!!");
                            checkQuilometros = false;
                        }
                        else{
                             checkQuilometros = true;
                        }
                      }while(checkQuilometros != true);
                      
                      /*Recolha da Taxa Por Quilometro*/
                      do{    
                        taxaPorQuilometro = scanner.getRealNumber("Taxa por quilometro:");
                        if (taxaPorQuilometro < 0){
                            System.out.println("!!-- A taxa têm de ser superior a 0--!!");
                            checkTaxaPorQuilometro = false;
                        }
                        else{
                             checkTaxaPorQuilometro = true;
                        }
                      }while(checkTaxaPorQuilometro != true);
                      
                      
               listaEmpregados[i]  = new Motorista(nome,idEmpregado,diasDeTrabalho,quilometros,taxaPorQuilometro,this.salarioBase);
               
           break;
            case 3:
                     /*Recolha das Vendas Realizadas*/
                      do{    
                        vendas = scanner.getIntegerNumber("Vendas:");
                        if (vendas < 0){
                            System.out.println("!!--Vendas têm de ser superiores a 0--!!");
                            checkVendas = false;
                        }
                        else{
                             checkVendas = true;
                        }
                      }while(checkVendas != true);
                      
                      /*Recolha da Taxa Por Venda*/
                      do{    
                        taxaPorVendas = scanner.getRealNumber("Taxa por venda:");
                        if (taxaPorVendas < 0){
                            System.out.println("!!-- A taxa têm de ser superior a 0--!!");
                            checktTaxaPorVendas = false;
                        }
                        else{
                             checktTaxaPorVendas = true;
                        }
                      }while(checktTaxaPorVendas != true);
                      
                      
               listaEmpregados[i]  = new Comerciais(nome,idEmpregado,diasDeTrabalho,vendas,taxaPorVendas,this.salarioBase);
     
           break;
           case 4 :
              listaEmpregados[i] = new Normal(nome,idEmpregado,diasDeTrabalho,this.salarioBase);
           break;    
       }
        } 
       return listaEmpregados;
      }
  
    /**
    * Função que importa um array com Empregados para o arrayList
    *@param arrEmpregados {Empregado[]}Array com vários Empregados a introduzir no arrayList
    */
    public void importEmpregados(Empregado[] arrEmpregados){ 
          /*Check caso o array seja null*/
          if( arrEmpregados == null){
              System.out.println("!--- Não Existem Empregados na Lista a ser introduzida---!!");
          }
          else{
              /*Percorre o array de Empregados*/
              for (int i = 0; i < arrEmpregados.length; i++){
                this.empregadoList.add(arrEmpregados[i]); 
                
          }
            this.Write(this.empregadoList);
       }
    }  
    
    /**
    * Função que verifica se o index introduzido existe no arrayList
     *@param index {Int} Numero do Index 
    * @return  {true} -> Se o index for válido
    */
    public boolean isIndexValid(int index){
      return !(index > empregadoList.size() || index < 0);
    }
     
    /**
    * Metodo que Calcula o Salário de um Empregado
    *@return {double} Valor do salário a Pagar neste mês
    */
    public double CalculateSalarios(){
        double payment = 0;
        for(Empregado i : this.empregadoList){
            payment +=i.CalculateSalario();
            payment +=i.seniorityAward();
        }
        return payment;
    }   
    
    /**
    * Metodo que Calcula o Salário de um Empregado
    * @param anoAtual - Ano atual 
    * @return {double} Simulação do valor a Pagar Trimestralmente
    */
    public double CalculateSalariosTrimestre(int anoAtual){
       
        System.out.println("---Escolha um Trimestre Para Simular---");
        System.out.println("1- 1º Trimestre");      
        System.out.println("2- 2º Trimestre");      
        System.out.println("3- 3º Trimestre");  
        System.out.println("4- 4º Trimestre");   
        int opc = scanner.getIntegerNumber("Opção:");
        double paymentSimulated = 0;
        int totalWorkers=this.empregadoList.size();
        
        
        switch(opc){
            case 1->{
                int FEVEREIRO=0;
                     if(anoAtual%100 == 0 && anoAtual%400 == 0){
                        FEVEREIRO = 21;//Dias uteis do Mês de Fevereiro caso ano bissesto
                    }
                    else{
                        FEVEREIRO = 20;//Dias uteis do Mês de Fevereiro caso não seja ano bissesto
                    }
                
                int totalDays = meses.JANEIRO.getDias() + FEVEREIRO + meses.MARCO.getDias();
                paymentSimulated = Simulate(totalDays,totalWorkers);
            }
            
            case 2->{
                int totalDays = meses.ABRIL.getDias() + meses.MAIO.getDias() + meses.JUNHO.getDias();
                paymentSimulated = Simulate(totalDays,totalWorkers);
             
            }
            
            case 3->{
                int totalDays = meses.JULHO.getDias() + meses.AGOSTO.getDias() + meses.SETEMBRO.getDias();
                paymentSimulated = Simulate(totalDays,totalWorkers);
            }
            
            case 4->{
                int totalDays = meses.OUTUBRO.getDias() + meses.NOVEMBRO.getDias() + meses.DEZEMBRO.getDias();
                paymentSimulated = Simulate(totalDays,totalWorkers);
             
            }
            
        }
        
        return paymentSimulated;
    }
    /**
    * Metodo que Calcula o Salário de um Empregado
    * @param anoAtual - Ano atual 
    * @return {double} Simulação do valor a Pagar Semestralmente
    */
    public double CalculateSalariosSemestral(int anoAtual){
        System.out.println("---Escolha um Trimestre Para Simular---");
        System.out.println("1- 1º Semestre");      
        System.out.println("2- 2º Semestre");      
        int opc = scanner.getIntegerNumber("Opção:");
        double paymentSimulated = 0;
        int totalWorkers=this.empregadoList.size();
        
        
        switch(opc){
            case 1->{
                int FEVEREIRO=0;
                   if(anoAtual%100 == 0 && anoAtual%400 == 0){
                        FEVEREIRO = 21;//Dias uteis do Mês de Fevereiro caso ano bissesto
                    }
                    else{
                        FEVEREIRO = 20;//Dias uteis do Mês de Fevereiro caso não seja ano bissesto
                    }
                int totalDays = meses.JANEIRO.getDias() + FEVEREIRO + meses.MARCO.getDias() + meses.ABRIL.getDias() + meses.MAIO.getDias() + meses.JUNHO.getDias();//Totalidade de dias uteis no 1º Semestre
                paymentSimulated = Simulate(totalDays,totalWorkers);
            }
            case 2->{
                int totalDays = meses.JULHO.getDias() + meses.AGOSTO.getDias() + meses.SETEMBRO.getDias() + meses.OUTUBRO.getDias() + meses.NOVEMBRO.getDias() + meses.DEZEMBRO.getDias();
                paymentSimulated = Simulate(totalDays,totalWorkers);
             
            }
            
          
            
        }
        
        return paymentSimulated;
    }
    /**
    * Metodo que Calcula o Salário de um Empregado
    * @param anoAtual - Ano atual 
    * @return {double} Simulação do valor a Pagar Anaul
    */
    public double CalculateSalariosAnual(int anoAtual){
       
        
        double paymentSimulated = 0;
        int totalWorkers=this.empregadoList.size();
        int totalDays =0;
                    if(anoAtual%100 == 0 && anoAtual%400 == 0){
                       totalDays = 252;
                    }
                    else{
                        totalDays = 251 ;
                    }
      
        paymentSimulated = Simulate(totalDays,totalWorkers);
        
        return paymentSimulated;
    }
    
    /**
    * Metodo que Calcula o Salário de um Empregado
    * @param totalDeDias {int} - Total de Dias Trabalhados
    * @param totalWorkers {int} - Total de Trabalhadores Atualmente
    * @return {double} Valor da Simulação
    */
    public double Simulate( int totalDeDias , int totalWorkers){
       //Valor na Totalidade caso todos os trabalhadores atuais trabalhem num periodo "totalDeDias"
       double paymentSimulated = (totalDeDias*totalWorkers) *this.salarioBase;
       //Formula para calcular o subsidio de natal 
       double subsidioNatal = (((this.salarioBase * 23)  / 365) * totalDeDias) * totalWorkers;
        //Formula para calcular o subsidio de Férias 
       double subsidioFerias = (this.salarioBase * 22) * totalWorkers;
       
       return paymentSimulated + subsidioNatal + subsidioFerias;
    }
    
   
    
    /*------ Ficheiros ------*/
    
    /**
    * Função que Verifica se o ficheiro existe e se não existir cria um novo
    */
    public static void CheckFile(){
        try {
          File file = new File("Empregados.txt");
          Scanner reader = new Scanner(file);  
          reader.close();
        } catch (FileNotFoundException e) {
          CreateFile();
        } 
    }
    
    /**
    * Função que cria  o ficheiro 
    */
    public static void CreateFile(){
    try {
      File file = new File("Empregados.txt");
      file.createNewFile();
    } catch (IOException e) {
      System.out.println("An error occurred.");
    }
   }
    
    /**
    * Função que escreve no ficheiro todos os Empregados
    * @param Empregados {ArrayList} - ArrayList de Empregados
    */
    public static void Write(ArrayList<Empregado> Empregados){
     try {
      FileWriter filewriter = new FileWriter("Empregados.txt");
      for(Empregado i : Empregados){
        filewriter.write(i.toString());
      } 
      filewriter.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
    }
    }
    
    /**
     * Função que obtem do Ficheiro os Empregados e Insere na ArrayList , semelhante a uma Base de Dados
     */
    public void GetFromFile(){
        /*--Variaveis*/
        int i;
        int id=0;
        String nome=" ";
        String categoria="";
        int numeroCategoria=0;
        String DataDeEntrada="";
        int totalDiasTrabalhados=0;
        int vendasRealizadas=0;
        double taxaPorVendas=0;
        int KmPercorridos=0;
        double PremioAPagar=0.0;
        double TaxaPorKilometro=0.0;   
    try {
      File ficheiro = new File("Empregados.txt");
      Scanner reader = new Scanner(ficheiro);
       reader.hasNextLine(); // this will read the first line
       

      while (reader.hasNextLine()) {
        String dados = reader.nextLine();
        if(!dados.isBlank()){
              dados.trim();
        String[] dadosSeparados = dados.split("\\|"); 
        for(i =0 ;i< dadosSeparados.length;i++){
           dadosSeparados[i] = dadosSeparados[i].replaceAll(".+:", "");
           switch(i){
               case 0:
                   id = Integer.parseInt(dadosSeparados[i]); 
                break;
               case 1:
                   nome=dadosSeparados[i]; 
                break;
               case 2:
                   categoria=dadosSeparados[i];
                   switch(categoria){
                    case "Comerciais", "comerciais" ->  numeroCategoria = 3;
                    case "Gestor", "gestor" -> numeroCategoria = 1;
                    case "Motorista", "motorista" -> numeroCategoria = 2;
                    case "Normal", "normal" -> numeroCategoria = 4;  
                    }
                break;
               
               case 3:
                   DataDeEntrada=dadosSeparados[i];
                break;
               case 4:
                   dadosSeparados[i].trim();
                   totalDiasTrabalhados=Integer.parseInt(dadosSeparados[i]); 
               break;
               case 5:
                   if(categoria.trim().equals("Comerciais")){
                     vendasRealizadas=Integer.parseInt(dadosSeparados[i]); 
                   }
                   if(categoria.trim().equals("Motorista")){
                     KmPercorridos=Integer.parseInt(dadosSeparados[i]); 
                   }
              break;
              case 6:
                  if(categoria.trim().equals("Comerciais")){
                     taxaPorVendas=Double.parseDouble(dadosSeparados[i]);
                   }
                   if(categoria.trim().equals("Motorista")){
                     TaxaPorKilometro=Double.parseDouble(dadosSeparados[i]);
                   }
              break;
               
           }
           
        }
        if(categoria.trim().equals("Normal")){
         Empregado novoEmpregado = new Normal(nome,id,totalDiasTrabalhados,this.salarioBase);
         this.empregadoList.add(novoEmpregado); 
        }
         if(categoria.trim().equals("Gestor") ){
           Empregado novoEmpregadoGestor = new Gestor(nome,id,totalDiasTrabalhados,this.salarioBase);
           this.empregadoList.add(novoEmpregadoGestor);
        }
           if(categoria.trim().equals("Motorista")){
           Empregado novoEmpregadoMotorista = new Motorista(nome,id,totalDiasTrabalhados,KmPercorridos,TaxaPorKilometro,this.salarioBase);
               this.empregadoList.add(novoEmpregadoMotorista);
        }
          if(categoria.trim().equals("Comerciais")){
          Empregado novoEmpregadoComercial = new Comerciais(nome,id,totalDiasTrabalhados,vendasRealizadas,taxaPorVendas,this.salarioBase);
          this.empregadoList.add(novoEmpregadoComercial);  
        }
        
        }

      }
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
    }
    
    }
}
