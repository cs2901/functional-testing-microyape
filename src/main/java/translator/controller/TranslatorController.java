package translator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import translator.business.TranslatorImpl;
import translator.business.Translator;
import translator.entities.Language;

@RestController
@RequestMapping("/translator")
@CrossOrigin(origins = "*")
public class TranslatorController {

    @GetMapping("/{from}/{to}/{text}")
    @CrossOrigin(origins = "*")
    public ResponseEntity getOneByConsumidorAndPeriodo(
            @PathVariable("from") String from,
            @PathVariable("to") String to,
            @PathVariable("text") String text
    ) {
        try {
            TranslatorImpl translator = new TranslatorImpl();
            String response = translator.translate(from, to, text);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
