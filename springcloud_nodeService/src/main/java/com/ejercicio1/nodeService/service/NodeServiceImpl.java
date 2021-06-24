package com.ejercicio1.nodeService.service;

import com.ejercicio1.nodeService.domain.Node;
import com.ejercicio1.nodeService.repository.NodeCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class NodeServiceImpl implements INodeService {
    @Autowired
    private NodeCrudRepository nodeCrudRepository;

    public Flux findAll() {
        return nodeCrudRepository.findAll();
    }

    public Mono save(Node node) {
        return nodeCrudRepository.save(node);
    }
}
