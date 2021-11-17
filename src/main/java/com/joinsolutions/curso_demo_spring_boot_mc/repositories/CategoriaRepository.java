package com.joinsolutions.curso_demo_spring_boot_mc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joinsolutions.curso_demo_spring_boot_mc.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
