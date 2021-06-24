package com.ejercicio1.nodeService.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "node")
@Getter
public class NodeDesc extends Node{
    private final String description;

    @Builder(builderMethodName = "nodeDescBuilder")
    public NodeDesc(String id, String name, String description) {
        super(id, name);
        this.description = description;
    }
}
