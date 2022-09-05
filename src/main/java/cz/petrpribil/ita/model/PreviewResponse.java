package cz.petrpribil.ita.model;

import lombok.Data;

/**
 * PreviewResponse
 *
 * @author Petr Pribil, petr.pribil@profisolv.com, 2022
 */

@Data
public class PreviewResponse {
    private String filename;
    private byte[] bytes;

}
