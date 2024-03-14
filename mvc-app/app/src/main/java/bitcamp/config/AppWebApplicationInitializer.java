package bitcamp.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



public class AppWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  private static Log log = LogFactory.getLog(AppWebApplicationInitializer.class);

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return null;
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[] {AppConfig.class};
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] {"/app/*"};
  }

  @Override
  protected String getServletName() {
    return "app";
  }
}