package com.bala;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.bala.config.MVCConfig;
import com.bala.config.SpringConfig;
public class WebServletConfiguration implements WebApplicationInitializer{
    public void onStartup(ServletContext ctx) throws ServletException {
    	
    	
    	  // Create the 'root' Spring application context
       AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(SpringConfig.class);
 
        // Manage the lifecycle of the root application context
      //  ctx.addListener(new ContextLoaderListener(rootContext));
 
        // Create the dispatcher servlet's Spring application context
      
             
        // Register and map the dispatcher servlet   	
    	
        /*AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
        webCtx.register(MVCConfig.class);
        webCtx.setServletContext(ctx);
        ServletRegistration.Dynamic servlet = ctx.addServlet("dispatcher", new DispatcherServlet(webCtx));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
        */
        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(SpringConfig.class);
        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher = ctx.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}