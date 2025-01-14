# .gitignore

```
# This gitignore has been specially created by the WPILib team.
# If you remove items from this file, intellisense might break.

### C++ ###
# Prerequisites
*.d

# Compiled Object files
*.slo
*.lo
*.o
*.obj

# Precompiled Headers
*.gch
*.pch

# Compiled Dynamic libraries
*.so
*.dylib
*.dll

# Fortran module files
*.mod
*.smod

# Compiled Static libraries
*.lai
*.la
*.a
*.lib

# Executables
*.exe
*.out
*.app

### Java ###
# Compiled class file
*.class

# Log file
*.log

# BlueJ files
*.ctxt

# Mobile Tools for Java (J2ME)
.mtj.tmp/

# Package Files #
*.jar
*.war
*.nar
*.ear
*.zip
*.tar.gz
*.rar

# virtual machine crash logs, see http://www.java.com/en/download/help/error_hotspot.xml
hs_err_pid*

### Linux ###
*~

# temporary files which can be created if a process still has a handle open of a deleted file
.fuse_hidden*

# KDE directory preferences
.directory

# Linux trash folder which might appear on any partition or disk
.Trash-*

# .nfs files are created when an open file is removed but is still being accessed
.nfs*

### macOS ###
# General
.DS_Store
.AppleDouble
.LSOverride

# Icon must end with two \r
Icon

# Thumbnails
._*

# Files that might appear in the root of a volume
.DocumentRevisions-V100
.fseventsd
.Spotlight-V100
.TemporaryItems
.Trashes
.VolumeIcon.icns
.com.apple.timemachine.donotpresent

# Directories potentially created on remote AFP share
.AppleDB
.AppleDesktop
Network Trash Folder
Temporary Items
.apdisk

### VisualStudioCode ###
.vscode/*
!.vscode/settings.json
!.vscode/tasks.json
!.vscode/launch.json
!.vscode/extensions.json

### Windows ###
# Windows thumbnail cache files
Thumbs.db
ehthumbs.db
ehthumbs_vista.db

# Dump file
*.stackdump

# Folder config file
[Dd]esktop.ini

# Recycle Bin used on file shares
$RECYCLE.BIN/

# Windows Installer files
*.cab
*.msi
*.msix
*.msm
*.msp

# Windows shortcuts
*.lnk

### Gradle ###
.gradle
/build/

# Ignore Gradle GUI config
gradle-app.setting

# Avoid ignoring Gradle wrapper jar file (.jar files are usually ignored)
!gradle-wrapper.jar

# Cache of project
.gradletasknamecache

# # Work around https://youtrack.jetbrains.com/issue/IDEA-116898
# gradle/wrapper/gradle-wrapper.properties

# # VS Code Specific Java Settings
# DO NOT REMOVE .classpath and .project
.classpath
.project
.settings/
bin/

# IntelliJ
*.iml
*.ipr
*.iws
.idea/
out/

# Fleet
.fleet

# Simulation GUI and other tools window save file
networktables.json
simgui.json
*-window.json

# Simulation data log directory
logs/

# Folder that has CTRE Phoenix Sim device config storage
ctre_sim/

# clangd
/.cache
compile_commands.json

# Eclipse generated file for annotation processors
.factorypath

```

# .vscode/launch.json

```json
{
  // Use IntelliSense to learn about possible attributes.
  // Hover to view descriptions of existing attributes.
  // For more information, visit: https://go.microsoft.com/fwlink/?linkid=830387
  "version": "0.2.0",
  "configurations": [

    {
      "type": "wpilib",
      "name": "WPILib Desktop Debug",
      "request": "launch",
      "desktop": true,
    },
    {
      "type": "wpilib",
      "name": "WPILib roboRIO Debug",
      "request": "launch",
      "desktop": false,
    }
  ]
}

```

# .vscode/settings.json

```json
{
  "java.configuration.updateBuildConfiguration": "automatic",
  "java.server.launchMode": "Standard",
  "files.exclude": {
    "**/.git": true,
    "**/.svn": true,
    "**/.hg": true,
    "**/CVS": true,
    "**/.DS_Store": true,
    "bin/": true,
    "**/.classpath": true,
    "**/.project": true,
    "**/.settings": true,
    "**/.factorypath": true,
    "**/*~": true
  },
  "java.test.config": [
    {
      "name": "WPIlibUnitTests",
      "workingDirectory": "${workspaceFolder}/build/jni/release",
      "vmargs": [ "-Djava.library.path=${workspaceFolder}/build/jni/release" ],
      "env": {
        "LD_LIBRARY_PATH": "${workspaceFolder}/build/jni/release" ,
        "DYLD_LIBRARY_PATH": "${workspaceFolder}/build/jni/release"
      }
    },
  ],
  "java.test.defaultConfig": "WPIlibUnitTests",
  "java.import.gradle.annotationProcessing.enabled": false,
  "java.completion.favoriteStaticMembers": [
    "org.junit.Assert.*",
    "org.junit.Assume.*",
    "org.junit.jupiter.api.Assertions.*",
    "org.junit.jupiter.api.Assumptions.*",
    "org.junit.jupiter.api.DynamicContainer.*",
    "org.junit.jupiter.api.DynamicTest.*",
    "org.mockito.Mockito.*",
    "org.mockito.ArgumentMatchers.*",
    "org.mockito.Answers.*",
    "edu.wpi.first.units.Units.*"
  ],
  "java.completion.filteredTypes": [
    "java.awt.*",
    "com.sun.*",
    "sun.*",
    "jdk.*",
    "org.graalvm.*",
    "io.micrometer.shaded.*",
    "java.beans.*",
    "java.util.Base64.*",
    "java.util.Timer",
    "java.sql.*",
    "javax.swing.*",
    "javax.management.*",
    "javax.smartcardio.*",
    "edu.wpi.first.math.proto.*",
    "edu.wpi.first.math.**.proto.*",
    "edu.wpi.first.math.**.struct.*",
  ]
}

```

