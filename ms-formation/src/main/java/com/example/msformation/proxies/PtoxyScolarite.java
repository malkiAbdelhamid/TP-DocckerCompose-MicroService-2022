package com.example.msformation.proxies;

import com.example.msformation.models.Strudent;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="ms-scolarite")
@LoadBalancerClient(name="ms-scolarite")
public interface PtoxyScolarite {

    @GetMapping("/etudiants/search/findEtudiantByIdFormation")
    CollectionModel<Strudent> getEtudinats(@RequestParam("idf") Long idf,
                                           @RequestParam("projection") String p);
}
