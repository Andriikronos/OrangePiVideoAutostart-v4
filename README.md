# Orange Pi Video Autostart

Android project for Orange Pi Android 12.

On BOOT_COMPLETED, the app attempts to launch:
- Player: `com.softwinner.TvdVideo/.TvdVideoActivity`
- Video: `/sdcard/Movies/Punto_TV.mp4`

GitHub Actions builds a debug APK and uploads it as an artifact.

Important: a successful APK build does not prove the Orange Pi firmware permits
launching another app's activity from a boot receiver. This must be tested on-device.
