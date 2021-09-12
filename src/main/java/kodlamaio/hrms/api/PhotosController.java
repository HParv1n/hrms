package kodlamaio.hrms.api;


import kodlamaio.hrms.business.abstracts.PersonnelService;
import kodlamaio.hrms.business.abstracts.PhotoService;
import kodlamaio.hrms.core.services.CloudinaryService;
import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.dataAccess.abstracts.PersonnelDao;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/photos/")
public class PhotosController {

    private CloudinaryService cloudinaryService;
    private PhotoService photoService;
    private ResumeDao resumeDao;


    @Autowired
    public PhotosController(CloudinaryService cloudinaryService, PhotoService photoService, ResumeDao resumeDao) {
        this.cloudinaryService = cloudinaryService;
        this.photoService = photoService;
        this.resumeDao = resumeDao;
    }


//    @GetMapping("getAll")
//    public DataResult<List<Photo>> getAll() {
//        return this.photoService.getAll();
//    }

    @CrossOrigin
    @PostMapping("upload")
    public Result update(@RequestParam MultipartFile multipartFile, @RequestParam int resumeId) {
        return this.photoService.update(multipartFile, resumeId);
    }

    @DeleteMapping("delete")
    public Result delete(@RequestParam int id) {
        return this.photoService.delete(id);
    }
}
