package fr.ensup.video;

import fr.ensup.video.mapper.VideoMapper;
import fr.ensup.video.model.User;
import fr.ensup.video.model.Video;
import fr.ensup.video.model.VideoLabel;
import fr.ensup.video.repository.VideoJdbcTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        //3- on instancie d'une vidéo avec des labels
        Video video =  new Video("naruto","anim");
        Video video2 =  new Video("harry","film");
        VideoLabel videoLabel = new VideoLabel("Action");
        VideoLabel videoLabel1 = new VideoLabel("Palpitant");
        VideoLabel videoLabel2 = new VideoLabel("Horreur");
        video.getVideoLabels().add(videoLabel);
        video.getVideoLabels().add(videoLabel1);
        video.getVideoLabels().add(videoLabel2);
        Set<VideoLabel> videoLabels = new HashSet<VideoLabel>();
        videoLabels.add(videoLabel);
        videoLabels.add(videoLabel1);
        videoLabels.add(videoLabel2);
        video.setVideoLabels(videoLabels);
        Set<Video> videos= new HashSet<>();
        videos.add(video);
        videos.add(video2);


        User user = new User("flavien","annaix","dev");
        user.setVideos(videos);
        //4- on persiste l'objets relationnel
        em.persist(video2);
        em.persist(user);
//        em.persist(videoLabel);
//        em.persist(videoLabel1);
//        em.persist(videoLabel2);
//        em.persist(video);

        var videoFound = em.find(Video.class,2l);
//requete native
        String query = "Select * from video  WHERE title = 'naruto'";
        var videofound1 = em.createNativeQuery(query,Video.class);
        System.out.println(videofound1.getResultList());


        //5- on commit
        tr.commit();
        //6- on ferme
        em.close();
        emf.close();
    }
}