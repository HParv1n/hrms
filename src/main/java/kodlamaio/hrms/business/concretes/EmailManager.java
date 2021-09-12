package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmailService;
import kodlamaio.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailManager implements EmailService {

//    @Autowired
//    private JavaMailSender javaMailSender;


    @Override
    public void sendVerifyEmail(User user, String code) {
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailMessage.setSubject("HRMS mail verification");
//        mailMessage.setText("Hrms kayıt işleminizi tamamlamak için linke tıklayınız: https://kodlamaio-hrms.herokuapp.com/api/activationcode/active/\"+code");
//        mailMessage.setTo(user.getEmail());
//        mailMessage.setFrom("demo@gmail.com");
//
//        javaMailSender.send(mailMessage);
////        Bunu deqiqlesdir
    }
}
