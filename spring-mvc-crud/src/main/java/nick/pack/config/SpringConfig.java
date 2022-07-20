package nick.pack.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
@ComponentScan("nick.pack")
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer {
	private final ApplicationContext context;
	
	@Autowired
	public SpringConfig(ApplicationContext context) {
		this.context = context;
	}
	
	@Bean
	public SpringResourceTemplateResolver  templateResolver() {
		SpringResourceTemplateResolver tempResolver = new SpringResourceTemplateResolver();
		tempResolver.setApplicationContext(context);
		tempResolver.setPrefix("/WEB-INF/view/");
		tempResolver.setSuffix(".html");
		return tempResolver;
	}
	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine tempEngine = new SpringTemplateEngine();
		tempEngine.setTemplateResolver(templateResolver());
		tempEngine.setEnableSpringELCompiler(true);
		return tempEngine;
	}
	
	
	public void configureViewResolver(ViewResolverRegistry registry) {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(templateEngine());
		registry.viewResolver(resolver);
	}
}
