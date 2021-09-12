package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concretes.User;

public interface EmailService {

    void sendVerifyEmail(User user, String code);
}
