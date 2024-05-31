package com.ClubFutbol.app.variable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="jugadores")

public class Jugador {
@Id
@GeneratedValue( strategy = GenerationType.IDENTITY)
private Integer id;
private String nombre;
private String apellido;
private int numero;
private String posicion;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellido() {
	return apellido;
}

public void setApellido(String apellido) {
	this.apellido = apellido;
}

public int getNumero() {
	return numero;
}

public void setNumero(int numero) {
	this.numero = numero;
}

public String getPosicion() {
	return posicion;
}

public void setPosicion(String posicion) {
	this.posicion = posicion;
}

}
