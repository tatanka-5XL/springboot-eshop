package cz.petrpribil.ita.ws;

import cz.ares.response.VypisRZP;

public interface AresClient {
    VypisRZP getCompanyInfo(String ico);
}