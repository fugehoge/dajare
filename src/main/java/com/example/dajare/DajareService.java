package com.example.dajare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DajareService {

    private final DajareRepository repository;

    @Autowired
    public DajareService(DajareRepository repository) {
        this.repository = repository;
    }

    public Iterable<Dajare> getAllDajares() {
        return repository.findAll();
    }

    public Dajare saveDajare(Dajare dajare) {
        return repository.save(dajare);
    }
    
	public void displayDajares() {
		Iterable<Dajare> dajares = getAllDajares();

		for (Dajare dajare : dajares) {
			System.out.println(dajare.getContent());
		}
	}

    // other methods...
}
