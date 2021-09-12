package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.entities.concretes.ActivationCode;
import kodlamaio.hrms.entities.concretes.User;

public interface ActivationCodeService {
    ActivationCode getByCode(String code);

    String createActivationCode(User user);

    Result activateUser(String code);
}
