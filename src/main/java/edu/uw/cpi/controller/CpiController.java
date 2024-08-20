package edu.uw.cpi.controller;

import edu.uw.cpi.model.Cpi;
import edu.uw.cpi.repository.CpiRepository;
import edu.uw.cpi.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CpiController {

    @Autowired
    CpiRepository repository;

    @Autowired
    ApiController apiController;

    @GetMapping("/api/v1/cpis/{input}")
    /**
     * The argument has tobe like May 2020. returns bad request otherwise
     * */
    public ResponseEntity<List<Cpi>> getCpiForMonth(@PathVariable String input) {
        if (input == null || input.isEmpty() || input.split(" ").length != 2) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        String[] yearAndMonth = input.split(" ");
        String month = yearAndMonth[0];
        String yearStr = yearAndMonth[1];
        if (!Utility.isMonth(month) || !Utility.isFourDigitInteger(yearStr)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        int year = Integer.parseInt(yearStr);


        try {


            List<Cpi> list = new ArrayList<>();
            repository.findAll().forEach(list::add);
            if (list.isEmpty()) {//or fetched time is too old

                List<Cpi> cpiList = apiController.callBlsApi2("LAUCN040010000000005");
                for (Cpi cpi : cpiList) {
                    repository.save(cpi);
                }
                return new ResponseEntity<>(cpiList, HttpStatus.OK);

            }
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/api/v1/cpis2")
    public ResponseEntity<List<Cpi>> getCpis() {
        try {
            List<Cpi> list = new ArrayList<>();
            repository.findAll().forEach(list::add);
            if (list.isEmpty()) {//or fetched time is too old

                List<Cpi> cpiList = apiController.callBlsApi2("LAUCN040010000000005");
                for (Cpi cpi : cpiList) {
                    repository.save(cpi);
                }
                return new ResponseEntity<>(cpiList, HttpStatus.OK);

            }
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/v1/cpis/{id}")
    public ResponseEntity<Cpi> getBookById(@PathVariable Long id) {
        try {
            Optional<Cpi> cpi = repository.findById(id);
            if (!cpi.isPresent()) {

                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(cpi.get(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/api/v1/cpis/update")
    public ResponseEntity<Cpi> update(Long id, @RequestBody Cpi cpi) {
        try {
            Optional<Cpi> old = repository.findById(id);
            if (old.isPresent()) {
                Cpi updated = old.get();
                updated.setMonth(cpi.getMonth());
                updated.setYear(cpi.getYear());
                repository.save(updated);
                return new ResponseEntity<>(updated, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/api/v1/cpis/create")
    public ResponseEntity<Cpi> create(@RequestBody Cpi cpi) {
        try {

            Cpi saved = repository.save(cpi);
            return new ResponseEntity<>(saved, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
