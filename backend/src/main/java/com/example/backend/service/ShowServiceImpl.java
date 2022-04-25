package com.example.backend.service;

import com.example.backend.domain.Show;
import com.example.backend.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    ShowRepository showRepository;

    @Override
    public Show findById(String id) {
        return showRepository.findById(id).orElse(null);
    }

    @Override
    public List<Show> findAll() {
        return showRepository.findAll();
    }

    @Override
    public Show save(int reservationNumber) {
        Show show = new Show(reservationNumber);
        return showRepository.save(show);
    }
}
