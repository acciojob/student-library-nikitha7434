package com.example.library.studentlibrary.services;

import com.example.library.studentlibrary.models.Card;
import com.example.library.studentlibrary.models.CardStatus;
import com.example.library.studentlibrary.models.Student;
import com.example.library.studentlibrary.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CardService {


    @Autowired
    CardRepository cardRepository3;

    public Card createAndReturn(Student student){
        Card card = null;
        card.setStudent(student);
        card.setCreatedOn(new Date());
        card.setUpdatedOn(new Date());
        card.setCardStatus(CardStatus.ACTIVATED);
        //link student with a new card
        cardRepository3.save(card);
        return card;
    }

    public void deactivateCard(int student_id){
        cardRepository3.deactivateCard(student_id, CardStatus.DEACTIVATED.toString());
    }
}