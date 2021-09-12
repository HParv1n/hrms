//package kodlamaio.hrms.core.utils.annotations;
//
//import kodlamaio.hrms.core.utils.validators.UniqueJobtitleValidator;
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
//@Constraint(validatedBy = {UniqueJobtitleValidator.class})
//public @interface UniqueJobtitleName {
//
//    String message() default "{hrms.constraint.jobtitlename.UniqueJobTitlename.messsage}";
//
//    Class<?>[] groups() default {};
//
//    Class<? extends Payload>[] payload() default {};
//}
