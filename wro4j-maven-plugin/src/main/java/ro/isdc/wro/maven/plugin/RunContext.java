/*
 * Copyright (C) 2010.
 * All rights reserved.
 */
package ro.isdc.wro.maven.plugin;

import java.io.File;
import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


/**
 * A context for "run" mojo goal.
 *
 * @author Alex Objelean
 */
@SuppressWarnings("serial")
public class RunContext
  implements Serializable {
  private File wroFile;
  private File contextFolder;
  private boolean minimize;
  private boolean ignoreMissingResources;

  /**
   * @return the wroFile
   */
  public File getWroFile() {
    return wroFile;
  }


  /**
   * @param wroFile the wroFile to set
   */
  public void setWroFile(final File wroFile) {
    this.wroFile = wroFile;
  }


  /**
   * @return the contextFolder
   */
  public File getContextFolder() {
    return contextFolder;
  }


  /**
   * @param contextFolder the contextFolder to set
   */
  public void setContextFolder(final File contextFolder) {
    this.contextFolder = contextFolder;
  }


  /**
   * @return the minimize
   */
  public boolean isMinimize() {
    return minimize;
  }


  /**
   * @param minimize the minimize to set
   */
  public void setMinimize(final boolean minimize) {
    this.minimize = minimize;
  }


  /**
   * @return the ignoreMissingResources
   */
  public boolean isIgnoreMissingResources() {
    return ignoreMissingResources;
  }


  /**
   * @param ignoreMissingResources the ignoreMissingResources to set
   */
  public void setIgnoreMissingResources(final boolean ignoreMissingResources) {
    this.ignoreMissingResources = ignoreMissingResources;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
}
