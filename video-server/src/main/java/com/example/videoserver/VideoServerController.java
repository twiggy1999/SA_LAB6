package com.example.videoserver;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import javax.servlet.http.HttpServletRequest;
import java.nio.file.Path;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@CrossOrigin(origins = "*",allowCredentials="true",allowedHeaders = "",methods = {})
@AllArgsConstructor
public class VideoServerController {

    private final MyResourceHttpRequestHandler myResourceHttpRequestHandler;
    @Autowired
    public RabbitTemplate rabbitTemplate;
    @Bean
    public Queue VideoQueue() {
        return new Queue("VideoQueue", false);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public void saveUploadFile(@RequestParam("file") MultipartFile file) throws IOException, InterruptedException {
       string name=file.getOriginalFilename();
        File answer = new File("C:\\SA_Lab6\\video-sample\\raw\\"+name);
        file.transferTo(answer);
        rabbitTemplate.convertAndSend("VideoQueue", name);
    }

    @RequestMapping(value = "/files", method = RequestMethod.GET)
    @ResponseBody
    public List<String> getFiles(HttpServletResponse response) {
        List<String> fileNameGroup = new ArrayList();
        response.setHeader("Access-Control-Allow-Origin", "*");
        File allFile = new File("C:\\SA_Lab6\\video-sample\\raw\\");
        File[] files = allFile.listFiles();
        for (File id : files) {
            if (id.isFile()) {
                fileNameGroup.add(id.getName());
            }
        }
        return fileNameGroup;
    }

    @GetMapping("/play/360/{name}")
    public void videoPreview360(HttpServletRequest request, HttpServletResponse response,@PathVariable("name") String name) throws Exception {
        Path filePath = Paths.get("C:\\SA_Lab6\\video-sample\\360\\" + name);
        request.setAttribute("NON-STATIC-FILE", filePath);
            String type = Files.probeContentType(filePath);
            if (!StringUtils.isEmpty(type)) {
                response.setContentType(type);
            }
            myResourceHttpRequestHandler.handleRequest(request, response);
    }

    @GetMapping("/play/720/{name}")
    public void videoPreview720(HttpServletRequest request, HttpServletResponse response,@PathVariable("name") String name) throws Exception {
        Path filePath = Paths.get("C:\\SA_Lab6\\video-sample\\720\\" + name);
            String type = Files.probeContentType(filePath);
            request.setAttribute("NON-STATIC-FILE", filePath);
            if (!StringUtils.isEmpty(type)) {
                response.setContentType(type);
            }
            myResourceHttpRequestHandler.handleRequest(request, response);
    }

    @GetMapping("/play/1080/{name}")
    public void videoPreview1080(HttpServletRequest request, HttpServletResponse response, @PathVariable("name") String name) throws Exception {
        Path filePath = Paths.get("C:\\SA_Lab6\\video-sample\\1080\\" + name);
        String type = Files.probeContentType(filePath);
        request.setAttribute("NON-STATIC-FILE", filePath);
        if (!StringUtils.isEmpty(type)) {
            response.setContentType(type);
        }
            myResourceHttpRequestHandler.handleRequest(request, response); 
    }

}