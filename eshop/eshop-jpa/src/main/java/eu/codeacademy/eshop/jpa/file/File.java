package eu.codeacademy.eshop.jpa.file;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Builder.Default
    private UUID fileId = UUID.randomUUID();

    @Column(length = 100)
    private String fileName;

    private String fileExtension;

    private String mediaType;

    private long size;

    public String getUniqFileName() {
        return fileId.toString() + "." + fileExtension;
    }
}