# .wpilib/wpilib_preferences.json

```json
{
    "enableCppIntellisense": false,
    "currentLanguage": "java",
    "projectYear": "2025",
    "teamNumber": 2590
}
```

# build.gradle

```gradle
plugins {
    id "java"
    id "edu.wpi.first.GradleRIO" version "2025.1.1"
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

def ROBOT_MAIN_CLASS = "frc.robot.Main"

// Define my targets (RoboRIO) and artifacts (deployable files)
// This is added by GradleRIO's backing project DeployUtils.
deploy {
    targets {
        roborio(getTargetTypeClass('RoboRIO')) {
            // Team number is loaded either from the .wpilib/wpilib_preferences.json
            // or from command line. If not found an exception will be thrown.
            // You can use getTeamOrDefault(team) instead of getTeamNumber if you
            // want to store a team number in this file.
            team = project.frc.getTeamNumber()
            debug = project.frc.getDebugOrDefault(false)

            artifacts {
                // First part is artifact name, 2nd is artifact type
                // getTargetTypeClass is a shortcut to get the class type using a string

                frcJava(getArtifactTypeClass('FRCJavaArtifact')) {
                }

                // Static files artifact
                frcStaticFileDeploy(getArtifactTypeClass('FileTreeArtifact')) {
                    files = project.fileTree('src/main/deploy')
                    directory = '/home/lvuser/deploy'
                    deleteOldFiles = false // Change to true to delete files on roboRIO that no
                                           // longer exist in deploy directory of this project
                }
            }
        }
    }
}

def deployArtifact = deploy.targets.roborio.artifacts.frcJava

// Set to true to use debug for JNI.
wpi.java.debugJni = false

// Set this to true to enable desktop support.
def includeDesktopSupport = false

// Defining my dependencies. In this case, WPILib (+ friends), and vendor libraries.
// Also defines JUnit 5.
dependencies {
    annotationProcessor wpi.java.deps.wpilibAnnotations()
    implementation wpi.java.deps.wpilib()
    implementation wpi.java.vendor.java()

    roborioDebug wpi.java.deps.wpilibJniDebug(wpi.platforms.roborio)
    roborioDebug wpi.java.vendor.jniDebug(wpi.platforms.roborio)

    roborioRelease wpi.java.deps.wpilibJniRelease(wpi.platforms.roborio)
    roborioRelease wpi.java.vendor.jniRelease(wpi.platforms.roborio)

    nativeDebug wpi.java.deps.wpilibJniDebug(wpi.platforms.desktop)
    nativeDebug wpi.java.vendor.jniDebug(wpi.platforms.desktop)
    simulationDebug wpi.sim.enableDebug()

    nativeRelease wpi.java.deps.wpilibJniRelease(wpi.platforms.desktop)
    nativeRelease wpi.java.vendor.jniRelease(wpi.platforms.desktop)
    simulationRelease wpi.sim.enableRelease()

    testImplementation 'org.junit.jupiter:junit-jupiter:5.10.1'
    testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
}

test {
    useJUnitPlatform()
    systemProperty 'junit.jupiter.extensions.autodetection.enabled', 'true'
}

// Simulation configuration (e.g. environment variables).
wpi.sim.addGui().defaultEnabled = true
wpi.sim.addDriverstation()

// Setting up my Jar File. In this case, adding all libraries into the main jar ('fat jar')
// in order to make them all available at runtime. Also adding the manifest so WPILib
// knows where to look for our Robot Class.
jar {
    from { configurations.runtimeClasspath.collect { it.isDirectory() ? it : zipTree(it) } }
    from sourceSets.main.allSource
    manifest edu.wpi.first.gradlerio.GradleRIOPlugin.javaManifest(ROBOT_MAIN_CLASS)
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}

// Configure jar and deploy tasks
deployArtifact.jarTask = jar
wpi.java.configureExecutableTasks(jar)
wpi.java.configureTestTasks(test)

// Configure string concat to always inline compile
tasks.withType(JavaCompile) {
    options.compilerArgs.add '-XDstringConcat=inline'
}

```

# gradle/wrapper/gradle-wrapper.jar

This is a binary file of the type: Binary

# gradle/wrapper/gradle-wrapper.properties

```properties
distributionBase=GRADLE_USER_HOME
distributionPath=permwrapper/dists
distributionUrl=https\://services.gradle.org/distributions/gradle-8.11-bin.zip
networkTimeout=10000
validateDistributionUrl=true
zipStoreBase=GRADLE_USER_HOME
zipStorePath=permwrapper/dists

```

# gradlew

