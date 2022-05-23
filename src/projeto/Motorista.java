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
public class Motorista extends Empregado {
    
   /*--Atributos--*/
   private int quilometros;
   private double taxaPorQuilometro;
   /*--Metodo Construtor--*/
    public Motorista(String nome,int id_Empregado,int totalDiasTrabalhados , int quilometros , double taxaPorQuilometro , double salarioBase){
        super(nome,id_Empregado,totalDiasTrabalhados,salarioBase);
        
        if(quilometros < 0){
            this.quilometros = 0;
        }else this.quilometros = quilometros;
        
        if(taxaPorQuilometro < 0){
            this.taxaPorQuilometro = 0;
        }else this.taxaPorQuilometro = taxaPorQuilometro;
        
    }
    /**
    * Metodo que adiciona o Bonus ao Empregado Motorista Consoante os Quilometros Efetuados e taxa por Quilometro
    * @return {Double} - valor do salário após aplicar o Bonus
    */
    public double addBonus(){
        
        double bonus = this.getSalario() + this.getBonus() ;
        this.setSalario(bonus);
        return this.getSalario();
        
    }
    
    /* Getter & Setter*/
    public double getBonus(){
        return this.quilometros * this.taxaPorQuilometro;
    }
    public int getQuilometros() {
        return quilometros;
    }
    public void setQuilometros(int quilometros) {
        this.quilometros = quilometros;
    }
    public double getTaxaPorQuilometro() {
        return taxaPorQuilometro;
    }
    public void setTaxaPorQuilometro(double taxaPorQuilometro) {
        this.taxaPorQuilometro = taxaPorQuilometro;
    }
    
    /**
    * Metodo que Imprime um Empregado
    *@return {String} Dados do Empregado
    */
    @Override
    public String toString(){
     String info = "\n ID :"+this.getId_Empregado()+"|Nome: " + this.getNome() +"|Categoria : Motorista " + "| Data de entrada na Empresa : " 
     +this.getDataEntradaEmpresa() + " | TOTAL DE DIAS CONCLUIDO : " + this.getTotalDiasTrabalhados()+"|Km : "+this.getQuilometros() +" |Bonus a Pagar : "+this.getBonus();
     return info;
    }
    
    /**
    * Metodo que Calcula o Salário de um Empregado
    *@return {double} Valor do salário a Pagar neste mês
    */
    @Override
    public double CalculateSalario(){
     double payment = 0;
       this.addBonus();
       payment += this.getSalario();
      return payment;
    }
}
