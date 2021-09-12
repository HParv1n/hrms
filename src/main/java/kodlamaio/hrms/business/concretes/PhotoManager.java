package kodlamaio.hrms.business.concretes;

import com.cloudinary.Url;
import kodlamaio.hrms.business.abstracts.PhotoService;
import kodlamaio.hrms.core.services.CloudinaryService;
import kodlamaio.hrms.core.utils.result.*;
import kodlamaio.hrms.dataAccess.abstracts.PhotoDao;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class PhotoManager implements PhotoService {

    private PhotoDao photoDao;
    private ResumeDao resumeDao;
    private CloudinaryService cloudinaryService;


    @Autowired
    public PhotoManager(PhotoDao photoDao, ResumeDao resumeDao, CloudinaryService cloudinaryService) {
        this.photoDao = photoDao;
        this.resumeDao = resumeDao;
        this.cloudinaryService = cloudinaryService;
    }


    @Override
    public DataResult<List<Photo>> getAll() {
        return null;
//        return new SuccessDataResult<List<Photo>>("Photo listed",this.photoDao.getByOrOrderByPhotoId());
    }

    @Override
    public Result update(MultipartFile multipartFile, int resumeId) {
        try {
            BufferedImage bufferedImage = ImageIO.read(multipartFile.getInputStream());
            if (bufferedImage == null) {
                return new ErrorResult("Image validation failed");
            }
        } catch (IOException e) {
            return new ErrorResult("Image validation failed");
        }
        Photo photo = this.photoDao.getByResume_ResumeId(resumeId);
        if (photo.getPhotoId() == null) {
            try {
                Map result = cloudinaryService.upload(multipartFile);
                photo.setPhotoUrl((String) result.get("url"));
                photo.setImageId((String) result.get("public_id"));
                this.photoDao.save(photo);
                return new SuccessResult("Photo entered");
            } catch (IOException e) {
                return new ErrorResult("There was a problem while uploading the image.");
            }
        } else if (photo.getImageId() != null) {
            try {
                Map result = cloudinaryService.delete(photo.getImageId());
                Map result2 = cloudinaryService.upload(multipartFile);
                photo.setPhotoUrl((String) result2.get("url"));
                photo.setImageId((String) result2.get("public_id"));
                this.photoDao.save(photo);
                return new ErrorResult("Successfully uploaded");
            } catch (IOException exception) {
                return new ErrorResult("There was a problem while uploading the image");
            }
        } else {
            return new ErrorResult("There is a problem please contact us");
        }
    }

    @Override
    public Result delete(int id) {
        if (!this.photoDao.existsById(id)) {
            return new ErrorResult("There is such photo is not found");
        }
        try {
            Photo photo = this.photoDao.getById(id);
            Map result = cloudinaryService.delete(photo.getImageId());
            photo.setImageId(null);
            photo.setPhotoUrl("https://t4.ftcdn.net/jpg/00/64/67/63/360_F_64676383_LdbmhiNM6Ypzb3FM4PPuFP9rHe7ri8Ju.jpg");
            this.photoDao.save(photo);
            return new SuccessResult("Photo successfully deleted");
        } catch (IOException exception) {
            return new ErrorResult("Something went wrong");
        }
    }

    @Override
    public DataResult<Photo> getById(int id) {
        if (!this.photoDao.existsById(id)) {
            return new ErrorDataResult<Photo>("No image found for this id");
        }
        return new SuccessDataResult<Photo>("The image of the given id is listed", this.photoDao.getById(id));
    }

    @Override
    public Boolean isExist(int id) {
        return this.photoDao.existsById(id);
    }
}
