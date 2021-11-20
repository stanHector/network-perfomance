package fhi0.DIDR.controller;

import fhi0.DIDR.dto.NetworkPerformanceDto;
import fhi0.DIDR.exception.ResourceNotFoundException;
import fhi0.DIDR.model.NetworkPerformance;
import fhi0.DIDR.repository.NetworkPerformanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.*;

//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "https://network-performance.netlify.app")
@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
public class NetworkPerformanceController {
    private final NetworkPerformanceRepository networkPerformanceRepository;

//    @GetMapping("performance")
//    List<NetworkPerformance> getNetworkPerformance() {
//        return networkPerformanceRepository.findAll(Sort.by("date").descending());
//    }


    @GetMapping("performance")
    public Page<NetworkPerformance> getNetworkPerformance(Pageable pageable) {
        return networkPerformanceRepository.findAll(pageable);
    }


    @PostMapping("performance")
    ResponseEntity<Object> createPerformance(@Valid @RequestBody NetworkPerformance networkPerformance) {
        return new ResponseEntity<>(networkPerformanceRepository.save(networkPerformance), HttpStatus.CREATED);
    }


    @PostMapping("save-performance")
    public ResponseEntity<NetworkPerformanceDto> updatePerformance(@Valid @RequestBody NetworkPerformanceDto networkPerformance) throws UnsupportedEncodingException {
        NetworkPerformance networkPerformance1 = new NetworkPerformance();
        byte[] decodedBytes = Base64.getDecoder().decode(networkPerformance.getImgUrl());
        networkPerformance1.setImgUrl(decodedBytes);
        networkPerformance1.setDate(networkPerformance.getDate());
        networkPerformance1.setName(networkPerformance.getName());
        networkPerformance1.setLocation(networkPerformance.getLocation());
        networkPerformance1.setRatePerformance(networkPerformance.getRatePerformance());
        networkPerformance1.setTicketId(networkPerformance.getTicketId());
        this.networkPerformanceRepository.save(networkPerformance1);
        return ResponseEntity.ok(networkPerformance);

    }


    @GetMapping("get-performance")
    public ResponseEntity<List<NetworkPerformanceDto>> getPerformance() throws UnsupportedEncodingException {
        List<NetworkPerformance> networkPerformanceList = this.networkPerformanceRepository.findAll();
        List<NetworkPerformanceDto> networkPerformanceList1 = new ArrayList<>();
        networkPerformanceList.stream().forEach(networkPerformance -> {
            NetworkPerformanceDto networkPerformance1 = new NetworkPerformanceDto();
            String encodedText = Base64Utils.encodeToString(networkPerformance.getImgUrl());
            networkPerformance1.setImgUrl(encodedText);
            networkPerformance1.setDate(networkPerformance.getDate());
            networkPerformance1.setName(networkPerformance.getName());
            networkPerformance1.setLocation(networkPerformance.getLocation());
            networkPerformance1.setRatePerformance(networkPerformance.getRatePerformance());
            networkPerformance1.setTicketId(networkPerformance.getTicketId());
            networkPerformanceList1.add(networkPerformance1);
        });
        return ResponseEntity.ok(networkPerformanceList1);

    }


    @DeleteMapping("performance/{id}")
    public Map<String, Boolean> deletePerformance(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        NetworkPerformance networkPerformance = networkPerformanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Network Performance not found for this id :: " + id));
        networkPerformanceRepository.delete(networkPerformance);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted!", Boolean.TRUE);
        return response;
    }
}