```
#!/bin/sh

#
# Copyright © 2015-2021 the original authors.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
# SPDX-License-Identifier: Apache-2.0
#

##############################################################################
#
#   Gradle start up script for POSIX generated by Gradle.
#
#   Important for running:
#
#   (1) You need a POSIX-compliant shell to run this script. If your /bin/sh is
#       noncompliant, but you have some other compliant shell such as ksh or
#       bash, then to run this script, type that shell name before the whole
#       command line, like:
#
#           ksh Gradle
#
#       Busybox and similar reduced shells will NOT work, because this script
#       requires all of these POSIX shell features:
#         * functions;
#         * expansions «$var», «${var}», «${var:-default}», «${var+SET}»,
#           «${var#prefix}», «${var%suffix}», and «$( cmd )»;
#         * compound commands having a testable exit status, especially «case»;
#         * various built-in commands including «command», «set», and «ulimit».
#
#   Important for patching:
#
#   (2) This script targets any POSIX shell, so it avoids extensions provided
#       by Bash, Ksh, etc; in particular arrays are avoided.
#
#       The "traditional" practice of packing multiple parameters into a
#       space-separated string is a well documented source of bugs and security
#       problems, so this is (mostly) avoided, by progressively accumulating
#       options in "$@", and eventually passing that to Java.
#
#       Where the inherited environment variables (DEFAULT_JVM_OPTS, JAVA_OPTS,
#       and GRADLE_OPTS) rely on word-splitting, this is performed explicitly;
#       see the in-line comments for details.
#
#       There are tweaks for specific operating systems such as AIX, CygWin,
#       Darwin, MinGW, and NonStop.
#
#   (3) This script is generated from the Groovy template
#       https://github.com/gradle/gradle/blob/HEAD/platforms/jvm/plugins-application/src/main/resources/org/gradle/api/internal/plugins/unixStartScript.txt
#       within the Gradle project.
#
#       You can find Gradle at https://github.com/gradle/gradle/.
#
##############################################################################

# Attempt to set APP_HOME

# Resolve links: $0 may be a link
app_path=$0

# Need this for daisy-chained symlinks.
while
    APP_HOME=${app_path%"${app_path##*/}"}  # leaves a trailing /; empty if no leading path
    [ -h "$app_path" ]
do
    ls=$( ls -ld "$app_path" )
    link=${ls#*' -> '}
    case $link in             #(
      /*)   app_path=$link ;; #(
      *)    app_path=$APP_HOME$link ;;
    esac
done

# This is normally unused
# shellcheck disable=SC2034
APP_BASE_NAME=${0##*/}
# Discard cd standard output in case $CDPATH is set (https://github.com/gradle/gradle/issues/25036)
APP_HOME=$( cd -P "${APP_HOME:-./}" > /dev/null && printf '%s
' "$PWD" ) || exit

# Use the maximum available, or set MAX_FD != -1 to use that value.
MAX_FD=maximum

warn () {
    echo "$*"
} >&2

die () {
    echo
    echo "$*"
    echo
    exit 1
} >&2

# OS specific support (must be 'true' or 'false').
cygwin=false
msys=false
darwin=false
nonstop=false
case "$( uname )" in                #(
  CYGWIN* )         cygwin=true  ;; #(
  Darwin* )         darwin=true  ;; #(
  MSYS* | MINGW* )  msys=true    ;; #(
  NONSTOP* )        nonstop=true ;;
esac

CLASSPATH=$APP_HOME/gradle/wrapper/gradle-wrapper.jar


# Determine the Java command to use to start the JVM.
if [ -n "$JAVA_HOME" ] ; then
    if [ -x "$JAVA_HOME/jre/sh/java" ] ; then
        # IBM's JDK on AIX uses strange locations for the executables
        JAVACMD=$JAVA_HOME/jre/sh/java
    else
        JAVACMD=$JAVA_HOME/bin/java
    fi
    if [ ! -x "$JAVACMD" ] ; then
        die "ERROR: JAVA_HOME is set to an invalid directory: $JAVA_HOME

Please set the JAVA_HOME variable in your environment to match the
location of your Java installation."
    fi
else
    JAVACMD=java
    if ! command -v java >/dev/null 2>&1
    then
        die "ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.

Please set the JAVA_HOME variable in your environment to match the
location of your Java installation."
    fi
fi

# Increase the maximum file descriptors if we can.
if ! "$cygwin" && ! "$darwin" && ! "$nonstop" ; then
    case $MAX_FD in #(
      max*)
        # In POSIX sh, ulimit -H is undefined. That's why the result is checked to see if it worked.
        # shellcheck disable=SC2039,SC3045
        MAX_FD=$( ulimit -H -n ) ||
            warn "Could not query maximum file descriptor limit"
    esac
    case $MAX_FD in  #(
      '' | soft) :;; #(
      *)
        # In POSIX sh, ulimit -n is undefined. That's why the result is checked to see if it worked.
        # shellcheck disable=SC2039,SC3045
        ulimit -n "$MAX_FD" ||
            warn "Could not set maximum file descriptor limit to $MAX_FD"
    esac
fi

# Collect all arguments for the java command, stacking in reverse order:
#   * args from the command line
#   * the main class name
#   * -classpath
#   * -D...appname settings
#   * --module-path (only if needed)
#   * DEFAULT_JVM_OPTS, JAVA_OPTS, and GRADLE_OPTS environment variables.

# For Cygwin or MSYS, switch paths to Windows format before running java
if "$cygwin" || "$msys" ; then
    APP_HOME=$( cygpath --path --mixed "$APP_HOME" )
    CLASSPATH=$( cygpath --path --mixed "$CLASSPATH" )

    JAVACMD=$( cygpath --unix "$JAVACMD" )

    # Now convert the arguments - kludge to limit ourselves to /bin/sh
    for arg do
        if
            case $arg in                                #(
              -*)   false ;;                            # don't mess with options #(
              /?*)  t=${arg#/} t=/${t%%/*}              # looks like a POSIX filepath
                    [ -e "$t" ] ;;                      #(
              *)    false ;;
            esac
        then
            arg=$( cygpath --path --ignore --mixed "$arg" )
        fi
        # Roll the args list around exactly as many times as the number of
        # args, so each arg winds up back in the position where it started, but
        # possibly modified.
        #
        # NB: a `for` loop captures its iteration list before it begins, so
        # changing the positional parameters here affects neither the number of
        # iterations, nor the values presented in `arg`.
        shift                   # remove old arg
        set -- "$@" "$arg"      # push replacement arg
    done
fi


# Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass JVM options to this script.
DEFAULT_JVM_OPTS='"-Xmx64m" "-Xms64m"'

# Collect all arguments for the java command:
#   * DEFAULT_JVM_OPTS, JAVA_OPTS, JAVA_OPTS, and optsEnvironmentVar are not allowed to contain shell fragments,
#     and any embedded shellness will be escaped.
#   * For example: A user cannot expect ${Hostname} to be expanded, as it is an environment variable and will be
#     treated as '${Hostname}' itself on the command line.

set -- \
        "-Dorg.gradle.appname=$APP_BASE_NAME" \
        -classpath "$CLASSPATH" \
        org.gradle.wrapper.GradleWrapperMain \
        "$@"

# Stop when "xargs" is not available.
if ! command -v xargs >/dev/null 2>&1
then
    die "xargs is not available"
fi

# Use "xargs" to parse quoted args.
#
# With -n1 it outputs one arg per line, with the quotes and backslashes removed.
#
# In Bash we could simply go:
#
#   readarray ARGS < <( xargs -n1 <<<"$var" ) &&
#   set -- "${ARGS[@]}" "$@"
#
# but POSIX shell has neither arrays nor command substitution, so instead we
# post-process each arg (as a line of input to sed) to backslash-escape any
# character that might be a shell metacharacter, then use eval to reverse
# that process (while maintaining the separation between arguments), and wrap
# the whole thing up as a single "set" statement.
#
# This will of course break if any of these variables contains a newline or
# an unmatched quote.
#

eval "set -- $(
        printf '%s\n' "$DEFAULT_JVM_OPTS $JAVA_OPTS $GRADLE_OPTS" |
        xargs -n1 |
        sed ' s~[^-[:alnum:]+,./:=@_]~\\&~g; ' |
        tr '\n' ' '
    )" '"$@"'

exec "$JAVACMD" "$@"

```

