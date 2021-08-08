package filedemo.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties (prefix="file")

public class FileStorageProperties {

    private String uploadDir;
    public String getUploadDir() {
        return uploadDir;
    }
    public void setUploadDir(String uploadDir) {
        this.uploadDir=uploadDir;

    }
}
