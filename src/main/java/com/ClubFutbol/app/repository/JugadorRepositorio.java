package com.ClubFutbol.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ClubFutbol.app.variable.Jugador;

public interface JugadorRepositorio extends JpaRepository<Jugador, Integer> {

}
