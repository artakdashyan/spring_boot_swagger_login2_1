package am.spring_boot_swagger_login.spring_boot_swagger_login.repository;


import am.spring_boot_swagger_login.spring_boot_swagger_login.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Long> {

}
