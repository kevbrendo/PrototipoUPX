package com.facens.upx.upxprojeto.controller;

import com.facens.upx.upxprojeto.model.ObjetoReciclado;
import com.facens.upx.upxprojeto.model.Turma;
import com.facens.upx.upxprojeto.repository.ObejtoReciclatoRepository;
import com.facens.upx.upxprojeto.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/recicle")
public class RecicleController {

    @Autowired
    private ObejtoReciclatoRepository obejtoReciclatoRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    @PostMapping(path = "/cadastrar/turma")
    public @ResponseBody Turma criarTurma(Turma turma) {
        turmaRepository.save(turma);
        return turma;
    }

    @PostMapping(path = "/cadastrar/objetos")
    public @ResponseBody ObjetoReciclado criarObjetoReciclado(@RequestParam(name = "nome") String nome,
                                                              @RequestParam(name = "tipo") String tipo,
                                                              @RequestParam(name = "quantidade") int quantidade,
                                                              @RequestParam(name = "turma_id") int turmaId) throws ChangeSetPersister.NotFoundException {

        Turma turmaConsulta = turmaRepository.findById(turmaId).orElseThrow(ChangeSetPersister.NotFoundException::new);
        ObjetoReciclado objetoReciclado = new ObjetoReciclado(nome, tipo, quantidade, turmaConsulta);
        obejtoReciclatoRepository.save(objetoReciclado);
        return objetoReciclado;
    }

    @GetMapping(path = "/consulta")
    public Iterable<ObjetoReciclado> consultarObjetos(){
        return obejtoReciclatoRepository.findAll();
    }

    @GetMapping("/consulta/{id}")
    public Optional<Turma> consultarTurma(@PathVariable int id) {
        return turmaRepository.findById(id);
    }
}
