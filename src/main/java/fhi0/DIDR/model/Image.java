package fhi0.DIDR.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Abbas Irekeola
 * @Email abbasirekeola@gmail.com
 * 26/05/2021-21:15
 */

@Entity
@Table(name = "image")
@Data
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Lob
    private byte[] data;

    public String externalReferencePath;
    public String description;
    public Boolean inUse;

    public String contentType;

}
