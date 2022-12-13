package Animais;

import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author TI ADCe
 */


public class Animais {
    private String nome;
    private String peso;
    private String idade;
    private String sexo;
    
    public Animais() {
	}
	    
	public Animais(String nome, String peso, String idade, String sexo) {
	       this.nome = nome;
	       this.peso = peso;
	       this.idade = idade;
	       this.sexo = sexo;
	
	}

public void setNome(String nome){
    this.nome = nome;
}
public String getNome(){
    return this.nome;
}
public void setPeso(String peso){
    this.peso = peso;
}
public String getPeso(){
    return this.peso;
}
public void setIdade(String idade){
    this.idade = idade;
}
public String getIdade(){
    return this.idade;
}
public void setSexo(String sexo){
    this.sexo =sexo;
}
public String getSexo(){
    return this.sexo;
}

@Override
public String toString() {
	// TODO Auto-generated method stub
	return "Nome: " + nome + "\nPeso: " + peso + "\nIdade: " + idade + "\nSexo: " + sexo;
}

}
