package github.kkpolak.start;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;

@RestController
public class StartController extends HttpServlet {
    private static final String NAME_PARAM = "name";
    private static final String LANG_PARAM = "lang";
    private final Logger logger = LoggerFactory.getLogger(StartController.class);

    private StartService service;

    StartController(StartService service){
        this.service = service;
    }

    @GetMapping(value = "/api")
    String welcome () {
        return welcome(null, null);
    }

    @GetMapping(value = "/api", params = {"lang", "name"})
    String welcome (@RequestParam("lang") Integer langId, @RequestParam String name) {
        logger.info("Got request" );
        return service.prepareWelcomeMessage(name, langId);
    }
}
