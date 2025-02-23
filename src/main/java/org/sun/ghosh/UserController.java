package org.sun.ghosh;

import java.util.Arrays;
import java.util.List;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.serde.annotation.Serdeable;

@Controller("/self/ai")
public class UserController {

    @Introspected
    @Serdeable
    public record User(String userId,
                       String name, 
                       List<String> behaviours2Track) {
    }

    @Get("/")
    @Secured(SecurityRule.IS_ANONYMOUS)
    List<User> list() {
        return List.of(
                new User("alpha_uno",
                        "Sunit",
                        Arrays.asList("Screen time",
                                "Sleep time",
                                "Work time")),

                new User("beta_uno",
                        "Ghosh",
                        Arrays.asList("Travel time",
                                "Exercise time"))

        );
    }

}
