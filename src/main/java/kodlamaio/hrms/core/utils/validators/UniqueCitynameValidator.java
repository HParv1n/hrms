//package kodlamaio.hrms.core.utils.validators;
//
//import kodlamaio.hrms.core.utils.annotations.UniqueCityname;
//import kodlamaio.hrms.dataAccess.abstracts.CityDao;
//import kodlamaio.hrms.entities.concretes.City;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//public class UniqueCitynameValidator implements ConstraintValidator<UniqueCityname,String> {
//
//    @Autowired
//    private CityDao cityDao;
//
//    @Override
//    public boolean isValid(String cityName, ConstraintValidatorContext constraintValidatorContext) {
//        City city = cityDao.findByCityName(cityName);
//        if (city != null) {
//            return false;
//        }
//        return true;
//    }
//}