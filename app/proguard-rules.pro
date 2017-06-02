# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in F:\android_studio_soft\android_sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
-dontshrink
-dontoptimize
-dontwarn com.google.android.maps.**
-dontwarn android.webkit.WebView
-dontwarn com.umeng.**
-dontwarn com.tencent.weibo.sdk.**

-keepattributes Exceptions,InnerClasses,Signature
-keepattributes *Annotation*
-keepattributes SourceFile,LineNumberTable
-keep public interface com.facebook.**
-keep public interface com.tencent.**
-keep public interface com.umeng.socialize.**
-keep public interface com.umeng.socialize.sensor.**
-keep public interface com.umeng.scrshot.**
-keep public class com.umeng.socialize.* {*;}
-keep public class javax.**
-keep public class android.webkit.**
-keep class com.facebook.**
-keep class com.umeng.scrshot.**
-keep public class com.tencent.** {*;}
-keep class com.umeng.socialize.sensor.**
-keep class com.tencent.mm.sdk.modelmsg.WXMediaMessage {*;}
-keep class com.tencent.mm.sdk.modelmsg.** implements com.tencent.mm.sdk.modelmsg.WXMediaMessage$IMediaObject {*;}
-keep class im.yixin.sdk.api.YXMessage {*;}
-keep class im.yixin.sdk.api.** implements im.yixin.sdk.api.YXMessage$YXMessageData{*;}
-keep public class com.pipaw.dashou.security.LeoMaker.**
-keep public class com.pipaw.dashou.R$*{
    public static final int *;
}

-dontwarn com.squareup.**
-keep class com.squareup.** {*;}
-keep class android.support.v4.app.** { *; }
-keep interface android.support.v4.app.** { *; }
-keep class com.google.gson.**{*;}
-dontwarn com.google.gson.**
-dontwarn com.igexin.**
-keep class com.igexin.**{*;}

-keepattributes Signature
-keep class sun.misc.Unsafe { *; }
-keep class com.pipaw.dashou.ui.entity.** { *; }

-ignorewarnings
-keep class com.chukong.cocosplay.**{ *;}
-keep class com.coco.**{ *;}
-keep class android.support.v4.**{ *;}
-keep class android.content.**{ *;}
-keep class android.os.**{ *;}

-dontwarn org.chromium.media.**
-keep class org.chromium.media.** { *;}
-dontwarn org.chromium.**
-keep class org.chromium.** { *;}
-dontwarn org.chromium.**
-keep class org.xwalk.core.** { *;}
-keep class org.xwalk.core.**{*;}



-keepclassmembers class * {
   public <init> (org.json.JSONObject);
}
-keep public class com.pipaw.chuanqi.chuangqiapp.R$*{
public static final int *;
}

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}


-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontpreverify
-verbose
