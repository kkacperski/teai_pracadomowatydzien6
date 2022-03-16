package pl.kacperski.tydzien6.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import pl.kacperski.tydzien6.model.Film;

@Aspect
@Component
public class FilmAspect {

    @Autowired
    private JavaMailSender javaMailSender;

    @After(value = "@annotation(FilmAspectAdn)")
    private void afterHello(JoinPoint joinPoint){
        Film film = (Film)joinPoint.getArgs()[0];

        System.out.println(film);

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("kkacperski@interia.eu");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("New film added \n Film name: " + film.getName() + "\n Film year: " + film.getYear() + "\n Film director: " + film.getDirector());

        try{
            javaMailSender.send(msg);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
