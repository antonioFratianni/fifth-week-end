package com.example.backend.service;

import com.example.backend.domain.Show;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShowService {

     Show findById(String id);

     List<Show> findAll();

     Show save(int reservationNumber);
}
