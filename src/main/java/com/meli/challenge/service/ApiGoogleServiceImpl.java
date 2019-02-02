package com.meli.challenge.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.client.http.FileContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.meli.challenge.util.ApiGoogleDrive;

@Service
public class ApiGoogleServiceImpl implements ApiGoogleService {
	private static final Logger logger = LoggerFactory.getLogger(ApiGoogleServiceImpl.class);

	@Autowired
	private ApiGoogleDrive apiGoogleDrive;

	@Override
	public List<File> getFiles(int number) throws IOException, GeneralSecurityException {
		logger.info("class:ApiGoogleServiceImpl, method: getFiles(), number of files returned:{}", number);
		Drive drive = apiGoogleDrive.getDrive();
		FileList result = drive.files().list().setPageSize(number).setFields("nextPageToken, files(id, name)")
				.execute();
		return result.getFiles();
	}

	@Override
	public boolean containsWord(String id, String word) throws IOException, GeneralSecurityException {
		logger.info("class:ApiGoogleServiceImpl, method: containsWord(), id:{}, word:{}", id, word);
		Drive drive = apiGoogleDrive.getDrive();

		OutputStream outPutStream = new ByteArrayOutputStream();
		drive.files().get(id).executeMediaAndDownloadTo(outPutStream);
		String text = outPutStream.toString();
		return text.contains(word);

	}

	@Override
	public File createFile(String title, String description) throws IOException, GeneralSecurityException {
		logger.info("class:ApiGoogleServiceImpl, method: createFile(), tile:{}, description:{}", title, description);

		File fileMetadata = new File();
		fileMetadata.setName("EJEMPLO");
		java.io.File filePath = new java.io.File("/home/lucas/Escritorio/TEST");
		FileContent mediaContent = new FileContent("text/plain", filePath);
		File file = apiGoogleDrive.getDrive().files().create(fileMetadata, mediaContent)
		    .setFields("id")
		    .execute();
		
		return file;
	}

}
