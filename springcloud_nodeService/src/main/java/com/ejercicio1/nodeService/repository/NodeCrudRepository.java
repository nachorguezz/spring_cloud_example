package com.ejercicio1.nodeService.repository;

import com.ejercicio1.nodeService.domain.Node;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface NodeCrudRepository extends ReactiveCrudRepository<Node, String>{

}
