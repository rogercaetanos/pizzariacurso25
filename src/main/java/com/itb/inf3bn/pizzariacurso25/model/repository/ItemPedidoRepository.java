package com.itb.inf3bn.pizzariacurso25.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itb.inf3bn.pizzariacurso25.model.entity.ItemPedido;


@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long>{

}