# gradlew.bat

```bat
@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem
@rem SPDX-License-Identifier: Apache-2.0
@rem

@if "%DEBUG%"=="" @echo off
@rem ##########################################################################
@rem
@rem  Gradle startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%"=="" set DIRNAME=.
@rem This is normally unused
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS="-Xmx64m" "-Xms64m"

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if %ERRORLEVEL% equ 0 goto execute

echo. 1>&2
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH. 1>&2
echo. 1>&2
echo Please set the JAVA_HOME variable in your environment to match the 1>&2
echo location of your Java installation. 1>&2

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo. 1>&2
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME% 1>&2
echo. 1>&2
echo Please set the JAVA_HOME variable in your environment to match the 1>&2
echo location of your Java installation. 1>&2

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\gradle\wrapper\gradle-wrapper.jar


@rem Execute Gradle
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %GRADLE_OPTS% "-Dorg.gradle.appname=%APP_BASE_NAME%" -classpath "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %*

:end
@rem End local scope for the variables with windows NT shell
if %ERRORLEVEL% equ 0 goto mainEnd

:fail
rem Set variable GRADLE_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
set EXIT_CODE=%ERRORLEVEL%
if %EXIT_CODE% equ 0 set EXIT_CODE=1
if not ""=="%GRADLE_EXIT_CONSOLE%" exit %EXIT_CODE%
exit /b %EXIT_CODE%

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega

```

# settings.gradle

```gradle
import org.gradle.internal.os.OperatingSystem

pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        String frcYear = '2025'
        File frcHome
        if (OperatingSystem.current().isWindows()) {
            String publicFolder = System.getenv('PUBLIC')
            if (publicFolder == null) {
                publicFolder = "C:\\Users\\Public"
            }
            def homeRoot = new File(publicFolder, "wpilib")
            frcHome = new File(homeRoot, frcYear)
        } else {
            def userFolder = System.getProperty("user.home")
            def homeRoot = new File(userFolder, "wpilib")
            frcHome = new File(homeRoot, frcYear)
        }
        def frcHomeMaven = new File(frcHome, 'maven')
        maven {
            name 'frcHome'
            url frcHomeMaven
        }
    }
}

Properties props = System.getProperties();
props.setProperty("org.gradle.internal.native.headers.unresolved.dependencies.ignore", "true");

```

# src/main/deploy/example.txt

```txt
Files placed in this directory will be deployed to the RoboRIO into the
'deploy' directory in the home folder. Use the 'Filesystem.getDeployDirectory' wpilib function
to get a proper path relative to the deploy directory.
```

# src/main/java/frc/robot/commands/ExampleCommand.java

```java

```

# src/main/java/frc/robot/Constants.java

```java
package frc.robot;

public final class Constants {
    public static final class PneumaticsConstants {
        public static final int PCM_CAN_ID = 3; 
        public static final int FORWARD_CHANNEL = 1; // solenoid forward
        public static final int REVERSE_CHANNEL = 1; // Change to match your solenoid reverse channel
        public static final int CONTROLLER_PORT = 2; // usb port
        public static final int PISTON_BUTTON = 1; // xbox
    }
}


```

# src/main/java/frc/robot/Main.java

```java
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.RobotBase;

/**
 * Do NOT add any static variables to this class, or any initialization at all. Unless you know what
 * you are doing, do not modify this file except to change the parameter class to the startRobot
 * call.
 */
public final class Main {
  private Main() {}

  /**
   * Main initialization function. Do not perform any initialization here.
   *
   * <p>If you change your main robot class, change the parameter type.
   */
  public static void main(String... args) {
    RobotBase.startRobot(Robot::new);
  }
}
```

# src/main/java/frc/robot/Robot.java

```java
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
    private RobotContainer m_robotContainer;

    @Override
    public void robotInit() {
        m_robotContainer = new RobotContainer();
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }
}

```

# src/main/java/frc/robot/RobotContainer.java

```java
package frc.robot;

import frc.robot.subsystems.MotorTesting;

public class RobotContainer {
    private final MotorTesting m_motorTesting = new MotorTesting();
    
    public RobotContainer() {
        configureBindings();
    }
    
    private void configureBindings() {
        // Add any additional button bindings here if needed
    }
}
```

