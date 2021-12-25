package com.example.final_project.logging;

import com.example.final_project.cache.EhCache;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.logging.Logger;

@Logged
@Provider
public class LoggingFilter implements ContainerRequestFilter {

    static Logger log = Logger.getLogger(LoggingFilter.class.getName());

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        String data = "\n";
        data += "REQUEST_METHOD: " + requestContext.getMethod() + "\n";
        data += "MEDIA_TYPE: " + requestContext.getMediaType() + "\n";
        data += "ENTITY_STREAM: " + requestContext.getEntityStream();
        EhCache.setCache(data);
        log.info(data);
    }
}
