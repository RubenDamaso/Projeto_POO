package projeto;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Classe abstrata Empregado
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
    /**
    * Metodo que retorna o valor do atributo 'nome'
    * @return {String} - Nome do Empregado
    */
    public String getNome() {
        return nome;
    }
    /**
    * Metodo que atribuei um valor do atributo 'nome'
    * @param nome {string} - Nome do Empregado
    */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /*--- Get & Set Id_Empregado---*/
    /**
    * Metodo que retorna o valor do atributo 'id_Empregado'
    * @return {int} - ID do Empregado
    */
    public int getId_Empregado() {
        return id_Empregado;
    }
     /**
    * Metodo que atribuei um valor do atributo 'id_Empregado'
    * @param id_Empregado {int} - ID do Empregado
    */
    public void setId_Empregado(int id_Empregado) {
        this.id_Empregado = id_Empregado;
    }
    
    /*--- Get & Set DataEntradaEmpresa---*/
    /**
    * Metodo que retorna o valor do atributo 'DataEntradaEmpresa'
    * @return {String} - Data de Entrada na Empresa
    */
    public String getDataEntradaEmpresa() {
        return dataEntradaEmpresa;
    }
    /**
    * Metodo que atribui o valor do atributo 'DataEntradaEmpresa'
    * @param dataEntradaEmpresa{String} - Data de Entrada na Empresa
    */
    public void setDataEntradaEmpresa(String dataEntradaEmpresa) {
        this.dataEntradaEmpresa = dataEntradaEmpresa;
    }
    
    /*--- Get & Set TotalDiasTrabalhados---*/
    /**
    * Metodo que retorna o valor do atributo 'TotalDiasTrabalhados'
    * @return {int} - Totalidade de Dias Trabalhados na Empresa neste mês
    */
    public int getTotalDiasTrabalhados() {
       
        //Obtemos o mes atual do dispositivo
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
       //Retornamos o total de Dias trabalhados neste mês
      return totaldeDiasMes;
    }
    /**
    * Metodo que retorna o valor do atributo 'TotalDiasTrabalhados'
    * @param mes {int} - Mes que queremos verificar
    * @return {int} - Totalidade de Dias Trabalhados na Empresa nesse mês
    */
    public int getTotalDiasTrabalhados(int mes) {
       int  totaldeDiasMes =  this.totalDiasTrabalhados[mes];     
       return totaldeDiasMes;
    }
    /**
    * Metodo que atribui o valor do atributo 'TotalDiasTrabalhados'
    * @param totalDiasTrabalhados {int[]} - Total de dias trabalhados em todos os meses 
    */
    public void setTotalDiasTrabalhados(int[] totalDiasTrabalhados) {
        this.totalDiasTrabalhados = totalDiasTrabalhados;    
    }
    
    
    /*--- Get & Set salario---*/
    /**
    * Metodo que retorna o valor do atributo 'Salario'
    * @return {double} - valor do salario
    */
    public double getSalario() {
           return salario;
    }
    /**
    * Metodo que atribui um valor ao atributo 'Salario'
    * @param salario {double} - Salario
    */
    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    /*--- Get & Set Ano de Entrada na Empresa---*/
    /**
    * Metodo que retorna o valor do atributo 'AnoEntradaEmpresa'
    * @return {int} - Ano de Entrada na Empresa
    */
    public int getAnoEntradaEmpresa() {
        return AnoEntradaEmpresa;
    }
    /**
    * Metodo que retorna atribui um valor ao atributo 'AnoEntradaEmpresa'
    * @param AnoEntradaEmpresa {int} -Ano de Entrada na Empresa
    */
    public void setAnoEntradaEmpresa(int AnoEntradaEmpresa) {
        this.AnoEntradaEmpresa = AnoEntradaEmpresa;
    }
    
    
   /**
    * Metodo que Imprime um Empregado
    *@return {String} Dados do Empregado
    */
   @Override
    public abstract String toString();
   /**
    * Metodo que Calcula o valor a ser acrescentado ao empregado , ou seja 0,5% do seu salario.
    *@return award{double} valor a acrescentar
    */
    public double seniorityAward(){
        /*Vamos recolher o ano atual*/
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter FormatAno = DateTimeFormatter.ofPattern("yyyy");  
        String anoAtualFormatado = now.format(FormatAno);
        
        int anoAtual =  Integer.parseInt(anoAtualFormatado);
        int anoDeEntrada = getAnoEntradaEmpresa();
        int NumeroAnos = 0;
        
        /*O ano atual - o ano de entrada da empresa irá originar a totalidade de anos que o empregado está na Empresa*/
        NumeroAnos = anoAtual - anoDeEntrada;
        
        /*Formula a aplicar para receber 0.5% do salário atual*/
        double award = (this.getSalario() * 0.05) * NumeroAnos;
        
        return award;
    }
    
    /**
    * Metodo que Imprime um Empregado
    *@return {String} Dados do Empregado
    */
    public abstract double CalculateSalario();
    
    
}