# src/main/java/frc/robot/subsystems/MotorTesting.java

```java
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class MotorTesting extends SubsystemBase {
    // Create motor and joystick
    private final TalonFX motor;
    private final Joystick joystick;
    
    public MotorTesting() {
        // Change the ID (1) to match your motor's CAN ID
        motor = new TalonFX(1); 
        joystick = new Joystick(0);  // Joystick plugged into USB port 0
        
        // Basic motor setup
        motor.configFactoryDefault();
        motor.setNeutralMode(NeutralMode.Brake);
    }
    
    @Override
    public void periodic() {
        // Get joystick Y axis (-1 to 1), negative because pushing up should make motor go forward
        double speed = -joystick.getY();
        
        // Add deadband to prevent motor creep
        if (Math.abs(speed) < 0.1) {
            speed = 0;
        }
        
        // Set motor speed
        motor.set(ControlMode.PercentOutput, speed);
        
        // Button controls
        if (joystick.getRawButtonPressed(1)) {  // Button 1 (trigger)
            // Toggle motor direction
            motor.setInverted(!motor.getInverted());
        }
        
        if (joystick.getRawButtonPressed(2)) {  // Button 2
            // Toggle brake mode
            boolean isBrakeMode = motor.getNeutralMode() == NeutralMode.Brake;
            motor.setNeutralMode(isBrakeMode ? NeutralMode.Coast : NeutralMode.Brake);
        }
    }
    
    public void stop() {
        motor.set(ControlMode.PercentOutput, 0);
    }
}
```

# src/main/java/frc/robot/subsystems/NemesisMotor.java

```java
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;

public class NemesisMotor {
    private TalonFX motor;
    private double currentLimit = 40.0;
    
    public NemesisMotor(int canID) {
        motor = new TalonFX(canID);
        
        // Default configuration
        motor.configFactoryDefault();
        motor.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(true, currentLimit, currentLimit, 0));
        motor.setNeutralMode(NeutralMode.Brake);
    }

    /**
     * Sets the motor's speed
     * @param speed Value between -1.0 and 1.0
     */
    public void set(double speed) {
        motor.set(ControlMode.PercentOutput, speed);
    }

    /**
     * Inverts the motor direction
     * @param inverted True to invert, false for normal
     */
    public void setInverted(boolean inverted) {
        motor.setInverted(inverted);
    }

    /**
     * Sets another motor to follow this one
     * @param followerMotor The NemesisMotor that should follow this one
     * @param inverted Whether the follower should be inverted relative to the leader
     */
    public void setFollower(NemesisMotor followerMotor, boolean inverted) {
        followerMotor.motor.follow(motor);
        followerMotor.motor.setInverted(inverted);
    }

    /**
     * Sets the current limit for the motor
     * @param amps Current limit in amps
     */
    public void setCurrentLimit(double amps) {
        currentLimit = amps;
        motor.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(true, currentLimit, currentLimit, 0));
    }

    /**
     * Sets whether the motor is in brake mode
     * @param brake True for brake mode, false for coast
     */
    public void setBrakeMode(boolean brake) {
        motor.setNeutralMode(brake ? NeutralMode.Brake : NeutralMode.Coast);
    }

    /**
     * Stops the motor
     */
    public void stop() {
        motor.set(ControlMode.PercentOutput, 0);
    }

    /**
     * Gets the raw TalonFX motor controller
     * @return The TalonFX object
     */
    public TalonFX getRawMotor() {
        return motor;
    }
}
```

# src/main/java/frc/robot/subsystems/Pneumatics.java

```java
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;
import frc.robot.Constants.PneumaticsConstants;

public class Pneumatics extends SubsystemBase {
    private final Compressor compressor = new Compressor(PneumaticsConstants.PCM_CAN_ID, PneumaticsModuleType.CTREPCM);
    private final PneumaticsControlModule pcm = new PneumaticsControlModule(PneumaticsConstants.PCM_CAN_ID);
    private final Solenoid piston = new Solenoid(PneumaticsModuleType.CTREPCM, 1);
    
    public Pneumatics() {
        compressor.enableDigital();
    }
    
    public void togglePiston() {
        piston.set(true);
    }
}
```

# vendordeps/Phoenix5-5.35.1.json

