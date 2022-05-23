/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto;
import java.util.ArrayList; 
import java.util.Random;
/**
 *
 * @author Rúben Dâmaso
 * @author David Neto
 */

public class Empresa {
    
     /*----Atributos----*/
     private final ArrayList<Empregado> empregadoList;
     private final double salarioBase;
     private final InputReader scanner;
     
     /*---Metodo Construtor---*/
       public Empresa(){
        this.empregadoList = new ArrayList<>();
        this.scanner = new InputReader();
        this.salarioBase = 4.79;
      }
       public Empresa(int salarioBase){
        this.empregadoList = new ArrayList<>();
        this.scanner = new InputReader();
        if(salarioBase>0){
         this.salarioBase = salarioBase;
        }else this.salarioBase = 4.79;
      }
      
    /**
    * Função que adiciona um empregado à empresa
    *@param
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
        System.out.println("--!Empregado adicionado com sucesso!--");
            
    }
    
    /**
    * Função que verifica se a String contem numeros
    *@param string {String} String a ser verificada 
    * @return  {true} -> Se existir numeros 
    * 
    */
    public boolean checkStringIsNumber(String string){
        try {
            int intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
             return false;  
        } 
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
            
                int firstMothWorkDays = 23;//Dias uteis do Mês de Janeiro
                int secondMothWorkDays=0;
                     if(anoAtual%100 == 0 && anoAtual%400 == 0){
                        secondMothWorkDays = 21;//Dias uteis do Mês de Fevereiro caso ano bissesto
                    }
                    else{
                        secondMothWorkDays = 20;//Dias uteis do Mês de Fevereiro caso não seja ano bissesto
                    }
                int thirdMonthWorkDays=23;//Dias uteis do Mês de Março
                
                int totalDays = firstMothWorkDays + secondMothWorkDays + thirdMonthWorkDays;
                paymentSimulated = Simulate(totalDays,totalWorkers);
            }
            
            case 2, 4->{
            
                int firstMothWorkDays = 22;//Dias uteis do Mês de Abril    / Dias uteis do Mês de Outubro
                int secondMothWorkDays=23;//Dias uteis do Mês de Maio     /  Dias uteis do Mês de Novembro
                int thirdMonthWorkDays=22;//Dias uteis do Mês de Junho   /   Dias uteis do Mês de Dezembro
                int totalDays = firstMothWorkDays + secondMothWorkDays + thirdMonthWorkDays;
                paymentSimulated = Simulate(totalDays,totalWorkers);
             
            }
            
            case 3->{
            
                int firstMothWorkDays = 23;//Dias uteis do Mês de Julho
                int secondMothWorkDays=23;//Dias uteis do Mês de Agosto
                int thirdMonthWorkDays=22;//Dias uteis do Mês de Setembro
                
                int totalDays = firstMothWorkDays + secondMothWorkDays + thirdMonthWorkDays;
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
            
                int firstMothWorkDays = 23; //Dias uteis do Mês de Janeiro
                int secondMothWorkDays=0;
                   if(anoAtual%100 == 0 && anoAtual%400 == 0){
                        secondMothWorkDays = 21;//Dias uteis do Mês de Fevereiro caso ano bissesto
                    }
                    else{
                        secondMothWorkDays = 20;//Dias uteis do Mês de Fevereiro caso não seja ano bissesto
                    }
                int thirdMonthWorkDays=23;//Dias uteis do mês de Março
                int forthMonth = 22;//Dias uteis do mês de Abril
                int fifthMonth=23;//Dias uteis do mês de Maio
                int SixthMonth=22;//Dias uteis do mês de Junho
                
                int totalDays = firstMothWorkDays + secondMothWorkDays + thirdMonthWorkDays + forthMonth + fifthMonth + SixthMonth;//Totalidade de dias uteis no 1º Semestre
                paymentSimulated = Simulate(totalDays,totalWorkers);
            }
            
            case 2->{
                //Dias uteis Começando no Mês de Julho -> Dezembro (2ºSemestre)
                int firstMothWorkDays = 23; 
                int secondMothWorkDays=23;
                int thirdMonthWorkDays=22; 
                int forthMonth = 23;
                int fifthMonth=22;
                int SixthMonth=23;
                
                int totalDays = firstMothWorkDays + secondMothWorkDays + thirdMonthWorkDays + forthMonth + fifthMonth + SixthMonth;
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

}
