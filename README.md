# What is this?

[![forthebadge](http://forthebadge.com/images/badges/as-seen-on-tv.svg)](http://forthebadge.com)

1. Are you an Android Developer and do you use Android Studio?
2. Do you sometimes click the run button twice within a short period of time but never know which build is currently running on your phone?

This is Bleep. It will help you with that. It can vibrate, beep or show a random view on installation of a new version of the application on your device.

# How to use?

In your landing activity, use the following code (or call only the methods you need)
```
if (BuildConfig.DEBUG){
    Bleeper.getBlepper().beep().move().showVisualIndicator(this);
}
```

Add the following in your root build.gradle at the end of repositories:

```
allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```

Add the following dependency to your build.gradle file

```
dependencies {
     ...
	 compile 'com.github.AdeebNqo:bleep:v1.0'
}
```

# How much?

All this awesomeness costs $00.00
