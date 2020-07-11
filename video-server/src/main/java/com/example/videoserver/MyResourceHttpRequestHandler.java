package com.example.videoserver;
import org.springframework.stereotype.Component;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.core.io.FileSystemResource;
import java.nio.file.Path;
import javax.servlet.http.HttpServletRequest;

@Component
public class MyResourceHttpRequestHandler extends ResourceHttpRequestHandler {
    @Override
    protected Resource getResource(HttpServletRequest request) {
        final Path filePath = (Path) request.getAttribute("NON-STATIC-FILE");
        return new FileSystemResource(filePath);
    }

}