/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto;

/**
 *
 * @author ruben
 */
public class Normal extends Empregado {

    /*--- Metodo Construtor---*/
    /**
    * Metodo que define um Empregado "Gestor" por defeito
    *@param nome {String} Nome do Empregado
    *@param id_Empregado {Int} Numero interno do Empregado 
    * @param totalDiasTrabalhados 
    * @param salarioBase 
    */ 
    public Normal(String nome,int id_Empregado,int totalDiasTrabalhados, double salarioBase){
        super(nome,id_Empregado,totalDiasTrabalhados,salarioBase);
    }
    
    @Override
    public String toString(){
        String info = "\n ID :"+this.getId_Empregado()+"|Nome: " + this.getNome() +"|Categoria : Normal" + "| Data de entrada na Empresa : " + this.getDataEntradaEmpresa() + " | TOTAL DE DIAS CONCLUIDO : " + this.getTotalDiasTrabalhados() + ".";
        return info;
    }
    
    @Override
    public double CalculateSalario(){
     double payment = 0;
        payment = this.getSalario();
     return payment;
    }
}
