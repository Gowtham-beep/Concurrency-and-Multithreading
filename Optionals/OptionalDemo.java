package Optionals;

import java.util.Optional;

public class OptionalDemo {

    public static Optional<User> findUserById(int id){
        if(id == 1){
            return Optional.of(new User("jon.example.com"));
        }else{
            return Optional.empty();
        }
    }
    public static void main(String[] args) {
        Optional<User> optional1=findUserById(1);
        String email1 = optional1
                                .map(User->User.getEmail(0))
                                .orElse("email not avalable");
        System.out.println("User 1 Email:" + email1);

        Optional<User> optional2=findUserById(2);
        String email2 = optional2
                                .map(User->User.getEmail(0))
                                .orElse("email not avalable");
        System.out.println("User 2 Email:" + email2);
    }
    
}
