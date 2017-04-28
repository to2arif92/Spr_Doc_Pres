package pkg.spring.basic.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ArIF on 04-Apr-17.
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter{

    // Config UTF-8 Encoding.
    private static final Charset UTF8 = Charset.forName("UTF-8");

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        // HTTP
        converters.add(new StringHttpMessageConverter());

        // JSON
        converters.add(new MappingJackson2HttpMessageConverter());
        System.out.println("MappingJackson2HttpMessageConverter added");

        // XML
        converters.add(new MappingJackson2XmlHttpMessageConverter());

        // Add other converters ...

    }


    // Static resource path config
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("/fonts/");
        registry.addResourceHandler("/images/**").addResourceLocations("/images/");
        // {appContext}/js/x.js is now mapped with this path '/WEB-INF/resources/js/x.js'
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/resources/js/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
    {
        configurer.enable();
    }
}
