package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("BMW",520);
      Car car2 = new Car("Mazda", 626);
      userService.add(new User("User1", "Lastname1", "user1@mail.ru", car1));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", car2));

      List<User> users = userService.listUsers();
      System.out.println(users);

      User userCar = userService.UserCar("BMW", 520);
      System.out.println(userCar);

      context.close();
   }
}
