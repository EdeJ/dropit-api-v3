package nl.saxofoonleren.dropit.service;


import nl.saxofoonleren.dropit.exceptions.DemoNotFoundException;
import nl.saxofoonleren.dropit.repository.DemoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

class DemoServiceTest {

    @InjectMocks
    DemoService demoService;

    @Mock
    DemoRepository demoRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

   @Test
    void serviceShouldThrowExceptionWhenDemoNotFoundById() {

       // Arrange
       Mockito.when(demoRepository.findById(1L)).thenReturn(Optional.empty());

       // Assert
       Assertions.assertThrows(DemoNotFoundException.class, () -> {
           // Act
           demoService.getDemoById(1L);;
       });
   }

    @Test
    void deleteDemoShouldThrowExceptionWhenDemoNotExists() {

        // Arrange
        Mockito.when(demoRepository.existsById(1L)).thenReturn(false);

        // Assert
        Assertions.assertThrows(DemoNotFoundException.class, () -> {
            // Act
            demoService.deleteDemo(1L);

        });
    }

    @Test
    void verifyDeleteByIdMethodIsCalled() throws Exception {

        DemoRepository spy = Mockito.spy(demoRepository);

        // Arrange
        Mockito.doReturn(true).when(demoRepository).existsById(1L);
        Mockito.doNothing().when(demoService).deleteDemo(1L);



//       Mockito.doNothing().when(spy).deleteById(1L);
//       Mockito.doNothing().when(demoService).deleteDemo(1L);
//
//        // Assert
        demoService.deleteDemo(1L);

        Mockito.verify(spy).deleteById(1L);
    }

//   @Test
//    void verifyDeleteByIdMethodIsCalled() {
//
//       DemoRepository spy = Mockito.spy(demoRepository);
//
//       Mockito.doNothing().when(spy).deleteById(1L);
////       Mockito.doNothing().when(demoService).deleteDemo(1L);
//
//        demoService.deleteDemo(1L);
//
//       Mockito.verify(spy).deleteById(1L);
//
//   }
}
