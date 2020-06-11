package com.kelly.producer.service;

import com.kelly.producer.pojo.Depart;
import com.kelly.producer.repository.DepartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartServiceImp implements DepartService {
    @Autowired
    private DepartRepository repository;
    @Override
    public boolean saveDepart(Depart depart) {
       Depart obj = repository.save(depart);
        return obj != null ;
    }

    @Override
    public boolean removeDepartById(Integer id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyDepart(Depart depart) {
        Depart obj = repository.save(depart);
        return obj != null;
    }

    @Override
    public Depart getDepartById(Integer id) {
        if(repository.existsById(id)){
            return repository.getOne(id);
        }
        Depart depart = new Depart();
        depart.setName(id+" not exist");
        return null;
    }

    @Override
    public List<Depart> listAllDeparts() {
        return repository.findAll();
    }


}
