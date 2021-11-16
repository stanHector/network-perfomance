package fhi0.DIDR.controller;

import fhi0.DIDR.dto.InternetDowntimeDto;
import fhi0.DIDR.dto.UserDto;
import fhi0.DIDR.exception.ResourceNotFoundException;
import fhi0.DIDR.model.InternetDowntime;
import fhi0.DIDR.model.Users;
import fhi0.DIDR.repository.InternetDowntimeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class InternetDowntimeController {

    private final InternetDowntimeRepository internetDowntimeRepository;
    private Logger logger = LoggerFactory.getLogger(InternetDowntimeController.class);

//    private final NotificationService notificationService;

    public InternetDowntimeController(InternetDowntimeRepository internetDowntimeRepository) {
        this.internetDowntimeRepository = internetDowntimeRepository;
    }

    @GetMapping("downtimes")
    List<InternetDowntime> getDowntime() {
        return internetDowntimeRepository.findAll(Sort.by("date").descending());
    }

//    @GetMapping("assets")
//    Page<InternetDowntimeDto> getAssets(Pageable pageable) {
//        return assetRepository.findAll(pageable);
//
//    }

    //get asset by Id
    @GetMapping("downtime/{id}")
    public ResponseEntity<InternetDowntime> getDowntimeById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        InternetDowntime internetDowntime = internetDowntimeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("InternetDowntime not found for this id :: " + id));
        return ResponseEntity.ok().body(internetDowntime);
    }

    @PostMapping("downtime")
    public ResponseEntity<Object> createDowntime(@Valid @RequestBody InternetDowntime internetDowntime) {

        return new ResponseEntity<>(internetDowntimeRepository.save(internetDowntime), HttpStatus.CREATED);
    }

    @PutMapping("downtime/{id}")
    public InternetDowntime updateDowntime(@PathVariable("id") Long id, @Valid @RequestBody InternetDowntimeDto internetDowntimeDto) throws ResourceNotFoundException {
        System.out.println("Update Downtime with ID = " + id + "...");
        InternetDowntime internetDowntime = internetDowntimeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Downtime not found for this id :: " + id));

        internetDowntime.setDuration(internetDowntimeDto.getDuration());
        internetDowntime.setLink(internetDowntimeDto.getLink());

        final InternetDowntime updatedDowntime = internetDowntimeRepository.save(internetDowntime);
        System.out.println("Updated Downtime " + updatedDowntime);
        return internetDowntimeRepository.save(updatedDowntime);
    }

    @DeleteMapping("downtime/{id}")
    public Map<String, Boolean> deleteAsset(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        InternetDowntime internetDowntime = internetDowntimeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("InternetDowntimeDto not found for this id :: " + id));
        internetDowntimeRepository.delete(internetDowntime);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}