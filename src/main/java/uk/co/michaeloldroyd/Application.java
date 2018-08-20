package uk.co.michaeloldroyd;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import java.util.EnumSet;

public class Application implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext context
                = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("uk.co.michaeloldroyd");

        servletContext.addListener(new ContextLoaderListener(context));

        ServletRegistration.Dynamic dispatcher = servletContext
                .addServlet("dispatcher", new DispatcherServlet(context));

        DelegatingFilterProxy exampleServletFilter = new DelegatingFilterProxy("exampleServletFilter");
        servletContext.addFilter("exampleServletFilter", exampleServletFilter)
                .addMappingForUrlPatterns(
                        EnumSet.of(DispatcherType.REQUEST),
                        true,
                        "/example-filtered/*",
                        "/example-exception/*"
                );

        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
