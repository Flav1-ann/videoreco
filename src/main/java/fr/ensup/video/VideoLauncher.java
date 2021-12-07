package fr.ensup.video;

import fr.ensup.video.model.Video;
import fr.ensup.video.repository.VideoJdbcTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class VideoLauncher {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        VideoJdbcTemplate videoJdbcTemplate = (VideoJdbcTemplate) context.getBean("videoJdbcTemplate");

//        Video video =  new Video(1,"Matrix","film");
//        videoJdbcTemplate.save(video);
//        System.out.println("Une video à été crée : " + video);

        System.out.println(videoJdbcTemplate.get(1));
        System.out.println(videoJdbcTemplate.getAll());
    }
}