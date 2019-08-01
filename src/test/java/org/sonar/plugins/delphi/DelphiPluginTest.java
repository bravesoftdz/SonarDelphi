/*
 * Sonar Delphi Plugin
 * Copyright (C) 2011 Sabre Airline Solutions and Fabricio Colombo
 * Author(s):
 * Przemyslaw Kociolek (przemyslaw.kociolek@sabre.com)
 * Michal Wojcik (michal.wojcik@sabre.com)
 * Fabricio Colombo (fabricio.colombo.mva@gmail.com)
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
package org.sonar.plugins.delphi;

import java.util.List;
import org.junit.Test;
import org.sonar.api.Plugin;
import org.sonar.api.SonarQubeSide;
import org.sonar.api.SonarRuntime;
import org.sonar.api.internal.SonarRuntimeImpl;
import org.sonar.api.utils.Version;

import static junit.framework.TestCase.assertTrue;

/**
 * @author Evgeny Mandrikov
 */
public class DelphiPluginTest {

  @Test
  public void testGetExtensions60() {
    Version v60 = Version.create(6, 0);

    assertTrue(extensions(SonarRuntimeImpl.forSonarQube(v60,
            SonarQubeSide.SERVER)).size() == 20);
    assertTrue(extensions(SonarRuntimeImpl.forSonarLint(v60)).size() == 5);
  }

  @Test
  public void testGetExtensions72() {
    Version v72 = Version.create(7, 2);

    assertTrue(extensions(SonarRuntimeImpl.forSonarQube(v72,
            SonarQubeSide.SERVER)).size() == 22);
//     assertTrue(extensions(SonarRuntimeImpl.forSonarQube(v72,
//             SonarQubeSide.SERVER))).contains(NoOpAnalysisWarningsWrapper
//             .class);
//      assertTrue(extensions(SonarRuntimeImpl.forSonarQube(v72,
//              SonarQubeSide.SERVER))).doesNotContain
//              (DefaultAnalysisWarningsWrapper.class);
    assertTrue(extensions(SonarRuntimeImpl.forSonarLint(v72)).size() == 5);
  }
  @Test
  public void testGetExtensions74() {
    Version v74 = Version.create(7, 4);
    assertTrue(extensions(SonarRuntimeImpl.forSonarQube(v74,
            SonarQubeSide.SERVER)).size() == 22);
  //  assertTrue(extensions(SonarRuntimeImpl.forSonarQube(v74,
  //          SonarQubeSide.SERVER))).doesNotContain
    //          (NoOpAnalysisWarningsWrapper.class);
  //  assertTrue(extensions(SonarRuntimeImpl.forSonarQube(v74,
    //        SonarQubeSide.SERVER))).contains(DefaultAnalysisWarningsWrapper
    //        .class);
    assertTrue(extensions(SonarRuntimeImpl.forSonarLint(v74)).size() == 5);
  }

  private static List extensions(SonarRuntime runtime) {
    Plugin.Context context = new Plugin.Context(runtime);
    new DelphiPlugin().define(context);
    return context.getExtensions();
  }

}
