package uk.co.michaeloldroyd.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExampleFilteredController {
    private static final Logger LOG = LogManager.getLogger(ExampleFilteredController.class);
    @RequestMapping(path = "/example-filtered")
    public ResponseEntity<String> getFilteredExample() {
        LOG.info("Within controller {}", this.getClass());
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }
}
