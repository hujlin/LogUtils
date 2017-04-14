# LogUtils
输出日志到本地，可以上传本地日志到服务器
How to

To get a Git project into your build:

gradle

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}Copy
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.hujlin:LogUtils:v1.0.1'
	}
  
  
  Step 1. Add the JitPack repository to your build file

maven

	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>Copy
Step 2. Add the dependency

	<dependency>
	    <groupId>com.github.hujlin</groupId>
	    <artifactId>LogUtils</artifactId>
	    <version>v1.0.1</version>
	</dependency>