```json
{
    "fileName": "Phoenix5-5.35.1.json",
    "name": "CTRE-Phoenix (v5)",
    "version": "5.35.1",
    "frcYear": "2025",
    "uuid": "ab676553-b602-441f-a38d-f1296eff6537",
    "mavenUrls": [
        "https://maven.ctr-electronics.com/release/"
    ],
    "jsonUrl": "https://maven.ctr-electronics.com/release/com/ctre/phoenix/Phoenix5-frc2025-latest.json",
    "requires": [
        {
            "uuid": "e995de00-2c64-4df5-8831-c1441420ff19",
            "errorMessage": "Phoenix 5 requires low-level libraries from Phoenix 6.  Please add the Phoenix 6 vendordep before adding Phoenix 5.",
            "offlineFileName": "Phoenix6-frc2025-latest.json",
            "onlineUrl": "https://maven.ctr-electronics.com/release/com/ctre/phoenix6/latest/Phoenix6-frc2025-latest.json"
        }
    ],
    "conflictsWith": [
        {
            "uuid": "e7900d8d-826f-4dca-a1ff-182f658e98af",
            "errorMessage": "Users must use the Phoenix 5 replay vendordep when using the Phoenix 6 replay vendordep.",
            "offlineFileName": "Phoenix6-replay-frc2025-latest.json"
        },
        {
            "uuid": "fbc886a4-2cec-40c0-9835-71086a8cc3df",
            "errorMessage": "Users cannot have both the replay and regular Phoenix 5 vendordeps in their robot program.",
            "offlineFileName": "Phoenix5-replay-frc2025-latest.json"
        }
    ],
    "javaDependencies": [
        {
            "groupId": "com.ctre.phoenix",
            "artifactId": "api-java",
            "version": "5.35.1"
        },
        {
            "groupId": "com.ctre.phoenix",
            "artifactId": "wpiapi-java",
            "version": "5.35.1"
        }
    ],
    "jniDependencies": [
        {
            "groupId": "com.ctre.phoenix",
            "artifactId": "cci",
            "version": "5.35.1",
            "isJar": false,
            "skipInvalidPlatforms": true,
            "validPlatforms": [
                "windowsx86-64",
                "linuxx86-64",
                "linuxarm64",
                "linuxathena"
            ],
            "simMode": "hwsim"
        },
        {
            "groupId": "com.ctre.phoenix.sim",
            "artifactId": "cci-sim",
            "version": "5.35.1",
            "isJar": false,
            "skipInvalidPlatforms": true,
            "validPlatforms": [
                "windowsx86-64",
                "linuxx86-64",
                "linuxarm64",
                "osxuniversal"
            ],
            "simMode": "swsim"
        }
    ],
    "cppDependencies": [
        {
            "groupId": "com.ctre.phoenix",
            "artifactId": "wpiapi-cpp",
            "version": "5.35.1",
            "libName": "CTRE_Phoenix_WPI",
            "headerClassifier": "headers",
            "sharedLibrary": true,
            "skipInvalidPlatforms": true,
            "binaryPlatforms": [
                "windowsx86-64",
                "linuxx86-64",
                "linuxarm64",
                "linuxathena"
            ],
            "simMode": "hwsim"
        },
        {
            "groupId": "com.ctre.phoenix",
            "artifactId": "api-cpp",
            "version": "5.35.1",
            "libName": "CTRE_Phoenix",
            "headerClassifier": "headers",
            "sharedLibrary": true,
            "skipInvalidPlatforms": true,
            "binaryPlatforms": [
                "windowsx86-64",
                "linuxx86-64",
                "linuxarm64",
                "linuxathena"
            ],
            "simMode": "hwsim"
        },
        {
            "groupId": "com.ctre.phoenix",
            "artifactId": "cci",
            "version": "5.35.1",
            "libName": "CTRE_PhoenixCCI",
            "headerClassifier": "headers",
            "sharedLibrary": true,
            "skipInvalidPlatforms": true,
            "binaryPlatforms": [
                "windowsx86-64",
                "linuxx86-64",
                "linuxarm64",
                "linuxathena"
            ],
            "simMode": "hwsim"
        },
        {
            "groupId": "com.ctre.phoenix.sim",
            "artifactId": "wpiapi-cpp-sim",
            "version": "5.35.1",
            "libName": "CTRE_Phoenix_WPISim",
            "headerClassifier": "headers",
            "sharedLibrary": true,
            "skipInvalidPlatforms": true,
            "binaryPlatforms": [
                "windowsx86-64",
                "linuxx86-64",
                "linuxarm64",
                "osxuniversal"
            ],
            "simMode": "swsim"
        },
        {
            "groupId": "com.ctre.phoenix.sim",
            "artifactId": "api-cpp-sim",
            "version": "5.35.1",
            "libName": "CTRE_PhoenixSim",
            "headerClassifier": "headers",
            "sharedLibrary": true,
            "skipInvalidPlatforms": true,
            "binaryPlatforms": [
                "windowsx86-64",
                "linuxx86-64",
                "linuxarm64",
                "osxuniversal"
            ],
            "simMode": "swsim"
        },
        {
            "groupId": "com.ctre.phoenix.sim",
            "artifactId": "cci-sim",
            "version": "5.35.1",
            "libName": "CTRE_PhoenixCCISim",
            "headerClassifier": "headers",
            "sharedLibrary": true,
            "skipInvalidPlatforms": true,
            "binaryPlatforms": [
                "windowsx86-64",
                "linuxx86-64",
                "linuxarm64",
                "osxuniversal"
            ],
            "simMode": "swsim"
        }
    ]
}
```

# vendordeps/Phoenix6-25.1.0.json

