# Age Widget

A minimal Android home-screen widget that shows your age as "Xy Xm Xd",
counting up from a birth date of **9 October 2002**.

## Project layout
```
AgeWidget/
  app/
    src/main/
      java/com/rathin/agewidget/AgeWidgetProvider.kt   <- the age calculation + widget update logic
      res/layout/age_widget_layout.xml                  <- what the widget looks like
      res/xml/age_widget_info.xml                        <- widget size/update settings
      AndroidManifest.xml
  build.gradle, settings.gradle                          <- project config
```

## How to build (no installs needed — GitHub does the building for you)

1. Create a new repository on github.com (e.g. `age-widget`), public or private, no README needed.
2. Upload every file/folder from this project into that repo (drag-and-drop works
   on the GitHub website — "Add file" > "Upload files").
3. Go to the "Actions" tab of your repo. GitHub will detect the workflow file
   at `.github/workflows/build.yml` and a build will start automatically
   (or click "Run workflow" if it doesn't).
4. Wait a minute or two for the build to go green (checkmark).
5. Click into the finished run, scroll to "Artifacts", and download `AgeWidget-apk`.
   Unzip it — you'll get `app-debug.apk`.
6. Transfer that `.apk` file to your Nothing phone (email it to yourself, or
   upload to Google Drive and download it on your phone).
7. On your phone, tap the `.apk` file to install it. You'll need to allow
   "install from unknown sources" the first time — Android will prompt you
   and guide you through it.
8. Long-press your home screen → Widgets → find "Age Widget" → drag it onto
   your home screen.

## Changing the birth date
Open `AgeWidgetProvider.kt` and edit the `BIRTH_DATE` line. The certificate
date (14 April 2005) is already there, commented out, if you ever want to swap.

## Notes
- Android limits automatic widget refreshes to every 30 minutes minimum
  (`updatePeriodMillis` in `age_widget_info.xml`), which is more than enough
  since the value only changes once a day.
- If `adb devices` shows nothing: check the USB cable supports data transfer,
  and that you tapped "Allow" on the USB debugging prompt on your phone.
