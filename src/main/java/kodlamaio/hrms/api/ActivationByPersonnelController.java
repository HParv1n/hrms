package kodlamaio.hrms.api;

import kodlamaio.hrms.business.abstracts.ActivationByPersonnelService;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/ActivationByPersonnel/")
@CrossOrigin
public class ActivationByPersonnelController {


    private ActivationByPersonnelService activationByPersonnelService;

    @Autowired
    public ActivationByPersonnelController(ActivationByPersonnelService activationByPersonnelService) {
        this.activationByPersonnelService = activationByPersonnelService;
    }

    @GetMapping("activateemployer")
    public ResponseEntity<?> activateEmployer(@RequestParam int employerId, @RequestParam int personnelId) {
        Result result = this.activationByPersonnelService.activateEmployer(employerId, personnelId);
        if (result.isSucces()) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
