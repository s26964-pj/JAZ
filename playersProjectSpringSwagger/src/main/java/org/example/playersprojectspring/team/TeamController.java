package org.example.playersprojectspring.team;

import org.openapitools.api.TeamsApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teams")
public class TeamController implements TeamsApi {
}
