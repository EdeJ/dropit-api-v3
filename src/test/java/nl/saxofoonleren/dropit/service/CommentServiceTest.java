package nl.saxofoonleren.dropit.service;

import nl.saxofoonleren.dropit.exceptions.DemoNotFoundException;
import nl.saxofoonleren.dropit.repository.CommentRepository;
import nl.saxofoonleren.dropit.repository.DemoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommentServiceTest {

    @InjectMocks
    CommentService commentService;

    @Mock
    CommentRepository commentRepository;

//    @Test
//    void getAllCommentsShouldGiveEmptyList() {
//
//        // Arrange
//        Mockito.when(commentRepository.findAll()).thenReturn(new ArrayList<Object>());
//
//     int expectedListSize = 0;
//        System.out.println(commentService.getAllComments());
//
////        assertEquals(expectedListSize, commentService.getAllComments().size());
//    }
}