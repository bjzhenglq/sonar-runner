/*
 * Sonar Standalone Runner
 * Copyright (C) 2011 SonarSource
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.runner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import org.junit.Test;

public class LauncherTest {

  @Test
  public void shouldNotFailWhenPathNotSpecified() {
    Launcher.getLibraries("file.jar");
  }

  @Test
  public void shouldFilterFiles() throws Exception {
    File dir = new File(getClass().getResource("/org/sonar/runner/LauncherTest/shouldFilterFiles/").toURI());
    assertThat(Launcher.getLibraries(dir.getAbsolutePath() + "/in*.txt").length, is(1));
    assertThat(Launcher.getLibraries(dir.getAbsolutePath() + "/*.txt").length, is(2));
  }

}
