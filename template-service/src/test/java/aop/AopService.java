package aop;

public interface AopService {

    Boolean before();

    Boolean after();

    Integer exception(Boolean flag);

    Boolean introduce();
}
