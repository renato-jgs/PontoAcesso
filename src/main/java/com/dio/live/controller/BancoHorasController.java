package com.dio.live.controller;

import com.dio.live.model.BancoHoras;
import com.dio.live.service.BancoHorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/bancoHoras")
public class BancoHorasController {

    @Autowired
    BancoHorasService bancoHorasService;

    @PostMapping
    public BancoHoras createBancoHoras(@RequestBody BancoHoras bancoHoras) {
        return bancoHorasService.save(bancoHoras);
    }

    @GetMapping
    public List<BancoHoras> getBancoHorasList(){
        return bancoHorasService.findAll();
    }

    @GetMapping("/{idBancoHoras}")
    public ResponseEntity<BancoHoras> getBancoHorasByID(@PathVariable("idBancoHoras") Long idBancoHoras) throws Exception {
        return  ResponseEntity.ok(bancoHorasService.getById(idBancoHoras).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public BancoHoras updateBancoHoras(@RequestBody BancoHoras bancoHoras){
        return bancoHorasService.updateBancoHoras(bancoHoras);
    }

    @DeleteMapping("/{idBancoHoras}")
    public ResponseEntity deleteByID(@PathVariable("idBancoHoras") Long idBancoHoras) throws Exception {
        try {
            bancoHorasService.deleteBancoHoras(idBancoHoras);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<BancoHoras>) ResponseEntity.ok();
    }
}
