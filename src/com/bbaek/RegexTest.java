package com.bbaek;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

	static String html = "\r\n" + 
			"                </div>\r\n" + 
			"            </div>\r\n" + 
			"            <div id=\"main-panel\">\r\n" + 
			"                <a name=\"skip2content\"></a>\r\n" + 
			"                <h1 class=\"build-caption page-headline\">\r\n" + 
			"                    <img src=\"/static/f5f05e5c/images/48x48/blue.png\" alt=\"Success\" tooltip=\"Success\" style=\"width: 48px; height: 48px; \" class=\"icon-blue icon-xlg\" />콘솔 출력\r\n" + 
			"                </h1>\r\n" + 
			"                <script src='/extensionList/hudson.console.ConsoleAnnotatorFactory/hudson.plugins.timestamper.annotator.TimestampAnnotatorFactory3/script.js'></script>\r\n" + 
			"                <link rel='stylesheet' type='text/css' href='/descriptor/hudson.tasks._ant.AntOutcomeNote/style.css' />\r\n" + 
			"                <script src='/descriptor/hudson.tasks._ant.AntTargetNote/script.js'></script>\r\n" + 
			"                <script src='/descriptor/hudson.console.ExpandableDetailsNote/script.js'></script>\r\n" + 
			"                <link rel='stylesheet' type='text/css' href='/descriptor/hudson.console.ExpandableDetailsNote/style.css' />\r\n" + 
			"                <link rel='stylesheet' type='text/css' href='/descriptor/hudson.plugins.gradle.GradleOutcomeNote/style.css' />\r\n" + 
			"                <script src='/descriptor/hudson.plugins.gradle.GradleTaskNote/script.js'></script>\r\n" + 
			"                <link rel='stylesheet' type='text/css' href='/descriptor/hudson.plugins.gradle.GradleTaskNote/style.css' />\r\n" + 
			"                <pre class=\"console-output\">Started by remote host 192.168.110.59\r\n" + 
			"Building in workspace /var/jenkins_home/workspace/GSystem-DS\r\n" + 
			"Checking out a fresh workspace because there's no workspace at /var/jenkins_home/workspace/GSystem-DS\r\n" + 
			"Cleaning local Directory .\r\n" + 
			"Checking out svn://192.168.205.175/GAON_NOVA/trunk/GAON_NOVA at revision '2019-05-27T08:36:40.077 +0000' --quiet\r\n" + 
			"Using sole credentials wsbaek/****** in realm ‘&lt;svn://192.168.205.175:3690&gt; b1181fec-7753-5544-9cf5-930a80150fbb’\r\n" + 
			"At revision 2655\r\n" + 
			"\r\n" + 
			"Using sole credentials wsbaek/****** in realm ‘&lt;svn://192.168.205.175:3690&gt; b1181fec-7753-5544-9cf5-930a80150fbb’\r\n" + 
			"[GSystem-DS] $ /bin/sh -xe /tmp/jenkins8030503445210175714.sh\r\n" + 
			"+ echo     &gt; start to build site code[DS]\r\n" + 
			"    &gt; start to build site code[DS]\r\n" + 
			"+ /var/jenkins_home/tools/hudson.tasks.Maven_MavenInstallation/maven353/bin/mvn clean package\r\n" + 
			"[INFO] Scanning for projects...\r\n" + 
			"[INFO] \r\n" + 
			"[INFO] ------------------------&lt; GAON_NOVA:GAON_NOVA &gt;-------------------------\r\n" + 
			"[INFO] Building GAON_NOVA 0.0.1-SNAPSHOT\r\n" + 
			"[INFO] --------------------------------[ war ]---------------------------------\r\n" + 
			"[INFO] \r\n" + 
			"[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ GAON_NOVA ---\r\n" + 
			"[INFO] \r\n" + 
			"[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ GAON_NOVA ---\r\n" + 
			"[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!\r\n" + 
			"[INFO] Copying 492 resources\r\n" + 
			"[INFO] \r\n" + 
			"[INFO] --- maven-compiler-plugin:3.6.1:compile (default-compile) @ GAON_NOVA ---\r\n" + 
			"[INFO] Changes detected - recompiling the module!\r\n" + 
			"[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!\r\n" + 
			"[INFO] Compiling 234 source files to /var/jenkins_home/workspace/GSystem-DS/target/classes\r\n" + 
			"[WARNING] /var/jenkins_home/workspace/GSystem-DS/src/common/util/SimpleCrypto.java:[9,16] sun.misc.BASE64Decoder is internal proprietary API and may be removed in a future release\r\n" + 
			"[WARNING] /var/jenkins_home/workspace/GSystem-DS/src/common/util/SimpleCrypto.java:[10,16] sun.misc.BASE64Encoder is internal proprietary API and may be removed in a future release\r\n" + 
			"[WARNING] /var/jenkins_home/workspace/GSystem-DS/src/common/util/SimpleCrypto.java:[136,13] sun.misc.BASE64Encoder is internal proprietary API and may be removed in a future release\r\n" + 
			"[WARNING] /var/jenkins_home/workspace/GSystem-DS/src/common/util/SimpleCrypto.java:[136,41] sun.misc.BASE64Encoder is internal proprietary API and may be removed in a future release\r\n" + 
			"[WARNING] /var/jenkins_home/workspace/GSystem-DS/src/common/util/SimpleCrypto.java:[153,17] sun.misc.BASE64Decoder is internal proprietary API and may be removed in a future release\r\n" + 
			"[WARNING] /var/jenkins_home/workspace/GSystem-DS/src/common/util/SimpleCrypto.java:[153,45] sun.misc.BASE64Decoder is internal proprietary API and may be removed in a future release\r\n" + 
			"[INFO] /var/jenkins_home/workspace/GSystem-DS/src/work/sa/mvc/service/SA020110ServiceImpl.java: /var/jenkins_home/workspace/GSystem-DS/src/work/sa/mvc/service/SA020110ServiceImpl.java uses or overrides a deprecated API.\r\n" + 
			"[INFO] /var/jenkins_home/workspace/GSystem-DS/src/work/sa/mvc/service/SA020110ServiceImpl.java: Recompile with -Xlint:deprecation for details.\r\n" + 
			"[INFO] /var/jenkins_home/workspace/GSystem-DS/src/quickstart/mvc/controller/MobileCommonController.java: Some input files use unchecked or unsafe operations.\r\n" + 
			"[INFO] /var/jenkins_home/workspace/GSystem-DS/src/quickstart/mvc/controller/MobileCommonController.java: Recompile with -Xlint:unchecked for details.\r\n" + 
			"[INFO] \r\n" + 
			"[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ GAON_NOVA ---\r\n" + 
			"[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!\r\n" + 
			"[INFO] skip non existing resourceDirectory /var/jenkins_home/workspace/GSystem-DS/src/test/resources\r\n" + 
			"[INFO] \r\n" + 
			"[INFO] --- maven-compiler-plugin:3.6.1:testCompile (default-testCompile) @ GAON_NOVA ---\r\n" + 
			"[INFO] No sources to compile\r\n" + 
			"[INFO] \r\n" + 
			"[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ GAON_NOVA ---\r\n" + 
			"[INFO] No tests to run.\r\n" + 
			"[INFO] \r\n" + 
			"[INFO] --- maven-war-plugin:3.0.0:war (default-war) @ GAON_NOVA ---\r\n" + 
			"[INFO] Packaging webapp\r\n" + 
			"[INFO] Assembling webapp [GAON_NOVA] in [/var/jenkins_home/workspace/GSystem-DS/target/GAON_NOVA-0.0.1-SNAPSHOT]\r\n" + 
			"[INFO] Processing war project\r\n" + 
			"[INFO] Copying webapp resources [/var/jenkins_home/workspace/GSystem-DS/war]\r\n" + 
			"[INFO] Webapp assembled in [61076 msecs]\r\n" + 
			"[INFO] Building war: /var/jenkins_home/workspace/GSystem-DS/target/GAON_NOVA-0.0.1-SNAPSHOT.war\r\n" + 
			"[INFO] ------------------------------------------------------------------------\r\n" + 
			"[INFO] BUILD SUCCESS\r\n" + 
			"[INFO] ------------------------------------------------------------------------\r\n" + 
			"[INFO] Total time: 02:38 min\r\n" + 
			"[INFO] Finished at: 2019-05-27T08:40:41Z\r\n" + 
			"    &gt; complete deploy DS\r\n" + 
			"Hello, guys~!! \r\n" + 
			"The jenkins-GSystem-DS-81:(Rev2655) build has been completed(Successful).\r\n" + 
			"Please check build(\r\n" + 
			"                    <a href='http://192.168.205.213:3500/job/GSystem-DS/81/'>http://192.168.205.213:3500/job/GSystem-DS/81/</a>).\r\n" + 
			"[WS-CLEANUP] Deleting project workspace...[WS-CLEANUP] done\r\n" + 
			"Finished: SUCCESS\r\n" + 
			"                </pre>\r\n" + 
			"            </div>\r\n";
	
	static String html2 = "<pre class=\"console-output\">Started by remote host 192.168.110.59\r\n"
			+ "1 가 낟랒달ㅈ다ㅓ 2312>fwefwef>3123</pre>";
	public static void main(String[] args) {
//        Pattern pattern = Pattern.compile("<pre class=\"console-output\">(\\[^]+)?\\[^>]*(\\/pre>)"); //img 태그 src 추출 정규표현식
//        Pattern pattern = Pattern.compile("(<pre[\\s+]class=\"console-output\"\\[^>]*>)\\[^]*(<\\/pre>)"); //img 태그 src 추출 정규표현식
		//(<pre[\s+]class="console-output"[^>]*>)[^]*(<\/pre>)
//		System.out.println(html);
//		System.out.println(html2);
//        Pattern pattern = Pattern.compile("<pre[\\s]+class=\"console-output\">[\\s\\S]*<\\/pre>");
//        Pattern pattern = Pattern.compile("<pre[\\s]+class=\"console-output\">*");
        Pattern pattern = Pattern.compile("<pre[\\s]+class=\"console-output\">(.+?)</pre>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(html);
        while(matcher.find()){
            System.out.println(matcher.group(1));
//            System.out.println(matcher.group(1));
        }
	}
}
