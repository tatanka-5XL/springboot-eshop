package cz.petrpribil.ita.rest;

import cz.ares.response.VypisRZP;
import cz.petrpribil.ita.ws.AresClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final AresClient aresClient;

    @GetMapping("{id}")
    public VypisRZP getById(@PathVariable String id) {
        return aresClient.getCompanyInfo(id);
    }
}
