package team.travelmate.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author yeongwoonshin
 * @version v0.0
 *
 * File 저장 Logic
 * @see UploadFile
 */
@Component
public class FileStore {

    /**
     * application.properties 내 file.dir 값 삽입
     * 경로는 추후 변경 필요
     */
    @Value("${file.dir}")
    private String fileDir;

    /**
     *
     * @param filename 논리적 file 이름
     * @return 논리적 file name 을 경로 + 논리적 file name 로 반환한다.
     */
    public String getFullPath(String filename){
        return fileDir + filename;
    }

    /**
     *
     * @param multipartFiles request multipart
     * @return UploadFile List 반환
     * @throws IOException
     */
    public List<UploadFile> storeFiles(List<MultipartFile> multipartFiles) throws IOException {
        List<UploadFile> storeFileResult = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles){
            if (!multipartFile.isEmpty()){
                storeFileResult.add(storeFile(multipartFile));
            }
        }
        return storeFileResult;
    }

    /**
     *
     * @param multipartFile Upload File
     * @return file 이 없는 경우 : null , file 이 있는 경우 UploadFile 객체 변환 후 반환
     * @throws IOException
     */
    public UploadFile storeFile(MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty()){
            return null;
        }

        String originalFilename = multipartFile.getOriginalFilename();
        String storeFileName = createStoreFileName(originalFilename);
        multipartFile.transferTo(new File(getFullPath(storeFileName)));
        return new UploadFile(originalFilename,storeFileName);

    }

    /**
     * extractExt : 확장자, uuid : 중복 없는 랜덤 값
     * @param originalFilename : user 가 upload 한 file 명
     * @return 중복 없는 랜덤 값 + . + 확장자
     */
    private String createStoreFileName(String originalFilename){
        String ext = extractExt(originalFilename);
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + ext;
    }

    /**
     * 사용자가 upload 한 파일명에서 확장자를 분리
     * @param originalFilename
     * @return File 확장자를 반환
     */
    private String extractExt(String originalFilename){
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos + 1);
    }

}
