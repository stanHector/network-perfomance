package fhi0.DIDR.model;

import javax.persistence.*;

@Entity
@Table(name = "network_files")
public class NetworkFiles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fileName;
    private String modifiedFileName;
    private String fileExtension;

    @ManyToOne
    @JoinColumn(name = "network_performance_id")
    private NetworkPerformance networkPerformance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getModifiedFileName() {
        return modifiedFileName;
    }

    public void setModifiedFileName(String modifiedFileName) {
        this.modifiedFileName = modifiedFileName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public NetworkPerformance getNetworkPerformance() {
        return networkPerformance;
    }

    public void setNetworkPerformance(NetworkPerformance networkPerformance) {
        this.networkPerformance = networkPerformance;
    }
}
