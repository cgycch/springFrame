package com.cch.common.excels;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.crypt.temp.EncryptedTempData;
import org.apache.poi.poifs.crypt.temp.SXSSFWorkbookWithCustomZipEntrySource;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.TempFile;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;

import com.cch.entities.BeanOne;

public class PTREncryptExcelGenerator<T> {
	
	public static void main(String[] args) throws Exception {
		
		
	}
	
	
	
	
	
	public File generateEncryptExcel(List<BeanOne> data, String filename,String password,List<T> dataList) throws Exception {
		File parenPath = new File(filename).getParentFile();
		if(!parenPath.exists()) {
			parenPath.mkdirs();
		}
		SXSSFWorkbookWithCustomZipEntrySource wb = new SXSSFWorkbookWithCustomZipEntrySource();
		try {
			//simple add data
//			for (int i = 0; i < 5; i++) {
//				SXSSFSheet sheet = wb.createSheet("Sheet" + i);
//				for (int r = 0; r < 100; r++) {
//					SXSSFRow row = sheet.createRow(r);
//					for (int c = 0; c < 100; c++) {
//						SXSSFCell cell = row.createCell(c);
//						cell.setCellValue("abcd");
//					}
//				}
//			}
			SXSSFSheet sheet = wb.createSheet("Sheet");
			for (int r = 0; r < data.size(); r++) {
				SXSSFRow row = sheet.createRow(r);
				for (int c = 0; c < 30; c++) {
					SXSSFCell cell = row.createCell(c);
					cell.setCellValue(data.get(r).getName()+"Abcdefg");
				}
			}

			
			//save
			EncryptedTempData tempData = new EncryptedTempData();
			try {
				wb.write(tempData.getOutputStream());
				save(tempData.getInputStream(), filename, password);
				System.out.println("Saved " + filename);
			} finally {
				tempData.dispose();
			}
		}finally {
			wb.close();
			wb.dispose();
		}
		return null;
	}

	public static void save(final InputStream inputStream, final String filename, final String pwd)
			throws InvalidFormatException, IOException, GeneralSecurityException {
		POIFSFileSystem fs = null;
		FileOutputStream fos = null;
		OPCPackage opc = null;
		try {
			fs = new POIFSFileSystem();
			EncryptionInfo info = new EncryptionInfo(EncryptionMode.agile);
			Encryptor enc = Encryptor.getInstance(info);
			enc.confirmPassword(pwd);
			opc = OPCPackage.open(inputStream);
			fos = new FileOutputStream(filename);
			opc.save(enc.getDataStream(fs));
			fs.writeFilesystem(fos);
		} finally {
			IOUtils.closeQuietly(fos);
			IOUtils.closeQuietly(opc);
			IOUtils.closeQuietly(fs);
			IOUtils.closeQuietly(inputStream);
		}
	}
	
	public static void checkTempFiles() throws IOException {
        String tmpDir = System.getProperty(TempFile.JAVA_IO_TMPDIR) + "/poifiles";
        File tempDir = new File(tmpDir);
        if(tempDir.exists()) {
            String[] tempFiles = tempDir.list();
            if(tempFiles != null && tempFiles.length > 0) {
                System.out.println("found files in poi temp dir " + tempDir.getAbsolutePath());
                for(String filename : tempFiles) {
                    System.out.println("file: " + filename);
                }
            }
        } else {
            System.out.println("unable to find poi temp dir");
        }
    }
}
