/* (C)2020 */
package saps.common.core.storage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import saps.common.core.model.SapsImage;
import saps.common.core.storage.exceptions.TaskNotFoundException;

/**
 * Permanent Storage is responsible for permanently and securely storing the files generated by the
 * tasks and for allowing them to be accessed through links. The saved files are obtained from
 * temporary storage.
 */
// FIXME Remove the boolean return from methods
public interface PermanentStorage {

  /**
   * Attempts to copy the files generated by a Task from temporary storage to permanent storage. The
   * name of the task directory is given by its ID and the task directory has three directories:
   * {@link PermanentStorageConstants#INPUTDOWNLOADING_DIR}, {@link
   * PermanentStorageConstants#PREPROCESSING_DIR} and {@link
   * PermanentStorageConstants#PROCESSING_DIR}.
   *
   * @param task The task that will have its data archived.
   * @return boolean representation, success (true) or failure (false) in to archive the three dirs.
   * @throws FileNotFoundException if the task directory not exists on temp storage
   * @throws IOException if failed on copy any file to permanent storage
   */
  boolean archive(SapsImage task) throws IOException;

  /**
   * This function delete all files from task in Permanent Storage.
   *
   * @param task The task that will have its data deleted.
   * @return boolean representation, success (true) or failure (false) to delete files
   * @throws IOException if failed on copy any file to permanent storage
   */
  boolean delete(SapsImage task) throws IOException;

  /**
   * @param task The task that will have its data deleted.
   * @return Empty list if the task not contains files
   * @throws IOException If a request error occurs with a service or system
   * @throws TaskNotFoundException If task was not found
   */
  List<AccessLink> generateAccessLinks(SapsImage task) throws TaskNotFoundException, IOException;
}
