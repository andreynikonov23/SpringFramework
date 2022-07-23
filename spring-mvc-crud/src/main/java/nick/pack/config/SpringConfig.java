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
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
		resolver.setApplicationContext(context);
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".html");
		return resolver;
	}
	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setTemplateResolver(templateResolver());
		engine.setEnableSpringELCompiler(true);
		return engine;
	}
	public void configureViewResolvers(ViewResolverRegistry registry) {
		ThymeleafViewResolver thymeleaf = new ThymeleafViewResolver();
		thymeleaf.setTemplateEngine(templateEngine());
		registry.viewResolver(thymeleaf);
	}
}
