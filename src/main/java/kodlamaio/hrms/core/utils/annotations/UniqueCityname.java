//package kodlamaio.hrms.core.utils.annotations;
//
//
//import kodlamaio.hrms.core.utils.validators.UniqueCitynameValidator;
//
//import javax.validation.Constraint;
//import javax.validation.Payload;
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
//@Target({ElementType.FIELD})
//@Retention(RetentionPolicy.RUNTIME)
//@Constraint(validatedBy = {UniqueCitynameValidator.class})
//public @interface UniqueCityname {
//
//    String message() default "{hrms.constraint.cityname.UniqueCityname.messsage}";
//
//    Class<?>[] groups() default {};
//
//    Class<? extends Payload>[] payload() default {};
//}
