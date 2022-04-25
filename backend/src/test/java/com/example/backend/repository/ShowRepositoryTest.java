package com.example.backend.repository;

import com.example.backend.domain.Show;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ShowRepositoryTest {

    @Autowired
    ShowRepository showRepository;

    Show show;

    @BeforeEach
    public void setUp() {
        show = new Show(1);
    }

    @AfterEach
    public  void tearDown() {
        showRepository.deleteAll();
        show = null;
    }

    @Test
    public void givenShowToAddShouldReturnAddedShow() {
        showRepository.save(show);
        Show fetchedProduct = showRepository.findById(show.getId()).get();
        assertEquals(1,fetchedProduct.getId());
    }


    @Test
    public void givenAllProductShouldReturnListOfAllProducts () {
        Show show1 = new Show(1);
        Show show2 = new Show(2);
        showRepository.save(show1);
        showRepository.save(show2);

        List<Show> productList = (List<Show>) showRepository.findAll();

    }
}
