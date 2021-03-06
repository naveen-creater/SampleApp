# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile






#
#-keep class com.example.rdatabase.ListActivity {
#    <init>(...);
#}
#
#-keep class com.example.rdatabase.Main2Activity {
#    <init>(...);
#}

#-keep class com.example.rdatabase.MainActivity {
#    <init>(...);
#}
#
#-keep class com.example.rdatabase.MainActivity.** {*;}

#-keep class com.example.rdatabase.MainActivity.** { *; }
#-keep class com.example.rdatabase.MainActivity { <init>(); }

# keep the specified class members from being removed or renamed
# only if the class is preserved
#-keepclassmembers class com.example.rdatabase.MainActivity { *; }
#
## keep the class and specified members from being renamed only
#-keepnames class com.example.rdatabase.MainActivity { *; }
#
## keep the specified class members from being renamed only
#-keepclassmembernames class com.example.rdatabase.MainActivity { *; }
#-keep class com.example.rdatabase.ListActivity {
#    <init>(...);
#}



