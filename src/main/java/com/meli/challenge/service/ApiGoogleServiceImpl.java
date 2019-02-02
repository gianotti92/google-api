package com.meli.challenge.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.Drive.Files.Export;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.meli.challenge.util.ApiGoogleDrive;

@Service
public class ApiGoogleServiceImpl implements ApiGoogleService {
	private static final Logger logger = LoggerFactory.getLogger(ApiGoogleServiceImpl.class);

	@Autowired
	private ApiGoogleDrive apiGoogleDrive;

	@Override
	public List<File> getFiles(int number) throws IOException, GeneralSecurityException{
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

		Export result = drive.files().export(id, "application/msword");
		result.getJsonContent();
		return true;
	}

	@Override
	public File createFile(String tile, String description) throws IOException, GeneralSecurityException {
		logger.info("class:ApiGoogleServiceImpl, method: createFile(), tile:{}, description:{}", tile, description);
		File fileMetadata = new File();
		fileMetadata.setName(tile);
		fileMetadata.setDescription(description);
		
		Drive drive = apiGoogleDrive.getDrive();
		
		File file = drive.files().create(fileMetadata)
			    .setFields("id")
			    .execute();
		return file;
	}


}