```json
{
    "fileName": "Phoenix6-25.1.0.json",
    "name": "CTRE-Phoenix (v6)",
    "version": "25.1.0",
    "frcYear": "2025",
    "uuid": "e995de00-2c64-4df5-8831-c1441420ff19",
    "mavenUrls": [
        "https://maven.ctr-electronics.com/release/"
    ],
    "jsonUrl": "https://maven.ctr-electronics.com/release/com/ctre/phoenix6/latest/Phoenix6-frc2025-latest.json",
    "conflictsWith": [
        {
            "uuid": "e7900d8d-826f-4dca-a1ff-182f658e98af",
            "errorMessage": "Users can not have both the replay and regular Phoenix 6 vendordeps in their robot program.",
            "offlineFileName": "Phoenix6-replay-frc2025-latest.json"
        }
    ],
    "javaDependencies": [
        {
            "groupId": "com.ctre.phoenix6",
            "artifactId": "wpiapi-java",
            "version": "25.1.0"
        }
    ],
    "jniDependencies": [
        {
            "groupId": "com.ctre.phoenix6",
            "artifactId": "api-cpp",
            "version": "25.1.0",
            "isJar": false,
            "skipInvalidPlatforms": true,
            "validPlatforms": [
                "windowsx86-64",
                "linuxx86-64",
                "linuxarm64",
                "linuxathena"
            ],
            "simMode": "hwsim"
        },
        {
            "groupId": "com.ctre.phoenix6",
            "artifactId": "tools",
            "version": "25.1.0",
            "isJar": false,
            "skipInvalidPlatforms": true,
            "validPlatforms": [
                "windowsx86-64",
                "linuxx86-64",
                "linuxarm64",
                "linuxathena"
            ],
            "simMode": "hwsim"
        },
        {
            "groupId": "com.ctre.phoenix6.sim",
            "artifactId": "api-cpp-sim",
            "version": "25.1.0",
            "isJar": false,
            "skipInvalidPlatforms": true,
            "validPlatforms": [
                "windowsx86-64",
                "linuxx86-64",
                "linuxarm64",
                "osxuniversal"
            ],
            "simMode": "swsim"
        },
        {
            "groupId": "com.ctre.phoenix6.sim",
            "artifactId": "tools-sim",
            "version": "25.1.0",
            "isJar": false,
            "skipInvalidPlatforms": true,
            "validPlatforms": [
                "windowsx86-64",
                "linuxx86-64",
                "linuxarm64",
                "osxuniversal"
            ],
            "simMode": "swsim"
        },
        {
            "groupId": "com.ctre.phoenix6.sim",
            "artifactId": "simTalonSRX",
            "version": "25.1.0",
            "isJar": false,
            "skipInvalidPlatforms": true,
            "validPlatforms": [
                "windowsx86-64",
                "linuxx86-64",
                "linuxarm64",
                "osxuniversal"
            ],
            "simMode": "swsim"
        },
        {
            "groupId": "com.ctre.phoenix6.sim",
            "artifactId": "simVictorSPX",
            "version": "25.1.0",
            "isJar": false,
            "skipInvalidPlatforms": true,
            "validPlatforms": [
                "windowsx86-64",
                "linuxx86-64",
                "linuxarm64",
                "osxuniversal"
            ],
            "simMode": "swsim"
        },
        {
            "groupId": "com.ctre.phoenix6.sim",
            "artifactId": "simPigeonIMU",
            "version": "25.1.0",
            "isJar": false,
            "skipInvalidPlatforms": true,
            "validPlatforms": [
                "windowsx86-64",
                "linuxx86-64",
                "linuxarm64",
                "osxuniversal"
            ],
            "simMode": "swsim"
        },
        {
            "groupId": "com.ctre.phoenix6.sim",
            "artifactId": "simCANCoder",
            "version": "25.1.0",
            "isJar": false,
            "skipInvalidPlatforms": true,
            "validPlatforms": [
                "windowsx86-64",
                "linuxx86-64",
                "linuxarm64",
                "osxuniversal"
            ],
            "simMode": "swsim"
        },
        {
            "groupId": "com.ctre.phoenix6.sim",
            "artifactId": "simProTalonFX",
            "version": "25.1.0",
            "isJar": false,
            "skipInvalidPlatforms": true,
            "validPlatforms": [
                "windowsx86-64",
                "linuxx86-64",
                "linuxarm64",
                "osxuniversal"
            ],
            "simMode": "swsim"
        },
        {
            "groupId": "com.ctre.phoenix6.sim",
            "artifactId": "simProCANcoder",
            "version": "25.1.0",
            "isJar": false,
            "skipInvalidPlatforms": true,
            "validPlatforms": [
                "windowsx86-64",
                "linuxx86-64",
                "linuxarm64",
                "osxuniversal"
            ],
            "simMode": "swsim"
        },
        {
            "groupId": "com.ctre.phoenix6.sim",
            "artifactId": "simProPigeon2",
            "version": "25.1.0",
            "isJar": false,
            "skipInvalidPlatforms": true,
            "validPlatforms": [
                "windowsx86-64",
                "linuxx86-64",
                "linuxarm64",
                "osxuniversal"
            ],
            "simMode": "swsim"
        },
        {
            "groupId": "com.ctre.phoenix6.sim",
            "artifactId": "simProCANrange",
            "version": "25.1.0",
            "isJar": false,
            "skipInvalidPlatforms": true,
            "validPlatforms": [
                "windowsx86-64",
                "linuxx86-64",
                "linuxarm64",
                "osxuniversal"
            ],
            "simMode": "swsim"
        }
    ],
    "cppDependencies": [
        {
            "groupId": "com.ctre.phoenix6",
            "artifactId": "wpiapi-cpp",
            "version": "25.1.0",
            "libName": "CTRE_Phoenix6_WPI",
            "headerClassifier": "headers",
            "sharedLibrary": true,
            "skipInvalidPlatforms": true,
            "binaryPlatforms": [
                "windowsx86-64",
                "linuxx86-64",
                "linuxarm64",
                "linuxathena"
            ],
            "simMode": "hwsim"
        },
        {
            "groupId": "com.ctre.phoenix6",
            "artifactId": "tools",
            "version": "25.1.0",
            "libName": "CTRE_PhoenixTools",
            "headerClassifier": "headers",
            "sharedLibrary": true,
            "skipInvalidPlatforms": true,
            "binaryPlatforms": [
                "windowsx86-64",
                "linuxx86-64",
                "linuxarm64",
                "linuxathena"
            ],
            "simMode": "hwsim"
        },
        {
            "groupId": "com.ctre.phoenix6.sim",
            "artifactId": "wpiapi-cpp-sim",
            "version": "25.1.0",
            "libName": "CTRE_Phoenix6_WPISim",
            "headerClassifier": "headers",
            "sharedLibrary": true,
            "skipInvalidPlatforms": true,
            "binaryPlatforms": [
                "windowsx86-64",
                "linuxx86-64",
                "linuxarm64",
                "osxuniversal"
            ],
            "simMode": "swsim"
        },
        {
            "groupId": "com.ctre.phoenix6.sim",
            "artifactId": "tools-sim",
            "version": "25.1.0",
            "libName": "CTRE_PhoenixTools_Sim",
            "headerClassifier": "headers",
            "sharedLibrary": true,
            "skipInvalidPlatforms": true,
            "binaryPlatforms": [
                "windowsx86-64",
                "linuxx86-64",
                "linuxarm64",
                "osxuniversal"
            ],
            "simMode": "swsim"
        },
        {
            "groupId": "com.ctre.phoenix6.sim",
            "artifactId": "simTalonSRX",
            "version": "25.1.0",
            "libName": "CTRE_SimTalonSRX",
            "headerClassifier": "headers",
            "sharedLibrary": true,
            "skipInvalidPlatforms": true,
            "binaryPlatforms": [
                "windowsx86-64",
                "linuxx86-64",
                "linuxarm64",
                "osxuniversal"
            ],
            "simMode": "swsim"
        },
        {
            "groupId": "com.ctre.phoenix6.sim",
            "artifactId": "simVictorSPX",
            "version": "25.1.0",
            "libName": "CTRE_SimVictorSPX",
            "headerClassifier": "headers",
            "sharedLibrary": true,
            "skipInvalidPlatforms": true,
            "binaryPlatforms": [
                "windowsx86-64",
                "linuxx86-64",
                "linuxarm64",
                "osxuniversal"
            ],
            "simMode": "swsim"
        },
        {
            "groupId": "com.ctre.phoenix6.sim",
            "artifactId": "simPigeonIMU",
            "version": "25.1.0",
            "libName": "CTRE_SimPigeonIMU",
            "headerClassifier": "headers",
            "sharedLibrary": true,
            "skipInvalidPlatforms": true,
            "binaryPlatforms": [
                "windowsx86-64",
                "linuxx86-64",
                "linuxarm64",
                "osxuniversal"
            ],
            "simMode": "swsim"
        },
        {
            "groupId": "com.ctre.phoenix6.sim",
            "artifactId": "simCANCoder",
            "version": "25.1.0",
            "libName": "CTRE_SimCANCoder",
            "headerClassifier": "headers",
            "sharedLibrary": true,
            "skipInvalidPlatforms": true,
            "binaryPlatforms": [
                "windowsx86-64",
                "linuxx86-64",
                "linuxarm64",
                "osxuniversal"
            ],
            "simMode": "swsim"
        },
        {
            "groupId": "com.ctre.phoenix6.sim",
            "artifactId": "simProTalonFX",
            "version": "25.1.0",
            "libName": "CTRE_SimProTalonFX",
            "headerClassifier": "headers",
            "sharedLibrary": true,
            "skipInvalidPlatforms": true,
            "binaryPlatforms": [
                "windowsx86-64",
                "linuxx86-64",
                "linuxarm64",
                "osxuniversal"
            ],
            "simMode": "swsim"
        },
        {
            "groupId": "com.ctre.phoenix6.sim",
            "artifactId": "simProCANcoder",
            "version": "25.1.0",
            "libName": "CTRE_SimProCANcoder",
            "headerClassifier": "headers",
            "sharedLibrary": true,
            "skipInvalidPlatforms": true,
            "binaryPlatforms": [
                "windowsx86-64",
                "linuxx86-64",
                "linuxarm64",
                "osxuniversal"
            ],
            "simMode": "swsim"
        },
        {
            "groupId": "com.ctre.phoenix6.sim",
            "artifactId": "simProPigeon2",
            "version": "25.1.0",
            "libName": "CTRE_SimProPigeon2",
            "headerClassifier": "headers",
            "sharedLibrary": true,
            "skipInvalidPlatforms": true,
            "binaryPlatforms": [
                "windowsx86-64",
                "linuxx86-64",
                "linuxarm64",
                "osxuniversal"
            ],
            "simMode": "swsim"
        },
        {
            "groupId": "com.ctre.phoenix6.sim",
            "artifactId": "simProCANrange",
            "version": "25.1.0",
            "libName": "CTRE_SimProCANrange",
            "headerClassifier": "headers",
            "sharedLibrary": true,
            "skipInvalidPlatforms": true,
            "binaryPlatforms": [
                "windowsx86-64",
                "linuxx86-64",
                "linuxarm64",
                "osxuniversal"
            ],
            "simMode": "swsim"
        }
    ]
}
```

