package team.travelmate.domain.Entity;

import team.travelmate.domain.Entity.recruitment.Recruitment;
import team.travelmate.file.UploadFile;

import java.io.Serializable;

public class UploadFilesId implements Serializable {

    private Recruitment recruitment;
    private UploadFile uploadFile;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
