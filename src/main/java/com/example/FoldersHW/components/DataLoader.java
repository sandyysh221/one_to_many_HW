package com.example.FoldersHW.components;

import com.example.FoldersHW.models.ExtensionTypes;
import com.example.FoldersHW.models.File;
import com.example.FoldersHW.models.Folder;
import com.example.FoldersHW.models.User;
import com.example.FoldersHW.repositories.FileRepository;
import com.example.FoldersHW.repositories.FolderRepository;
import com.example.FoldersHW.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    UserRepository userRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    FileRepository fileRepository;

    public DataLoader() {}
    public void run(ApplicationArguments args) {
        User sandy = new User("Sandy");
        userRepository.save(sandy);

        User chris = new User("Chris");
        userRepository.save(chris);

        User clare = new User("Clare");
        userRepository.save(clare);

        Folder documents = new Folder("Documents", sandy);
        folderRepository.save(documents);

        Folder codeclan_work = new Folder("codeclan_work", chris);
        folderRepository.save(codeclan_work);

        Folder shecodes = new Folder("SheCodes", clare);
        folderRepository.save(shecodes);

        File cv = new File("CV", ExtensionTypes.TXT, 1, documents);
        fileRepository.save(cv);

        File lab = new File("employee_lab", ExtensionTypes.JAVA, 2, codeclan_work);
        fileRepository.save(lab);

        File weather_app = new File("weather_app", ExtensionTypes.PY, 5, shecodes);
        fileRepository.save(weather_app);
    }
}
