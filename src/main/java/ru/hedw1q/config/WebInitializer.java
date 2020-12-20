package ru.hedw1q.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/**
 * @author hedw1q
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }
//Определяем класс конфига
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringConfig.class};
    }
//Все запросы посылаем на DIspatcherServlet
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
