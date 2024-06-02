package org.example.apptwo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Controller {
    private ServiceMassage serviceMassage;
    @GetMapping("/hello")
    String printMessage(){
        return serviceMassage.print();
    }

}
