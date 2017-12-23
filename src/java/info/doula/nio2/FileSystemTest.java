package info.doula.nio2;

import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.io.IOException;

/**
 * Mohammed Hossain Doula
 *
 * @hossaindoula | @itconquest
 *
 * skype: mohammedhossaindoularonnie
 *
 * http://hossaindoula.com
 *
 * https://github.com/hossaindoula
 */
public class FileSystemTest {
	public static void main(String[] args) {
		// Create the platform-specific default file system object  
		FileSystem fs = FileSystems.getDefault();

		System.out.println("Read-only file system: " + fs.isReadOnly());
		System.out.println("File name separator: " + fs.getSeparator());

		System.out.println("\nAvailable file-stores are");

		for(FileStore store : fs.getFileStores()) {
			printDetails(store);
		}

		System.out.println("\nAvailable root directories are");

		for(Path root : fs.getRootDirectories()) {
			System.out.println(root);
		}
	}

	public static void printDetails(FileStore store) {
		try {
			String desc = store.toString();
			String type = store.type();
			long totalSpace = store.getTotalSpace();
			long unallocatedSpace = store.getUnallocatedSpace();
			long availableSpace = store.getUsableSpace();
			System.out.println(desc + ", Total: " + totalSpace +
					      ", Unallocated: " + unallocatedSpace +
			                   ", Available: " + availableSpace);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
