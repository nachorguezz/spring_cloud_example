package com.ejercicio1.nodeService;

import com.ejercicio1.nodeService.controller.NodeController;
import com.ejercicio1.nodeService.domain.NodeDesc;
import com.ejercicio1.nodeService.domain.NodeRoot;
import com.ejercicio1.nodeService.request.NodeRequest;
import com.ejercicio1.nodeService.service.NodeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@WebFluxTest(NodeController.class)
public class NodeServiceTest {
    @Autowired
    WebTestClient webTestClient;

    @MockBean
    private NodeServiceImpl nodeRootServiceImpl;


    @Test
    public void testFindAll(){
        NodeRoot nodeRoot1 =new NodeRequest("node_1","nodeRoot", null).toNodeRootModel();
        NodeDesc nodeDesc2 =new NodeRequest("node_2","nodeDesc", "description").toNodeDescModel();
        Mockito.when(nodeRootServiceImpl.findAll()).thenReturn(Flux.just(nodeRoot1, nodeDesc2));

        webTestClient.get()
                .uri("/node")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(NodeRoot.class);

        Mockito.verify(nodeRootServiceImpl, Mockito.times(1)).findAll();

    }


    @Test
    public void testSave(){
        NodeRoot nodeRoot =new NodeRequest("node_3","nodeRoot2", null).toNodeRootModel();
        Mockito.when(nodeRootServiceImpl.save(nodeRoot)).thenReturn(Mono.just(nodeRoot));

        webTestClient.post()
                .uri("/node")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(nodeRoot), NodeRoot.class)
                .exchange()
                .expectStatus().isCreated();


    }
}
