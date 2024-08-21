package edu.uw.cpi.controller;

import edu.uw.cpi.model.Cpi;
import edu.uw.cpi.repository.CpiRepository;
import edu.uw.cpi.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class CpiController {

    public static final String BLS_SERIES_ID = "LAUCN040010000000005";
    @Autowired
    CpiRepository repository;

    @Autowired
    ApiController apiController;

    @GetMapping("/api/v1/cpis/{input}")
    /**
     * The argument has tobe like May 2020. returns bad request otherwise
     * */
    public ResponseEntity<Cpi> getCpiForMonth(@PathVariable String input) {

        //validate input
        if (input == null || input.isEmpty() || input.split("-").length != 2) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        String[] yearAndMonth = input.split("-");
        String month = yearAndMonth[0];
        String yearStr = yearAndMonth[1];
        if (!Utility.isMonth(month) || !Utility.isFourDigitInteger(yearStr)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        int year = Integer.parseInt(yearStr);
        Long timestamp = Timestamp.from(Instant.now().minus(24, ChronoUnit.HOURS)).getTime();


        try {
            //check if we have a recent data in the cache database
            System.out.println("INFO: Requesting bls-web-service");
            Optional<Cpi> cpiInDB = repository.findByYearAndMonthFirst(month, year, timestamp);
            if (cpiInDB.isPresent()) {
                System.out.println("INFO: Returning from local cache db");
                return new ResponseEntity<>(cpiInDB.get(), HttpStatus.OK);
            }

            System.out.println("INFO: Requesting bls-web-service");
            //else, we will fetch from bls-web-service. we insert it to our cache database
            List<Cpi> cpiList = apiController.callBlsApi(BLS_SERIES_ID);

            if (!cpiList.isEmpty()) {
                System.out.println("INFO: Good! Got response from bls-web-service");
                Cpi eureka=null;
                for (Cpi cpi : cpiList) {
                    if( month.equals(cpi.getMonth()) && year==cpi.getYear()){
                        eureka=cpi;
                    }
                    cpi.setInsertedTimestamp(new Date().getTime());
                    repository.save(cpi);
                }
                return new ResponseEntity<>(eureka, HttpStatus.OK);

            }else{
                System.out.println("INFO: Empty response from bls-web-service");

            }
            return new ResponseEntity<>( HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PostMapping("/api/v1/cpis/local/create")
    public ResponseEntity<Cpi> create(@RequestBody Cpi cpi) {
        try {

            Cpi saved = repository.save(cpi);
            return new ResponseEntity<>(saved, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
