package com.ejercicio1.nodeService.controller;

import com.ejercicio1.nodeService.request.NodeRequest;
import com.ejercicio1.nodeService.service.NodeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class NodeController {
    @Autowired
    private NodeServiceImpl nodeRootServiceImpl;

    @GetMapping("/node")
    public Flux findAll() {
        return nodeRootServiceImpl.findAll();
    }

    @PostMapping("/node")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mono save(@RequestBody NodeRequest nodeRequest) {
        if(nodeRequest.getDescription() != null){
            return nodeRootServiceImpl.save(nodeRequest.toNodeDescModel());
        }else{
            return nodeRootServiceImpl.save(nodeRequest.toNodeRootModel());
        }
    }

}
