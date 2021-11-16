package fhi0.DIDR.controller;

import fhi0.DIDR.exception.ResourceNotFoundException;
import fhi0.DIDR.model.NetworkPerformance;
import fhi0.DIDR.repository.ImageRepository;
import fhi0.DIDR.repository.NetworkPerformanceRepository;
import fhi0.DIDR.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class NetworkPerformanceController {
    @Autowired
    NetworkPerformanceRepository networkPerformanceRepository;

    @Autowired
    ImageRepository imageRepository;

    @GetMapping("performance")
    List<NetworkPerformance> getNetworkPerformance() {
        return networkPerformanceRepository.findAll(Sort.by("date").descending());
    }


//    @PostMapping("performance")
//    ResponseEntity<Object> createPerformance(@Valid @RequestBody NetworkPerformance networkPerformance) {
//        return new ResponseEntity<>(networkPerformanceRepository.save(networkPerformance), HttpStatus.CREATED);
//    }
//


    @PostMapping("performance")
    ResponseEntity<Object> createPerformance(@Valid NetworkPerformance networkPerformance, @RequestParam("image") MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        networkPerformance.setImage(fileName);

        NetworkPerformance savedPerformance = networkPerformanceRepository.save(networkPerformance);

        String uploadDir = "performance-photos/" + savedPerformance.getId();

        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        return new ResponseEntity<>(networkPerformanceRepository.save(savedPerformance), HttpStatus.CREATED);
    }


//
//    @PostMapping(value = "performance", consumes = "multipart/form-data")
//    public ResponseEntity<Object> createPerformance(@Valid NetworkPerformanceDto  networkPerformance) throws IOException {
//
//        System.out.println("date" + networkPerformance.getDate());
//        System.out.println("name" + networkPerformance.getName());
//        System.out.println("location" + networkPerformance.getLocation());
//        System.out.println("ratePerformance" + networkPerformance.getRatePerformance());
//        System.out.println("ticketId" + networkPerformance.getTicketId());
//        System.out.println("Performance Image" + networkPerformance.getPerformanceImage());
//        try {
////   InputStream initialStream = file.getInputStream();
////   byte[] buffer = new byte[initialStream.available()];
//
////   System.out.println(buffer.length);
////            Image image = new Image();
////            image.setContentType(networkPerformance.getPerformanceImage().getContentType() == null ? "" : networkPerformance.getPerformanceImage().getContentType());
////            image.setData(networkPerformance.getPerformanceImage().getBytes());
////            image.setInUse(true);
////            imageRepository.save(image);
//
//
//        } catch (Exception e) {
//            //  e
//            //
//            // .printStackTrace();
//        }
//        // 1. do we  save in database
//        /*
//         * going with 1 would just be for us to find out how spring saves file in db
//         * mind you your db file size grows
//         *
//         *
//         * */
//
//
//        // 2. do we save in file path
//        /*
//         * going with 2
//         * first save the recdrd
//         * get the id of the saveed record
//         * write the byte[] variable to a file
//         * update th menuImage value with the id.
//         * your databse would have something like 1.jpeg for menuImage.
//         * */
//        NetworkPerformance networkPerformance1 = new NetworkPerformance();
//        networkPerformance1.setDate(networkPerformance1.getDate());
//        networkPerformance1.setLocation(networkPerformance1.getLocation());
//        networkPerformance1.setName(networkPerformance1.getName());
//        networkPerformance1.setTicketId(networkPerformance1.getTicketId());
//
////
//        Image image = new Image();
//        image.setData(networkPerformance.getPerformanceImage().getBytes());
//        image.setDescription(networkPerformance.getName() + " Menu Image");
//        image.setInUse(true);
//        image.setContentType(networkPerformance.getPerformanceImage().getContentType());
//        imageRepository.save(image);
//
//
//        networkPerformance1.setPerformanceImage(image);
//
//        return new ResponseEntity<>(networkPerformanceRepository.save(networkPerformance1), HttpStatus.CREATED);
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
