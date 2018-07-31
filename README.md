Install IntelliJ IDEA

   Download IntelliJ IDEA for your operating system from https://www.jetbrains.com/idea/download/index.html.
   Do the following depending on your operating system:
   	Windows:
   		Run the ideaIC.exe or the ideaIU.exe file you have downloaded.
   		Follow the instructions in the installation wizard.

   	macOS:
   		Double-click the ideaIC.dmg or ideaIU.dmg file you have downloaded to mount the macOS disk image.
   		Copy IntelliJ IDEA to the Applications folder.

   	Linux:
   		Unpack the ideaIC.gz or ideaIU.gz file you have downloaded to a different folder if your current Downloads folder doesn't support file execution:
   			tar xfz ideaIC.tar.gz or ideaIU.tar.gz. <new_archive_folder>
   		The recommended install location according to the filesystem hierarchy standard (FHS) is /opt. For example, it's possible to enter the following command:

   			sudo tar xf -*.tar.gz -C /opt/
   		Switch to the bin directory, for example:
   			cd /opt/-*/bin
   		Run idea.sh from the bin subdirectory.

   Install JDK

   Download JDK and JRE from http://www.oracle.com/technetwork/java/javase/downloads/index.html

   	Windows:
   		In a browser, go to the Java SE Development Kit 10 Downloads page and click Accept License Agreement. Under the Download menu, click the Download link that corresponds to the .exe for your version of Windows.
   		Download the file jdk-10.interim.update.patch_windows-x64_bin.exe.

   			Note: Verify the successful completion of file download by comparing the file size on the download page and your local drive.

   		Run the JDK installer:
   			Start the JDK 10 installer by double-clicking the installer's icon or file name in the download location.
   			Follow the instructions provided by the Installation wizard.
   			The JDK includes the JavaFX SDK, a private JRE, and the Java Mission Control tools suite. The installer integrates the JavaFX SDK into the JDK installation directory.


   	macOS:
   		Download the JDK .dmg file, jdk-10.interim.update.patch-macosx-x64.dmg.
   		Before the file can be downloaded, you must accept the license agreement.
   		From either the browser Downloads window or from the file browser, double-click the .dmg file to start it.
   		A Finder window appears that contains an icon of an open box and the name of the .pkg file.
   		Double-click the JDK 10.pkg icon to start the installation application.
   		The installation application displays the Introduction window.
   		Click Continue.
   		The Installation Type window appears.
   		Click Install.
   		A window appears that displays the message: Installer is trying to install new software. Enter your password to allow this.
   		Enter the Administrator user name and password and click Install Software.

   	Linux:
   		Installing the 64-bit JDK on a Linux platform:
   			Download the file, jdk-10.interim.update.patch_linux-x64_bin.tar.gz.
   			Before you download a file, you must accept the license agreement. The archive binary can be installed by anyone (not only by root users) in any location that you can write to.
   			The .tar.gz archive file (also called a tarball) is a file that can be simultaneously uncompressed and extracted in one step.

   			Change the directory to the location where you want to install the JDK, then move the .tar.gz archive binary to the current directory.
   			Unpack the tarball and install the JDK:
   				$ tar zxvf jdk-10.interim.update.patch_linux-x64_bin.tar.gz

   			The Java Development Kit files are installed in a directory called jdk-10.interim.update.patch in the current directory.

   		Installing the 64-Bit JDK on RPM-Based Linux Platforms:
   			Log in as a root user to perform this installation.
   			Download the file, jdk-10.interim.update.patch_linux-x64_bin.rpm.
   			Before you download a file, you must accept the license agreement.

   			Ensure that you have root user access by running the command su and entering the superuser password.
   			Install the package using the following command:
   				$ rpm -ivh jdk-10.interim.update.patch_linux-x64_bin.rpm

   			Note:
   				JDK 10 can coexist with earlier versions of JDK. For each version, a new directory is created, the default directory being /usr/java/jdk.interim.update.patch.

   			Upgrade the package using the following command:
   				$ rpm -Uvh jdk-10.interim.update.patch_linux-x64_bin.rpm
