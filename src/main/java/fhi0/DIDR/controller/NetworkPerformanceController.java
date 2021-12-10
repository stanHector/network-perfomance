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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "https://network-performance.netlify.app")
@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
public class NetworkPerformanceController {
    private final NetworkPerformanceRepository networkPerformanceRepository;

    @GetMapping("performances")
    public Page<NetworkPerformance> getNetworkPerformance(Pageable pageable) {
        return networkPerformanceRepository.findByOrderByDateDesc(pageable);
    }

    @PostMapping("performance")
    ResponseEntity<Object> createNetworkPerformance(@RequestBody NetworkPerformance networkPerformance) {
        return new ResponseEntity<>(networkPerformanceRepository.save(networkPerformance), HttpStatus.CREATED);
    }


//    @PostMapping(value = "save-performance")
//    public ResponseEntity<NetworkPerformance> createPerformance(@Valid @RequestBody NetworkPerformance networkPerformance) throws UnsupportedEncodingException {
//        NetworkPerformance networkPerformance1 = new NetworkPerformance();
//        byte[] decodedBytes = Base64.getDecoder().decode(networkPerformance.getImgUrl());
//        networkPerformance1.setImgUrl(decodedBytes);
//        networkPerformance1.setDate(networkPerformance.getDate());
//        networkPerformance1.setName(networkPerformance.getName());
//        networkPerformance1.setLocation(networkPerformance.getLocation());
//        networkPerformance1.setRatePerformance(networkPerformance.getRatePerformance());
//        networkPerformance1.setTicketId(networkPerformance.getTicketId());
//        this.networkPerformanceRepository.save(networkPerformance1);
//        return ResponseEntity.ok(networkPerformance);
//    }

//    @PostMapping(value = "performance", produces = "application/json", consumes = {"multipart/form-data"})
//    public ResponseEntity<NetworkPerformance> createPerformance(@RequestParam("imageFile") MultipartFile file,
//                                                                @RequestParam("date") String date,
//                                                                @RequestParam("name") String name,
//                                                                @RequestParam("location") String location,
//                                                                @RequestParam("ratePerformance") String ratePerformance,
//                                                                @RequestParam("ticketId") String ticketId,
//                                                                @RequestParam("userId") Long userId) {
//        NetworkPerformance networkPerformance = new NetworkPerformance();
//        networkPerformance.setDate(date);
//        networkPerformance.setName(name);
//        String filename = StringUtils.cleanPath(file.getOriginalFilename());
//        if (filename.contains("..")) {
//            System.out.println("Not a valid file!");
//        }
//        try {
//            networkPerformance.setImageFile(file.getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        networkPerformance.setRatePerformance(ratePerformance);
//        networkPerformance.setLocation(location);
//        networkPerformance.setTicketId(ticketId);
//        networkPerformance.setUserId(userId);
//        return new ResponseEntity<>(networkPerformanceRepository.save(networkPerformance), HttpStatus.CREATED);
//    }


//    @GetMapping("get-performance")
//    public ResponseEntity<List<NetworkPerformanceDto>> getPerformance(Pageable pageable) {
//        Page<NetworkPerformance> networkPerformanceList = this.networkPerformanceRepository.findByOrderByDateDesc(pageable);
//        List<NetworkPerformanceDto> networkPerformanceList1 = new ArrayList<>();
//        networkPerformanceList.stream().forEach(networkPerformance -> {
//            NetworkPerformanceDto networkPerformance1 = new NetworkPerformanceDto();
//            String encodedText = Base64Utils.encodeToString(networkPerformance.getImageFile());
//            networkPerformance1.setImageFile(encodedText);
//            networkPerformance1.setDate(networkPerformance.getDate());
//            networkPerformance1.setName(networkPerformance.getName());
//            networkPerformance1.setLocation(networkPerformance.getLocation());
//            networkPerformance1.setRatePerformance(networkPerformance.getRatePerformance());
//            networkPerformance1.setTicketId(networkPerformance.getTicketId());
//            networkPerformanceList1.add(networkPerformance1);
//        });
//        return ResponseEntity.ok(networkPerformanceList1);
//
//    }


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