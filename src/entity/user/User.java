package entity.user;
import java.time.LocalDateTime;

public interface User {

    String getName();

    String getPassword();

    String getUserFolders();

    LocalDateTime getCreationTime();
}
