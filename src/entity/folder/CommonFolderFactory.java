package entity.folder;

public class CommonFolderFactory implements FolderFactory {

    @Override
    public Folder create(String foldername) {
        return new CommonFolder(foldername);
    }
}
