package edu.uw.cpi.client;


import edu.uw.cpi.model.BlsResponse;
import org.springframework.stereotype.Service;

@Service
public class BLSService {

    private final BLSFacade blsFacade;

    public BLSService(BLSFacade blsFacade) {
        this.blsFacade = blsFacade;
    }

    public BlsResponse getCPI(){
        return this.blsFacade.callUrlAndProcessResponse();
    }

}
