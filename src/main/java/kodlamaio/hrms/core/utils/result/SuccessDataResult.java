package kodlamaio.hrms.core.utils.result;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

import java.util.List;

public class SuccessDataResult<T> extends DataResult<T> {

    public SuccessDataResult(T data) {
        super(true, data);
    }

    public SuccessDataResult(String message, T data) {
        super(true, message, data);
    }

    public SuccessDataResult(String message) {
        super(true, message, null);
    }


}
