package edu.uw.cpi.client;
import edu.uw.cpi.model.BlsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bls-responses")
public class BLSResponseController {

    private final BLSService blsService;

    public BLSResponseController(BLSService blsService) {
        this.blsService = blsService;
    }

    @GetMapping
    public ResponseEntity<BlsResponse> getAllBLSResponses() {
        return ResponseEntity.ok(blsService.getCPI());
    }

}
