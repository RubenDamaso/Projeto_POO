/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto;

/**
 *
 * @author Rúben Dâmaso
 * @author David Neto
 */
public class Gestor extends Empregado {
    
    /*----Atributos----*/
    private double premio;
    
    /*--- Metodo Construtor---*/
    /**
    * Metodo que define um Empregado "Gestor" por defeito
    * @param nome {String} - Nome do Empregado
    * @param id_Empregado {Int} - Numero interno do Empregado 
    * @param totalDiasTrabalhados  {int} - Total de dias de Trabalho 
    * @param salarioBase {double} - Salário Base definido pela empresa
    */
    public Gestor(String nome,int id_Empregado,int totalDiasTrabalhados , double salarioBase){
        super(nome,id_Empregado,totalDiasTrabalhados,salarioBase);
        this.premio = this.getSalario() * 0.15;
    }
    
    /* Getter & Setter*/
    public double getPremio() {
        return premio;
    }
    public void setPremio(double premio) {
        this.premio = premio;
    }
    
    /**
    * Metodo que adiciona o Premio ao Empregado Gestor Com o premio de +15% tendo em conta
    * @return {Double} - valor do salário após aplicar o Bonus
    */
    public double addPremio(){
        double salarioComPremio = this.getPremio() + this.getSalario();
        this.setSalario(salarioComPremio);
        return this.getSalario();
    }
    
    /**
    * Metodo que Imprime um Empregado
    *@return {String} Dados do Empregado
    */
    @Override
    public String toString(){
     String info = "\n ID :"+this.getId_Empregado()+"|Nome: " + this.getNome() +"|Categoria : Gestor " + "| Data de entrada na Empresa : " + this.getDataEntradaEmpresa() + " | TOTAL DE DIAS CONCLUIDO : " + this.getTotalDiasTrabalhados() +"|Premio a Pagar : "+this.getPremio();
     return info;
    }
    /**
    * Metodo que Calcula o Salário de um Empregado
    *@return {double} Valor do salário a Pagar neste mês
    */
     @Override
    public double CalculateSalario(){
     double payment = 0;
       this.addPremio();
       payment += this.getSalario();
      return payment;
    }
    
}
