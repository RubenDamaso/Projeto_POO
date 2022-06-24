/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto;

/**
 * Classe Comerciais
 * @author Rúben Dâmaso
 * @author David Neto
 */
public class Comerciais extends Empregado {
    
   /*--Atributos--*/
   private int vendas;
   private double taxaPorVendas;
  
    /**
     * Metodo Construtor do Empregado tipo 'Comercial'
     * @param nome {String} -  Nome 
     * @param id_Empregado{int}
     * @param totalDiasTrabalhados{int}
     * @param vendas{int}
     * @param taxaPorVendas{double}
     * @param salarioBase{double}
    */
    public Comerciais(String nome,int id_Empregado,int totalDiasTrabalhados , int vendas , double taxaPorVendas , double salarioBase){
        super(nome,id_Empregado,totalDiasTrabalhados,salarioBase);
        
        if(vendas < 0){
            this.vendas = 0;
        }else this.vendas = vendas;
        
        if(taxaPorVendas < 0){
            this.taxaPorVendas = 0;
        }else this.taxaPorVendas = taxaPorVendas;
        
    }
   
    /**
    * Metodo que adiciona o Bonus ao Empregado Comercial Consoante as suas vendas e taxa por venda
    * @return {Double} - valor do salário após aplicar o Bonus
    */
    public double addBonus(){
        
        double bonus = this.getSalario() + this.getBonus() ;
        this.setSalario(bonus);
        return this.getSalario();
        
    }
  
    /* Getters & Setters*/
    
    /**
    * Metodo que retorna o valor do do Bonus 
    * @return {double} - valor do Bonus
    */
    public double getBonus(){
        return this.vendas * this.taxaPorVendas;
    }
    
    /**
    * Metodo que retorna as vendas 
    * @return {int} - Total de vendas realizadas
    */
    public int getVendas() {
        return vendas;
    }
    /**
    * Metodo que atribui um valor ao atributo vendas
    * @param vendas {int} - Numero de vendas a adicionar
    */
    public void setVendas(int vendas) {
        this.vendas = vendas;
    }
    /**
    * Metodo que retorna a taxa aplicada ás vendas Realizadas 
    * @return {double} - Taxa por venda
    */
    public double getTaxaPorVendas() {
        return taxaPorVendas;
    }
    /**
    * Metodo que atribui um valor ao atributo Taxa por vendas
    * @param taxaPorVendas {double} -  Taxa a aplicar por venda
    */
    public void setTaxaPorVendas(double taxaPorVendas) {
        this.taxaPorVendas = taxaPorVendas;
    }
    
    
     /**
    * Metodo que Imprime um Empregado
    *@return {String} Dados do Empregado
    */
    @Override
    public String toString(){
     String info = "\nID:"+this.getId_Empregado()+"|Nome:" + this.getNome() +"|Categoria: Comerciais" + "|Data de entrada na Empresa:" + this.getDataEntradaEmpresa() + " | TOTAL DE DIAS CONCLUIDO:" + this.getTotalDiasTrabalhados()+"|Vendas Realizadas:"+this.getVendas()+"|Taxa por vendas:"+this.getTaxaPorVendas()+"|Bonus a Pagar:"+this.getBonus();
     return info;
    }
    
    /**
    * Metodo que Calcula o Salário de um Empregado
    *@return {double} Valor do salário a Pagar neste mês
    */
   @Override
    public double CalculateSalario(){
      double payment=0;
         this.addBonus();     
          payment += this.getSalario();
      return payment;
    }
}