# vendordeps/WPILibNewCommands.json

```json
{
  "fileName": "WPILibNewCommands.json",
  "name": "WPILib-New-Commands",
  "version": "1.0.0",
  "uuid": "111e20f7-815e-48f8-9dd6-e675ce75b266",
  "frcYear": "2025",
  "mavenUrls": [],
  "jsonUrl": "",
  "javaDependencies": [
    {
      "groupId": "edu.wpi.first.wpilibNewCommands",
      "artifactId": "wpilibNewCommands-java",
      "version": "wpilib"
    }
  ],
  "jniDependencies": [],
  "cppDependencies": [
    {
      "groupId": "edu.wpi.first.wpilibNewCommands",
      "artifactId": "wpilibNewCommands-cpp",
      "version": "wpilib",
      "libName": "wpilibNewCommands",
      "headerClassifier": "headers",
      "sourcesClassifier": "sources",
      "sharedLibrary": true,
      "skipInvalidPlatforms": true,
      "binaryPlatforms": [
        "linuxathena",
        "linuxarm32",
        "linuxarm64",
        "windowsx86-64",
        "windowsx86",
        "linuxx86-64",
        "osxuniversal"
      ]
    }
  ]
}

```

# WPILib-License.md

```md
Copyright (c) 2009-2024 FIRST and other WPILib contributors
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:
   * Redistributions of source code must retain the above copyright
     notice, this list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright
     notice, this list of conditions and the following disclaimer in the
     documentation and/or other materials provided with the distribution.
   * Neither the name of FIRST, WPILib, nor the names of other WPILib
     contributors may be used to endorse or promote products derived from
     this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY FIRST AND OTHER WPILIB CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY NONINFRINGEMENT AND FITNESS FOR A PARTICULAR
PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL FIRST OR CONTRIBUTORS BE LIABLE FOR
ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

```

