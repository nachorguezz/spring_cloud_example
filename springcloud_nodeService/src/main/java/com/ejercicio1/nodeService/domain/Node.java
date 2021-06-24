package com.ejercicio1.nodeService.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "node")
@Getter
@Builder
public class Node {

    @Id
    private final String id;
    private final String name;
}
