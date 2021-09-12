//package kodlamaio.hrms.core.utils.validators;
//
//import kodlamaio.hrms.core.utils.annotations.UniqueJobtitleName;
//import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
//import kodlamaio.hrms.entities.concretes.JobTitle;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//public class UniqueJobtitleValidator implements ConstraintValidator<UniqueJobtitleName,String> {
//
//    @Autowired
//    private JobTitleDao jobTitleDao;
//
//    @Override
//    public boolean isValid(String jobTitleName, ConstraintValidatorContext constraintValidatorContext) {
//        JobTitle jobTitle = jobTitleDao.findByJobTitleName(jobTitleName);
//        if (jobTitle != null ){
//            return false;
//        }
//        return true;
//    }
//}
