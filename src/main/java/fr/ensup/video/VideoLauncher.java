package fr.ensup.video;

import fr.ensup.video.model.Video;
import fr.ensup.video.repository.VideoJdbcTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class VideoLauncher {
    public static void main(String[] args) {
        //SANS JPA
//        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
//        VideoJdbcTemplate videoJdbcTemplate = (VideoJdbcTemplate) context.getBean("videoJdbcTemplate");
//
////        Video video =  new Video(1,"Matrix","film");
////        videoJdbcTemplate.save(video);
////        System.out.println("Une video à été crée : " + video);
//
//        System.out.println(videoJdbcTemplate.get(1));
//        System.out.println(videoJdbcTemplate.getAll());


        //AVEC JPA

        //1-ouverture unite de connection avec JPA
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("video-reco-jpa");
        EntityManager em = emf.createEntityManager();
        //2- Ouverture d'une transaction
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        //3- on instancie d'une vidéo
        Video video =  new Video("naruto","anim");
        //4- on persiste l'objets relationnel
        em.persist(video);
        //5- on commit
        tr.commit();
        //6- on ferme
        em.close();
        emf.close();
    }
}