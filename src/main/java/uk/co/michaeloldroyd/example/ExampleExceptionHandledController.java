package uk.co.michaeloldroyd.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class ExampleExceptionHandledController {
    private static final Logger LOG = LogManager.getLogger(ExampleFilteredController.class);
    @RequestMapping(path = "/example-exception")
    public ResponseEntity<String> getFilteredExample() {
        LOG.info("Within controller {}", this.getClass());
        throw new IllegalArgumentException();
    }

    @RequestMapping(path = "/example-exception/unhandled")
    public ResponseEntity<String> getUnhandledException() throws IOException {
        LOG.info("Within controller {}", this.getClass());
        throw new IOException();
    }

    @ExceptionHandler
    public ResponseEntity<String> handleException(IllegalArgumentException ex) {
        LOG.debug("Handled Exception", ex);
        return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
