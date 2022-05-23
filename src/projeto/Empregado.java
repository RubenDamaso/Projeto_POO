package projeto;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rúben Dâmaso
 * @author David Neto
 */
public abstract class Empregado {
    
   /*----Atributos----*/
   private String nome;
   private int id_Empregado;
   private String dataEntradaEmpresa;
   private int AnoEntradaEmpresa;
   private int totalDiasTrabalhados[];
   private double salario;

      
    /*--- Metodo Construtor---*/
    /**
    * Metodo que define um Empregado "Normal" por defeito
    *@param nome {String} Nome do Empregado
    *@param id_Empregado {Int} Numero interno do Empregado 
    *@param totalDiasTrabalhados {Int} Total de dias Trabalhados
    * @param salarioBase {Double} Salario Base Por dia
    */
    public Empregado(String nome,int id_Empregado,int totalDiasTrabalhados , double salarioBase){
       
        //Nome do Empregdo
        if(nome.isBlank()){
            this.nome="Default";
        }else this.nome = nome;
        
        
       //Numero do empregado
 
       this.id_Empregado = id_Empregado;
        
       //Data de entrada na Empresa
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
       LocalDateTime now = LocalDateTime.now();
       
       String formatDateTime = now.format(dtf);
       this.dataEntradaEmpresa = formatDateTime;
       
        //Total de Dias de Trabalho na Empresa
        this.totalDiasTrabalhados = new int[11];
        int mesAtual=0;
        
        DateTimeFormatter FormatMes = DateTimeFormatter.ofPattern("MM");  
        String MesFormatado = now.format(FormatMes);
        mesAtual = Integer.parseInt(MesFormatado);
      
        
        for(int i=0; i<12; i++){
            if(totalDiasTrabalhados>=0 && totalDiasTrabalhados <=31){
              if(i == mesAtual-1){
                this.totalDiasTrabalhados[i]=totalDiasTrabalhados;
              }
            }
        }
        
        this.salario = this.getTotalDiasTrabalhados() * salarioBase + 4.79 ;
       
        DateTimeFormatter FormatAno = DateTimeFormatter.ofPattern("yyyy");  
        String anoAtualFormatado = now.format(FormatAno);
       
        this.AnoEntradaEmpresa = Integer.parseInt(anoAtualFormatado);
        
        
        
    }

    
    
   
    /*--- Get & Set Nome---*/
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /*--- Get & Set Id_Empregado---*/
    public int getId_Empregado() {
        return id_Empregado;
    }
    public void setId_Empregado(int id_Empregado) {
        this.id_Empregado = id_Empregado;
    }
    
    /*--- Get & Set DataEntradaEmpresa---*/
    public String getDataEntradaEmpresa() {
        return dataEntradaEmpresa;
    }
    public void setDataEntradaEmpresa(String dataEntradaEmpresa) {
        this.dataEntradaEmpresa = dataEntradaEmpresa;
    }
    
    /*--- Get & Set TotalDiasTrabalhados---*/
    public int getTotalDiasTrabalhados() {
       
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter FormatMes = DateTimeFormatter.ofPattern("MM");  
        String MesFormatado = now.format(FormatMes);
        int mesAtual = Integer.parseInt(MesFormatado);
        int totaldeDiasMes=0;
        for(int i=0; i<12; i++){
              if(i == mesAtual-1){
                totaldeDiasMes =  this.totalDiasTrabalhados[i];  
                 break;
              }
        }
        
      return totaldeDiasMes;
    }
    public int getTotalDiasTrabalhados(int mes) {
       int  totaldeDiasMes =  this.totalDiasTrabalhados[mes];     
       return totaldeDiasMes;
    }
    public void setTotalDiasTrabalhados(int[] totalDiasTrabalhados) {
        this.totalDiasTrabalhados = totalDiasTrabalhados;    
    }
    
    
    /*--- Get & Set salario---*/
    public double getSalario() {
           return salario;
       }
    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getAnoEntradaEmpresa() {
        return AnoEntradaEmpresa;
    }
    public void setAnoEntradaEmpresa(int AnoEntradaEmpresa) {
        this.AnoEntradaEmpresa = AnoEntradaEmpresa;
    }
    
    
   /**
    * Metodo que Imprime um Empregado
    *@return {String} Dados do Empregado
    */
   @Override
    public abstract String toString();
   
    public double seniorityAward(){

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter FormatAno = DateTimeFormatter.ofPattern("yyyy");  
        String anoAtualFormatado = now.format(FormatAno);
        
        int anoAtual =  Integer.parseInt(anoAtualFormatado);
        int anoDeEntrada = getAnoEntradaEmpresa();
        int NumeroAnos = 0;
   
        NumeroAnos = anoAtual - anoDeEntrada;
        
        double award = (this.getSalario() * 0.05) * NumeroAnos;
        
        return award;
    }
    
    /**
    * Metodo que Imprime um Empregado
    *@return {String} Dados do Empregado
    */
    public abstract double CalculateSalario();
    
    
}
